package com.lsh.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsh.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class UserLogin extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		//判断是否存在登录用户
		if(loginUser == null) {
			System.out.println("拦截器拦截成功，用户还没有登录");
			return "userLogin";
		} else {
			//判断用户是否拥有激活码
			if(loginUser.getUser_code()==null || loginUser.getUser_code().equals("")) {
				return "userActive";
			} else {
				ai.invoke();
			}
		}
		return null;
	}
	
}
