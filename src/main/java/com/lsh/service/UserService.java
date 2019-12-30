package com.lsh.service;

import com.lsh.entity.User;

public interface UserService {
	// 登录方法
	public User queryOneUser(String user_id);

	// 注册方法
	public void registOneUser(User registUser);
	
	//发送注册码的方法
	public void sendMail(User thisUser);
	
	//将注册码填入用户信息的方法                            注册码                            用户--包含id
	public void fullUser(String user_code, String user_id);
	
	//登录方法
	public void loginUser(User loginUser);
	
	//登出方法
	public void outLogin();
}
