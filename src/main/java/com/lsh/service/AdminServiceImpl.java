package com.lsh.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.lsh.action.AdminAction;
import com.lsh.dao.AdminDAO;
import com.lsh.entity.Admin;
import com.lsh.entity.Book;
import com.lsh.entity.Sort;
import com.lsh.util.MyBatisUtil;

public class AdminServiceImpl implements AdminService {

	// 登录方法
	@Override
	public void loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		Admin loginAdmin = adminDAO.login(admin.getAdmin_username());
		System.out.println("登录的管理员：" + loginAdmin);

		// 执行判断--当判断结果为true时，声明一个，运行时异常，将该异常在action方法中进行try catch
		if (loginAdmin == null)
			throw new RuntimeException("该管理员不存在");
		if (!loginAdmin.getAdmin_password().equals(admin.getAdmin_password()))
			throw new RuntimeException("密码错误");

		// 将返回出来的对象存储进session作用域
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("loginAdmin", loginAdmin);

		// 关闭资源
		MyBatisUtil.close(sqlSession);
	}
	
	@Override
	// 查询所有分类的方法
	public List<Sort> selectAllSort() {
		// 获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		List<Sort> list = adminDAO.queryAllSort();

		// 关闭资源
		MyBatisUtil.close(sqlSession);

		return list;
	}
	
	@Override
	// 添加一级分类的方法
	public void addFirstSort(Sort newFirstSort) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		System.out.println(newFirstSort.getSort_name());

		// 判断传进来的一级标题不能是已存在的
		List<Sort> queryAllSort = adminDAO.queryAllSort();
		for (Sort sort : queryAllSort) {
			if (sort.getSort_name().equals(newFirstSort.getSort_name())) {
				MyBatisUtil.close(sqlSession);
				throw new RuntimeException("该标题已存在");
			}
		}
		// 经过前两条的判断，过关了 则可以向数据库中存储了
		// 将标题的级别定死为----- 1
		newFirstSort.setSort_rank("1");
		// 为其添加唯一标识
		newFirstSort.setSort_id(UUID.randomUUID().toString());
		// 执行添加方法
		adminDAO.addFirstSort(newFirstSort);

		// 资源提交，之后关闭资源
		MyBatisUtil.commit(sqlSession);

	}
	
	@Override
	//查询所有一级标题的方法
	public List<Sort> selectAllFirstSort(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		List<Sort> allFirstList = adminDAO.selectFirst();
		//关闭资源
		MyBatisUtil.close(sqlSession);
		return allFirstList;
	}
	
	@Override
	//添加二级类别的方法
	public void addSecondSort(Sort newSecondSort, Sort fatherSort) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		//判断传进来的类别，是否已存在
		List<Sort> secondList = adminDAO.selectSecond();
		for (Sort sort : secondList) {
			if(sort.getSort_name().equals(newSecondSort.getSort_name())) {
				//先将资源进行关闭
				System.out.println("这个二级标题已存在："+newSecondSort.getSort_name());
				MyBatisUtil.close(sqlSession);
				throw new RuntimeException("该类别已存在");
			}
		}
		//类别不存在可以进行添加
		newSecondSort.setSort_id(UUID.randomUUID().toString());
		newSecondSort.setSort_rank("2");
		//将网页中传进来的上级类别的id，存入二级标签
		newSecondSort.setFather_id(fatherSort.getSort_id());
		
		//调用添加方法
		adminDAO.addSecondSort(newSecondSort);
		
		//关闭资源
		MyBatisUtil.commit(sqlSession);
	}
	
	@Override
	//删除一级类别的方法
	public void deleteFSort(Sort deleteFirstSort) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		adminDAO.deleteFSort(deleteFirstSort);
		//提交+关闭资源
		MyBatisUtil.commit(sqlSession);
	}
	
	@Override
	//删除二级类别的方法
	public void deleteSSort(Sort deleteSecondSort) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		adminDAO.deleteSSort(deleteSecondSort);
		
		//提交+关闭资源
		MyBatisUtil.commit(sqlSession);
	}
	
	@Override
	//根据sort_id查询该一级分类和其拥有的所有二级分类
	public Sort oneSortWithAll(String fid){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		Sort firstWithSeconds = adminDAO.oneSortWithAll(fid);
		System.out.println("adminService中一个一级分类和其所拥有的所有二级分类："+firstWithSeconds);
		MyBatisUtil.close(sqlSession);
		return firstWithSeconds;
	}
	
	
	public Sort queryOneSort(String sort_id){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		System.out.println("adminService中的查询单个类别："+sort_id);
		Sort thidSecondSort = adminDAO.queryOneSort(sort_id);
		MyBatisUtil.close(sqlSession);
		return thidSecondSort;
	}
}
