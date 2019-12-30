package com.lsh.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.lsh.dao.FrontOrderDAO;
import com.lsh.entity.Address;
import com.lsh.entity.Book;
import com.lsh.entity.Cart;
import com.lsh.entity.Order;
import com.lsh.entity.OrderConn;
import com.lsh.entity.User;
import com.lsh.util.MyBatisUtil;

public class FrontOrderServiceImpl implements FrontOrderService {

	@Override
	public List<Address> selectAllAddressById(User loginUser) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FrontOrderDAO frontOrderDAO = sqlSession.getMapper(FrontOrderDAO.class);
		
		List<Address> allAddress = frontOrderDAO.selectAllAddressById(loginUser);
		
		MyBatisUtil.close(sqlSession);
		return allAddress;
	}
	
	//根据地址id查询一个地址的所有信息
	public Address queryOneAddress(String address){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FrontOrderDAO frontOrderDAO = sqlSession.getMapper(FrontOrderDAO.class);
		
		Address oneAddress = frontOrderDAO.queryOneAddress(address);
		
		MyBatisUtil.close(sqlSession);
		return oneAddress;
	}
	
	//添加一个新地址
	public void addNewAddress(Address newAddress){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FrontOrderDAO frontOrderDAO = sqlSession.getMapper(FrontOrderDAO.class);
		frontOrderDAO.addNewAddress(newAddress);
		MyBatisUtil.commit(sqlSession);
	}
	
	//根据地址id修改一个地址的信息
	public void updateOneAddress(Address newAddress){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FrontOrderDAO frontOrderDAO = sqlSession.getMapper(FrontOrderDAO.class);
		frontOrderDAO.updateOneAddress(newAddress);
		MyBatisUtil.commit(sqlSession);
	}
	
	//处理订单数据
	public Order dealOrder(Address oneAddress){
		System.out.println("订单入库方法中收到的当前地址："+oneAddress);
		//从session中获取当前购物车
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart thisCart = (Cart) session.getAttribute("thisCart");
		User loginUser = (User) session.getAttribute("loginUser");
		//完善订单表
		Order newOrder = new Order();
		
		newOrder.setOrder_id(UUID.randomUUID().toString());//UUID作为订单id
		java.util.Date date = new java.util.Date();
		
		newOrder.setOrder_serial(String.valueOf(date.getTime()));//当前时间的long形式作为订单编号
		newOrder.setOrder_total(thisCart.getTotal());//总价
		newOrder.setOrder_status("完成交易");//状态
		newOrder.setUser_id(loginUser.getUser_id());//用户id
		newOrder.setAdd_recipients(oneAddress.getAdd_recipients());//收件人
		newOrder.setAdd_local(oneAddress.getAdd_local());//详细地址
		newOrder.setOrder_date(date);//系统当前时间
		
		//调用dao方法，将订单入库
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FrontOrderDAO frontOrderDAO = sqlSession.getMapper(FrontOrderDAO.class);
		frontOrderDAO.addNewOrder(newOrder);
		System.out.println("订单成功入库");
		
		MyBatisUtil.commit(sqlSession);
		return newOrder;
	}
	
	//处理订单关联表
	public void dealConnOrder(Order newOrder){
		System.out.println("处理订单关联表接收到的新建订单："+newOrder);
		//从session中获取登录对象---以及购物车
		HttpSession session = ServletActionContext.getRequest().getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		Cart thisCart = (Cart) session.getAttribute("thisCart");
		
		Map<Book, Integer> books = thisCart.getBooks();
		Set<Book> booksKey = books.keySet();
		//调用dao方法，关联表入库
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FrontOrderDAO frontOrderDAO = sqlSession.getMapper(FrontOrderDAO.class);
		try {
			//便利购物车中的书籍集合得到的书的集合
			for (Book book : booksKey) {
				//创建一个新的关联表对象---并存入数据
				OrderConn newOrderConn = new OrderConn();
				newOrderConn.setConn_id(UUID.randomUUID().toString());
				newOrderConn.setOrder_id(newOrder.getOrder_id());
				newOrderConn.setBook_id(book.getBook_id());
				newOrderConn.setBook_name(book.getBook_name());
				newOrderConn.setBook_num(String.valueOf(books.get(book)));
				newOrderConn.setConn_original_price(book.getBook_original_price());
				newOrderConn.setConn_dangdang_price(book.getBook_dangdang_price());
				newOrderConn.setBook_cover(book.getBook_cover());
				newOrderConn.setConn_date(new Date());
				System.out.println("订单项表中加入的数据："+newOrderConn);
				
				frontOrderDAO.dealConnOrder(newOrderConn);
			}			
			MyBatisUtil.commit(sqlSession);
			System.out.println("本次订单项表全部添加进库表了");
		} catch (Exception e) {
			// TODO: handle exception
			MyBatisUtil.rollback(sqlSession);
		}
		
	}
	
	//处理书籍表---书籍表修改
	public Double dealBooks(){
		//从session中获取对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart thisCart = (Cart) session.getAttribute("thisCart");
		
		Map<Book, Integer> books = thisCart.getBooks();
		Set<Book> booksKey = books.keySet();
		//获取dao
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FrontOrderDAO frontOrderDAO = sqlSession.getMapper(FrontOrderDAO.class);
		try {
			for (Book book : booksKey) {
				//设置新的库存
				String oldInventory = book.getBook_inventory();
				book.setBook_inventory(String.valueOf(Integer.valueOf(oldInventory) - Integer.valueOf(books.get(book))));
				frontOrderDAO.dealOneBook(book);
			}
			MyBatisUtil.commit(sqlSession);
		} catch (Exception e) {
			// TODO: handle exception
			MyBatisUtil.rollback(sqlSession);
		}
		//移除购物车
		session.removeAttribute("thisCart");
		
		return thisCart.getTotal();
	}
}
