package com.lsh.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lsh.dao.OrderDAO;
import com.lsh.entity.Order;
import com.lsh.entity.User;
import com.lsh.util.MyBatisUtil;

public class OrderServiceImpl implements OrderService {

	@Override
	//查询所有订单--包括所有字段
	public List<Order> selectAllOrder() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
		
		List<Order> selectAllOrder = orderDAO.selectAllOrder();
		
		//关闭资源
		MyBatisUtil.close(sqlSession);
		return selectAllOrder;
	}

	@Override
	//根据订单id查询单个订单的全部信息
	public Order queryOneOrder(String order_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
		Order queryOrder = orderDAO.queryOneOrder(order_id);
		
		MyBatisUtil.close(sqlSession);
		return queryOrder;
	}

	@Override
	//查询所有用户的方法
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
		List<User> allUser = orderDAO.selectAllUser();
		
		MyBatisUtil.close(sqlSession);
		return allUser;
	}

	@Override
	//修改用户信息的方法
	public void updateOneUser(String user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
		try {
			String user_status = "正常";
			//调用dao方法
			//查询用户状态
			User queryUser = orderDAO.queryStatus(user_id);
			System.out.println("需要修改状态的用户："+queryUser);
			if(queryUser.getUser_status().equals("正常")) {
				user_status = "冻结";
			}
			orderDAO.updateOneUser(user_id,user_status);
			MyBatisUtil.commit(sqlSession);
		} catch (Exception e) {
			// TODO: handle exception
			MyBatisUtil.rollback(sqlSession);
		}
	}
	
}
