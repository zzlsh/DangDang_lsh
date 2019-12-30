package com.lsh.action;

import java.util.List;

import com.lsh.entity.Order;
import com.lsh.entity.User;
import com.lsh.service.OrderService;
import com.lsh.service.OrderServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	//所有符合条件的订单的全部信息
	private List<Order> allOrder;
	//展示单个订单需要的订单id
	private String order_id;
	//将单个订单中的全部信息以订单对象的形式进行传递
	private Order queryOrder;
	//查询所有用户
	private List<User> allUser;
	//接收用户id
	private String user_id;
	
	
	
	//展示所有订单的方法
	public String selectAllOrderAction(){
		OrderService osi = new OrderServiceImpl();
		allOrder = osi.selectAllOrder();
		
		return Action.SUCCESS;
	}
	
	//根据订单id查询订单详情的方法
	public String queryOneOrderAction(){
		System.out.println("根据订单id查询单个订单的全部信息："+order_id);
		OrderService osi = new OrderServiceImpl();
		queryOrder = osi.queryOneOrder(order_id);
		
		return Action.SUCCESS;
	}
	
	//查询所有用户的方法
	public String selectAllUserAction(){
		OrderService osi = new OrderServiceImpl();
		//判断用户id是否为空
		//因为查询和修改用的同一个方法
		//如果为空，则为查询------如果不为空，则为修改，之后再查询
		System.out.println("需要修改的用户的id："+user_id);
		if(user_id != null) {
			System.out.println("需要修改一个用户的信息");
			osi.updateOneUser(user_id);
			System.out.println("修改状态完毕");
		}
		allUser = osi.selectAllUser();
		
		return Action.SUCCESS;
	}

	
	public List<Order> getAllOrder() {
		return allOrder;
	}

	public void setAllOrder(List<Order> allOrder) {
		this.allOrder = allOrder;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Order getQueryOrder() {
		return queryOrder;
	}

	public void setQueryOrder(Order queryOrder) {
		this.queryOrder = queryOrder;
	}

	public List<User> getAllUser() {
		return allUser;
	}

	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
