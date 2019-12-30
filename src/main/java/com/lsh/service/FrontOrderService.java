package com.lsh.service;

import java.util.List;

import com.lsh.entity.Address;
import com.lsh.entity.Order;
import com.lsh.entity.User;

public interface FrontOrderService {
	
	/**根据登录用户的id查询其所有的地址
	 * @param loginUser
	 * @return
	 */
	public List<Address> selectAllAddressById(User loginUser);
	
	//根据地址id查询一个地址的所有信息
	public Address queryOneAddress(String address);
	
	//添加一个新地址
	public void addNewAddress(Address newAddress);
	
	//根据地址id修改一个地址的信息
	public void updateOneAddress(Address newAddress);
	
	//处理订单数据--订单入库
	public Order dealOrder(Address oneAddress);
	
	//处理订单关联表--关联表入库
	public void dealConnOrder(Order newOrder);
	
	//处理书籍表---书籍表修改
	public Double dealBooks();
}
