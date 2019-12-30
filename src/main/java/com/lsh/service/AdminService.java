package com.lsh.service;

import java.util.List;

import com.lsh.entity.Admin;
import com.lsh.entity.Book;
import com.lsh.entity.Sort;

public interface AdminService {
	// 登录方法
	public void loginAdmin(Admin admin);

	// 查询所有分类的方法
	public List<Sort> selectAllSort();

	// 添加一级分类的方法
	public void addFirstSort(Sort newFirstSort);

	// 添加二级类别的方法
	public void addSecondSort(Sort newSecondSort, Sort fatherSort);
	//查询所有一级标题的方法
	public List<Sort> selectAllFirstSort();
	
	//删除一级类别的方法
	public void deleteFSort(Sort deleteFirstSort);
	
	//删除二级类别的方法
	public void deleteSSort(Sort deleteSecondSort);
	
	//根据sort_id查询该一级分类和其拥有的所有二级分类
	public Sort oneSortWithAll(String fid);
	
	//根据id查询一个类别
	public Sort queryOneSort(String sort_id);
}
