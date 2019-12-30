package com.lsh.test;

import java.util.List;

import org.junit.Test;

import com.lsh.entity.Order;
import com.lsh.entity.User;
import com.lsh.service.OrderService;
import com.lsh.service.OrderServiceImpl;

public class OrderTest {
	@Test
	public void myTest1(){
		OrderService osi = new OrderServiceImpl();
		Order thisOrder = osi.queryOneOrder("b4c1cfbe-918c-44d7-b4f7-f7d2b4317e51");
		
		System.out.println(thisOrder);
	}
	
	@Test
	public void myTest2(){
		OrderService osi = new OrderServiceImpl();
		List<User> allUser = osi.selectAllUser();
		
		for (User user : allUser) {
			System.out.println(user);
		}
	}
	
	@Test
	public void myTest3(){
		OrderService osi = new OrderServiceImpl();
		osi.updateOneUser("f547ea8e-771b-43a3-b32d-b8fbc54fc55f");
	}
	
	@Test
	public void myTest4(){
		OrderService osi = new OrderServiceImpl();
		osi.updateOneUser("f547ea8e-771b-43a3-b32d-b8fbc54fc55f");
		
	}
}
