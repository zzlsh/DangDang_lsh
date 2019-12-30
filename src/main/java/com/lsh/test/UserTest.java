package com.lsh.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lsh.dao.UserDAO;
import com.lsh.entity.User;
import com.lsh.service.UserService;
import com.lsh.service.UserServiceImpl;
import com.lsh.util.MD5Utils;
import com.lsh.util.MyBatisUtil;
import com.lsh.util.SendEmailUtil;

public class UserTest {
	
	@Test
	public void myTest1(){
		//注册方法
		UserService usi = new UserServiceImpl();
		
		User registUser = new User();
		registUser.setUser_id(UUID.randomUUID().toString());
		registUser.setUser_nickname("海王");
		registUser.setUser_password("666");
		registUser.setUser_status("激活");
		registUser.setUser_email("haiwang@163.com");
		registUser.setUser_code("87Y9C");
		registUser.setSalt("盐");
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		registUser.setRegist_date(sqlDate);
		
		usi.registOneUser(registUser);
		
	}
	
	
	@Test
	public void myTest2(){
		SendEmailUtil.sendMessage("975373964@qq.com", MD5Utils.getNum());
	}
	
	@Test
	public void myTest3(){
		System.out.println(MD5Utils.getPassword("111111li"));
	}
	
	@Test
	public void myTest4(){
		UserServiceImpl usi = new UserServiceImpl();
		User loginUser = new User();
		loginUser.setUser_email("13223055242@163.com");
		loginUser.setUser_password("666666");
		usi.loginUser(loginUser);
		System.out.println("-----------");
	}
	
	@Test
	public void myTest5(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		User loginUser = new User();
		loginUser.setUser_email("13223055242@163.com");
		User loginUser2 = userDAO.loginUser(loginUser);
		System.out.println(loginUser2);
	}
}
