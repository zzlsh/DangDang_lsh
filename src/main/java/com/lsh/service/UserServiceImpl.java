package com.lsh.service;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.lsh.dao.UserDAO;
import com.lsh.entity.User;
import com.lsh.util.MD5Utils;
import com.lsh.util.MyBatisUtil;
import com.lsh.util.SendEmailUtil;

public class UserServiceImpl implements UserService {

	@Override
	//根据id查询一个用户的方法
	public User queryOneUser(String user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		
		User loginUser = userDAO.queryOneUser(user_id);
		
		MyBatisUtil.commit(sqlSession);
		
		return loginUser;
	}

	@Override
	//注册方法
	public void registOneUser(User registUser) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		
		System.out.println("userServiceImpl中的注册方法--需要注册的用户："+registUser);
		//给用户一个唯一标识-----user_id
		registUser.setUser_id(UUID.randomUUID().toString());
		
		//获取一个盐--赋值给用户
		String newSalt = MD5Utils.getSalt();
		registUser.setSalt(newSalt);
		
		//设定用户的状态----激活
		registUser.setUser_status("正常");
		
		//设定用户的账号创建时间
		Date utilDate = new java.util.Date();
		System.out.println("给用户添加的创建时间："+utilDate);
		registUser.setRegist_date(utilDate);
		
		//设置用户的密码
		//将-----明文密码和盐进行组合----做出一个md5密码
		String endPassword = MD5Utils.getPassword(registUser.getUser_password() + newSalt);
		
		registUser.setUser_password(endPassword);
		
		System.out.println("新注册的用户最终的信息："+registUser);
		
		//将新注册的用户放进session作用域
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("thisUser", registUser);
		
		userDAO.registOneUser(registUser);
		
		//关闭资源
		MyBatisUtil.commit(sqlSession);
	}
	
	//发送验证码的方法
	public void sendMail(User thisUser){
		String activationNum = MD5Utils.getNum();
		SendEmailUtil.sendMessage(thisUser.getUser_email(), activationNum);
		
		//将注册码放进session作用域
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("activationNum", activationNum);
	}
	
	//将注册码填入用户信息的方法                            注册码                            用户--包含id
	public void fullUser(String user_code, String user_id) {
		//调用dao的修改方法
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		userDAO.fullUser(user_code, user_id);
		
		//删除session作用域中的注册码
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("activationNum");
		
		MyBatisUtil.commit(sqlSession);
	}
	
	//登录方法
	public void loginUser(User loginUser){
		//调用dao的修改方法
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		User realUser = userDAO.loginUser(loginUser);
		
		//判断是否有返回对象
		if(realUser == null) {
			MyBatisUtil.close(sqlSession);
			throw new RuntimeException("该用户不存在");
		} else {
			//判断密码是否正确
			//获取用户的盐属性值
			String realSalt = realUser.getSalt();
			//将盐属性值和输入的密码拼接，通过工具类进行翻译----将明文密码转换为md5类型的密码
			String thisPassword = MD5Utils.getPassword(loginUser.getUser_password()+realSalt);
			System.out.println("输入的密码组合："+thisPassword);
			System.out.println("实际密码："+realUser.getUser_password());
			if(!thisPassword.equals(realUser.getUser_password())) {
				//密码输入错误
				MyBatisUtil.close(sqlSession);
				throw new RuntimeException("密码输入错误");
			} else {
				//将正确且完整的用户信息存入session作用域
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("loginUser", realUser);
				MyBatisUtil.close(sqlSession);
			}
			
		}
		
		
	}
	
	//登出方法
	public void outLogin(){
		//从session作用域中取出登陆的用户
		//删除用户数据
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginUser");
	}
}
