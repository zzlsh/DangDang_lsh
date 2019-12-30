package com.lsh.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.lsh.entity.Address;
import com.lsh.entity.User;
import com.lsh.service.FrontOrderService;
import com.lsh.service.FrontOrderServiceImpl;

public class FrontOrderTest {
	@Test
	public void myTest1(){
		FrontOrderService frontOrderServiceImpl = new FrontOrderServiceImpl();
		User loginUser = new User();
		loginUser.setUser_id("2677b712-830c-4515-a1b6-c4d49f16feed");
		
		List<Address> allAddress = frontOrderServiceImpl.selectAllAddressById(loginUser);
		System.out.println(allAddress.size());
	}
	
	@Test
	public void myTest2(){
		FrontOrderService frontOrderServiceImpl = new FrontOrderServiceImpl();
		Address oneAddress = frontOrderServiceImpl.queryOneAddress("029181");
		System.out.println(oneAddress);
	}
	
	@Test
	public void myTest3(){
		FrontOrderService frontOrderServiceImpl = new FrontOrderServiceImpl();
		Address newAddress = new Address();
		newAddress.setAdd_id("029181");
		newAddress.setAdd_local("河南郑州");
		newAddress.setAdd_postcode("0371");
		newAddress.setAdd_recipients("李少涵");
		newAddress.setAdd_tel("13223055242");
		frontOrderServiceImpl.updateOneAddress(newAddress);
	}
	
	@Test
	public void myTest4(){
		FrontOrderService frontOrderServiceImpl = new FrontOrderServiceImpl();
		Address newAddress = new Address();
		newAddress.setAdd_id(UUID.randomUUID().toString());
		newAddress.setAdd_local("河南郑州");
		newAddress.setAdd_postcode("0371");
		newAddress.setAdd_recipients("吴帆");
		newAddress.setAdd_tel("15893809060");
		newAddress.setUser_id("2677b712-830c-4515-a1b6-c4d49f16feed");
		frontOrderServiceImpl.addNewAddress(newAddress);
	}
}
