package com.lsh.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsh.entity.User;
import com.lsh.service.UserService;
import com.lsh.service.UserServiceImpl;
import com.lsh.util.SecurityCode;
import com.lsh.util.SecurityImage;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	// 接收注册时，传递的用户的信息
	private User newUser;
	// 接收输入的验证码
	private String thisCode;
	//向前台发送错误信息
	private String message;
	//获取前台输入的账号注册码
	private String user_code;
	//获取传入的用户的id
	private String user_id;
	//登录的用户
	private User loginUser;
	
	//获取激活码的方法
	public String getActivationAction(){
		System.out.println("获取验证码的方法");
		//从session中获取注册（登录）用户
		HttpSession session = ServletActionContext.getRequest().getSession();
		User thisUser = (User) session.getAttribute("thisUser");
		System.out.println("需要获取验证码的用户"+thisUser);
		
		UserService usi = new UserServiceImpl();
		usi.sendMail(thisUser);
		//将用户完整信息放进作用域中的对象
		newUser = thisUser;
		
		return Action.SUCCESS;
	}
	
	// 注册方法
	public String registAction() {
		//判断验证码的正确与否
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code = (String) session.getAttribute("thisCode");
		System.out.println("用户输入的验证码："+thisCode);
		System.out.println("程序提供的验证码："+code);
		try {
			if(!thisCode.equals(code)) {
				//验证码输入错误
				throw new RuntimeException("验证码错误");
			} else {
				//验证码输入正确
				//调用service方法，将新的用户进行添加
				UserService usi = new UserServiceImpl();
				usi.registOneUser(newUser);
				
				return Action.SUCCESS;
			}			
		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
			return Action.ERROR;
		}
	}
	
	//账户激活方法
	public String activationUser(){
		//从session作用域中取出系统提供的注册码
		HttpSession session = ServletActionContext.getRequest().getSession();
		String activationNum = (String) session.getAttribute("activationNum");
		System.out.println("已注册--现在在激活方法");
		System.out.println("输入的注册码："+user_code);
		System.out.println("对应的用户的id："+user_id);
		
		UserService usi = new UserServiceImpl();
		try {
			//判断用户输入的注册码和系统提供的注册码是否相同
			if(!activationNum.equals(user_code)) {
				//输入的注册码不正确
				throw new RuntimeException("注册码输入错误");
			} else {
				//注册码正确
				//调用service方法，将注册码填入用户信息				
				usi.fullUser(user_code, user_id);
				
				//查询用户所有的信息
				//作为展示				
				loginUser = usi.queryOneUser(user_id);
				//同时也是session作用域中的登录对象
				session.setAttribute("loginUser", loginUser);
				
				return Action.SUCCESS;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			newUser = usi.queryOneUser(user_id);
			message = e.getMessage();
			return Action.ERROR;
		}		
		
	}
	
	

	// 登录方法
	public String loginAction() {
		System.out.println("点击登录，传递的用户的信息："+loginUser);
		//调用service方法验证用户信息
		UserService usi = new UserServiceImpl();
		try {
			usi.loginUser(loginUser);
			System.out.println("登录成功");
			return Action.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
			System.out.println("错误信息："+message);
			return Action.ERROR;
		}		
	}

	// 获取验证码
	public String getCode() {
		// 通过工具类获取验证码
		String thisCode = SecurityCode.getSecurityCode();
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("thisCode", thisCode);
		// 生成验证码照片
		BufferedImage bfi = SecurityImage.createImage(thisCode);

		// 通过一个响应将照片通过流对象，向页面进行传递
		OutputStream os = null;
		try {
			os = ServletActionContext.getResponse().getOutputStream();
			// 通过照片流将照片进行传递
			// 验证码的照片 验证码数值 流对象
			ImageIO.write(bfi, "png", os);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 不需要有返回值，所以返回一个null
		return null;
	}
	
	//登出方法
	public String outLoginAction(){
		
		UserService usi = new UserServiceImpl();
		usi.outLogin();
		
		return Action.SUCCESS;
	}

	
	
	
	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public String getThisCode() {
		return thisCode;
	}

	public void setThisCode(String thisCode) {
		this.thisCode = thisCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}


	
}
