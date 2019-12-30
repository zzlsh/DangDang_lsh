package com.lsh.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lsh.entity.Admin;
import com.lsh.entity.Book;
import com.lsh.entity.Sort;
import com.lsh.service.AdminService;
import com.lsh.service.AdminServiceImpl;
import com.lsh.util.SecurityCode;
import com.lsh.util.SecurityImage;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private Admin admin;
	// 接收页面传递的异常信息
	private String message;
	// 接收验证码
	private String thiscode;
	// 接收所有类别的方法
	private List<Sort> allSort_list;
	// 接收--传递数据
	private Sort useSort;
	// 添加的二级标签所属的一级标签
	private Sort fatherSort;
	// 从数据库中查询到的所有的一级标签
	private List<Sort> allFirstList;

	// 登陆方法
	public String adminLoginAction() {
		// 判断验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code = (String) session.getAttribute("thisCode");
		System.out.println("用户输入的验证码：" + thiscode);
		System.out.println("页面的验证码：" + code);
		try {
			// 验证码输入错误，创建一个异常
			if (!code.equals(thiscode))
				throw new RuntimeException("验证码错误");

			// 继续执行
			AdminService adi = new AdminServiceImpl();
			// 调用service方法
			adi.loginAdmin(admin);
			// 出现异常说明有问题，进入catch中，否则继续执行

			return "login_seccess";
		} catch (Exception e) {
			System.out.println("错误信息：" + e.getMessage());
			message = e.getMessage();

			return "login_wrong";
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

	// 安全退出方法
	public String safeOut() {
		// 获取session作用域
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginAdmin");

		return "safe_out";
	}

	// 展示所有类别的方法
	public String showAllSortAction() {
		// 调用service方法
		AdminServiceImpl asi = new AdminServiceImpl();
		allSort_list = asi.selectAllSort();

		return Action.SUCCESS;
	}

	// 添加一级标题的方法
	public String addFirstSortAction() {
		System.out.println("新添加的一级标题：" + useSort.getSort_name());
		// 接收到的新的一级标题存在newFirstSort中
		// 直接调用service方法进行添加
		AdminServiceImpl asi = new AdminServiceImpl();
		// 方法中可能会产生异常
		// 需要trycatch一下
		try {
			asi.addFirstSort(useSort);

			return Action.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
			System.out.println("添加一级标题的异常：" + message);
			return Action.ERROR;
		}
	}

	// 查询所有一级类别的方法
	public String selectAllFirstSort() {
		AdminServiceImpl asi = new AdminServiceImpl();
		allFirstList = asi.selectAllFirstSort();
		return Action.SUCCESS;
	}

	// 添加二级标题的方法
	public String addSecondSortAction() {
		// 要求：页面传递进来新的二级标签，还有所属的以及标签的id
		AdminServiceImpl asi = new AdminServiceImpl();
		System.out.println("添加的二级标题：" + useSort);
		System.out.println("添加的二级标题所属的一级标题：" + fatherSort);
		try {
			asi.addSecondSort(useSort, fatherSort);

			return Action.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
			return Action.ERROR;
		}

	}

	// 删除一级类别的方法
	public String deleteSortAction() {
		// 传进来本身的id还有他的级别--判断调用哪个方法
		// useSort
		System.out.println(useSort);
		AdminServiceImpl asi = new AdminServiceImpl();
		if (useSort.getSort_rank().equals("1")) {
			// 这是个一级类别
			asi.deleteFSort(useSort);
		} else {
			// 这是二级类别
			asi.deleteSSort(useSort);
		}
		return Action.SUCCESS;
	}

	
	
	
	
	
	
	
	
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getThiscode() {
		return thiscode;
	}

	public void setThiscode(String thiscode) {
		this.thiscode = thiscode;
	}

	public List<Sort> getAllSort_list() {
		return allSort_list;
	}

	public void setAllSort_list(List<Sort> allSort_list) {
		this.allSort_list = allSort_list;
	}

	public Sort getFatherSort() {
		return fatherSort;
	}

	public void setFatherSort(Sort fatherSort) {
		this.fatherSort = fatherSort;
	}

	public List<Sort> getAllFirstList() {
		return allFirstList;
	}

	public void setAllFirstList(List<Sort> allFirstList) {
		this.allFirstList = allFirstList;
	}

	public Sort getUseSort() {
		return useSort;
	}

	public void setUseSort(Sort useSort) {
		this.useSort = useSort;
	}

}
