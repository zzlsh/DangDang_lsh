package com.lsh.service;

import java.util.List;

import com.lsh.entity.Order;
import com.lsh.entity.User;

public interface OrderService {
	
	//查询所有订单--包括所有字段的方法
	public List<Order> selectAllOrder();
	
	//根据订单id查询单个订单的全部信息
	public Order queryOneOrder(String order_id);
	
	//查询所有用户的方法
	public List<User> selectAllUser();
	
	//修改用户信息的方法
	public void updateOneUser(String user_id);
}
