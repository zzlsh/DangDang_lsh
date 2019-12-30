package com.lsh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.lsh.dao.AdminDAO;
import com.lsh.entity.Book;
import com.lsh.entity.Cart;
import com.lsh.entity.Sort;
import com.lsh.util.MyBatisUtil;

public class FrontServiceImpl implements FrontService {

	@Override
	//查询所有一级类别和所拥有的二级类别
	public List<Sort> selectFirstWithSecond() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		List<Sort> firstAndSecond = adminDAO.selectFirstAndSecond();
		for (Sort sort : firstAndSecond) {
			System.out.println("frontServiceImpl中的类别："+sort);
		}
		MyBatisUtil.close(sqlSession);
		return firstAndSecond;
	}
	
	@Override
	//购物车的添加
	public void addBuyInBook(Book buyBook){
		//获取 session作用域
		HttpSession session = ServletActionContext.getRequest().getSession();
		//获取这本书的所有信息
		BookService bsi = new BookServiceImpl();
		Book thisBuyBook = bsi.queryOneBook(buyBook);
		System.out.println("需要添加进购物车的书籍："+thisBuyBook);
		
		//判断购物车是否存在
		Cart thisCart = (Cart) session.getAttribute("thisCart");
		if(thisCart == null) {
			//第一次向购物车中添加书籍
			//为购物车创建对象
			thisCart = new Cart();
			//将新购买的书籍传给购物车中的书籍集合
			//第一次添加该书籍，默认数量为1
			Map<Book, Integer> booksMap = thisCart.getBooks();
			//为购物车中的书籍集合创建对象
			booksMap = new HashMap<Book, Integer>();
			booksMap.put(thisBuyBook, 1);
			//将书籍集合重新加入购物车
			thisCart.setBooks(booksMap);
			System.out.println("当前购物车："+thisCart);
			
			//设置总价
			thisCart.setTotal(thisBuyBook.getBook_dangdang_price());
			//设置优惠价格
			thisCart.setDiscounts(thisBuyBook.getBook_original_price() - thisBuyBook.getBook_dangdang_price());	
			
			//将购物车加入session作用域
			session.setAttribute("thisCart", thisCart);
		} else {
			System.out.println("购物车已存在");
			//购物车已经存在
			//判断当前添加的书籍在购物车中是否已存在
			Map<Book, Integer> booksMap = thisCart.getBooks();
			if(booksMap.containsKey(thisBuyBook)) {
				//当前书籍已经在购物车中存在
				//当前书籍的购买个数+1
				Integer oldNum = booksMap.get(thisBuyBook);//该书籍在购物车中旧的数量
				System.out.println("已存在的书籍数量："+oldNum);
				booksMap.put(thisBuyBook, oldNum + 1);
				//将新的Map集合重新赋值给购物车
				thisCart.setBooks(booksMap);
				
				//获取新的总价
				Double oldTotal = thisCart.getTotal();//购物车中旧的总价
				thisCart.setTotal(oldTotal + thisBuyBook.getBook_dangdang_price());
				
				//获取新的优惠价格
				Double oldDiscounts = thisCart.getDiscounts();//购物车中旧的优惠价格
				thisCart.setDiscounts(oldDiscounts + (thisBuyBook.getBook_original_price() - thisBuyBook.getBook_dangdang_price()));
				System.out.println("当前购物车："+thisCart);
				//将购物车重新加入session作用域，覆盖原本的购物车
				session.setAttribute("thisCart", thisCart);
			} else {
				//当前书籍在购物车中不存在
				//需要第一次添加该书籍
				//第一次添加该书籍，默认数量为 1
				booksMap.put(thisBuyBook, 1);
				//将新的Map集合重新赋值给购物车
				thisCart.setBooks(booksMap);
				
				//设置新的总价
				Double oldTotal = thisCart.getTotal();//购物车中旧的总价
				thisCart.setTotal(oldTotal + thisBuyBook.getBook_dangdang_price());
				
				//设置新的优惠价格
				Double oldDiscounts = thisCart.getDiscounts();//购物车中旧的优惠价格
				thisCart.setDiscounts(oldDiscounts + (thisBuyBook.getBook_original_price() - thisBuyBook.getBook_dangdang_price()));
				System.out.println("当前购物车："+thisCart);
				//将购物车重新加入session作用域，覆盖原本的购物车
				session.setAttribute("thisCart", thisCart);
			}
			
		}
		
	}

	@Override
	//购物车的变更
	public void changBuyBook(Book buyBook, String changeNum) {
		// TODO Auto-generated method stub
		//获取session作用域
		HttpSession session = ServletActionContext.getRequest().getSession();
		BookService bsi = new BookServiceImpl();
		//1.查询书籍的完整信息
		Book needBuyBook = bsi.queryOneBook(buyBook);
		//2.从session作用域中获取购物车
		Cart thisCart = (Cart) session.getAttribute("thisCart");
		//3.判断变更的数量是否 <= 库存
		Integer book_inventory = Integer.valueOf(needBuyBook.getBook_inventory());//库存
		Integer newNum = Integer.valueOf(changeNum);//希望变更的数量
		if(book_inventory >= newNum) {
			//库存大于等于希望变更的数量
			//4.将该书籍新的数量添加进购物车
			//购物车中的旧的书籍们
			Map<Book, Integer> books = thisCart.getBooks();
			//5.获取旧的该书籍的购买个数
			Integer oldNum = books.get(needBuyBook);
			
			if(changeNum.equals("0")) {
				//删除方法，删除后，将书籍从session中删除
				books.remove(needBuyBook);
			} else {
				//6.将该书籍新的数量覆盖进书籍集合
				books.put(needBuyBook, newNum);				
			}
			
			//将新的书籍们重新加入购物车
			thisCart.setBooks(books);
			
			//7.旧的总价减去旧的该书籍的价格和------加上该书籍新的价格和
			thisCart.setTotal(thisCart.getTotal() + (newNum - oldNum) * needBuyBook.getBook_dangdang_price());
			//8.旧的优惠价格减去旧的该书籍的优惠价格和----加上该书籍新的优惠价格和
			thisCart.setDiscounts(thisCart.getDiscounts() + (newNum - oldNum) * (needBuyBook.getBook_original_price() - needBuyBook.getBook_dangdang_price()));
			
			if(books.size() == 0) {
				//删除方法，删除后，如果购物车书籍个数为0，移除session中的购物车
				session.removeAttribute("thisCart");
			} else {
				//9.将改变过的购物车重新放入session作用域
				session.setAttribute("thisCart", thisCart);
			}			
		} else {
			//库存不足
			throw new RuntimeException("库存不足");
		}
		
	}

}
