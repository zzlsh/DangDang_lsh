package com.lsh.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsh.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminLogin extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
				
		//判断是否存在登录管理员
		if(loginAdmin == null) {
			System.out.println("拦截器拦截成功，管理员还没有登录");
			return "adminLogin";
		} else {
			ai.invoke();
		}
		return null;
	}
	

}
