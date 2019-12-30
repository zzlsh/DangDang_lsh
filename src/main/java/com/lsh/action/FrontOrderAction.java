package com.lsh.action;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsh.entity.Address;
import com.lsh.entity.Cart;
import com.lsh.entity.Order;
import com.lsh.entity.User;
import com.lsh.service.FrontOrderService;
import com.lsh.service.FrontOrderServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FrontOrderAction extends ActionSupport {
	//获取登陆的用户的所有的地址
	private List<Address> allAddress;
	//下拉框中选择的地址
	private String address;
	//默认添加的地址信息
	private Address oneAddress;
	//生成的订单
	private Order newOrder;
	//传递总金额
	private Double total;
	
	//根据登录用户的id查询其所有的地址信息
	public String queryAllAddressByIdAction(){
		FrontOrderService fosi = new FrontOrderServiceImpl();
		//从session中取出登陆的用户
		HttpSession session = ServletActionContext.getRequest().getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		allAddress = fosi.selectAllAddressById(loginUser);
		
		//判断是否有address--选择地址
		if(address != null) {
			//根据地址的id查询单个地址的信息
			oneAddress = fosi.queryOneAddress(address);
			System.out.println("选择的地址："+oneAddress);
		}
		
		return Action.SUCCESS;
	}
	
	
	//确定地址时，接收前台的数据
	public String placeOrderAction(){
		System.out.println("接收到的前台地址信息："+oneAddress);
		//获取登陆的用户
		HttpSession session = ServletActionContext.getRequest().getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		FrontOrderService fosi = new FrontOrderServiceImpl();
		//判断是否是已存在的地址
		if(oneAddress.getAdd_id() == null) {
			//新的地址
			//将地址与登录的用户进行绑定
			oneAddress.setUser_id(loginUser.getUser_id());
			oneAddress.setAdd_id(UUID.randomUUID().toString());
			//将新地址入库
			fosi.addNewAddress(oneAddress);
		} else {
			//已存在的地址
			//判断地址信息是否发生改变
			//1.根据地址id；获取旧的地址所有信息			
			Address oldAddress = fosi.queryOneAddress(oneAddress.getAdd_id());
			System.out.println("已存在的地址    旧的地址信息："+oldAddress);
			//2.将传进来的地址信息和旧的信息进行比较----如果相同则不做改变---不同则覆盖
			if(!oldAddress.equals(oneAddress)){
				//地址信息改变
				//调用地址信息修改方法
				System.out.println("新旧地址不同需要进行修改");
				fosi.updateOneAddress(oneAddress);
			}
		}
		
		return Action.SUCCESS;
	}
	
	//处理订单数据
	public String dealOrderAction(){
		System.out.println("处理订单数据方法--当前地址信息："+oneAddress);
		//调用业务方法
		FrontOrderService fosi = new FrontOrderServiceImpl();
		//处理订单数据
		newOrder = fosi.dealOrder(oneAddress);
		//处理订单关联表
		fosi.dealConnOrder(newOrder);
		//处理书籍表--获取总金额
		total = fosi.dealBooks();
		
		
		return Action.SUCCESS;
	}


	public List<Address> getAllAddress() {
		return allAddress;
	}


	public void setAllAddress(List<Address> allAddress) {
		this.allAddress = allAddress;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Address getOneAddress() {
		return oneAddress;
	}


	public void setOneAddress(Address oneAddress) {
		this.oneAddress = oneAddress;
	}


	public Order getNewOrder() {
		return newOrder;
	}


	public void setNewOrder(Order newOrder) {
		this.newOrder = newOrder;
	}
	
	
	
}
