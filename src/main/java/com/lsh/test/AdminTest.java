package com.lsh.test;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lsh.dao.AdminDAO;
import com.lsh.dao.BookDAO;
import com.lsh.entity.Admin;
import com.lsh.entity.Book;
import com.lsh.entity.Sort;
import com.lsh.service.AdminServiceImpl;
import com.lsh.service.BookServiceImpl;
import com.lsh.service.FrontServiceImpl;
import com.lsh.util.MyBatisUtil;

public class AdminTest {
	@Test
	public void testLogin() {
		System.out.println("11111111111111");
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);

		System.out.println("22222222222222222");
		Admin loginAdmin = adminDAO.login("李少涵");
		System.out.println(loginAdmin);

		MyBatisUtil.close(sqlSession);
	}

	@Test
	public void test1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		sqlSession.close();

	}

	@Test
	public void test2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);

		List<Sort> list = adminDAO.queryAllSort();
		for (Sort sort : list) {
			System.out.println(sort);
		}

		MyBatisUtil.close(sqlSession);
	}

	@Test
	public void test3() {
		AdminServiceImpl asi = new AdminServiceImpl();
		List<Sort> list = asi.selectAllSort();
		for (Sort sort : list) {
			System.out.println(sort);
		}
	}

	// 添加一级类别
	@Test
	public void test4() {

		Sort newFirstSort = new Sort();
		newFirstSort.setSort_id(UUID.randomUUID().toString());
		newFirstSort.setSort_name("四大名著");
		newFirstSort.setSort_rank("1");
		try {
			AdminServiceImpl asi = new AdminServiceImpl();
			asi.addFirstSort(newFirstSort);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void test5() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		MyBatisUtil.rollback(sqlSession);
	}

	@Test
	public void test6() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
		List<Sort> first = adminDAO.selectFirst();
		List<Sort> second = adminDAO.selectSecond();
		System.out.println("所有一级类别的个数：" + first.size());
		System.out.println("所有二级类别的个数：" + second.size());

		MyBatisUtil.close(sqlSession);
	}

	@Test
	public void test7() {
		AdminServiceImpl asi = new AdminServiceImpl();

		// 二级标签对象--对象名称
		Sort newSecondSort = new Sort();
		newSecondSort.setSort_name("西游记");
		// 一级标签对象--对象id，
		Sort fatherSort = new Sort();
		fatherSort.setSort_id("7851280d-5f2e-46e4-8d06-3f8764fab73d");

		// 调用添加二级标签的方法
		asi.addSecondSort(newSecondSort, fatherSort);
	}

	@Test
	public void test8() {
		AdminServiceImpl asi = new AdminServiceImpl();

		Sort deleteSecondSort = new Sort();
		deleteSecondSort.setSort_id("08ec27b8-b467-45c2-a199-b0dd1757a032");

		asi.deleteSSort(deleteSecondSort);
	}

	@Test
	public void test9() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		// 调用dao方法
		List<Book> allBook = bookDAO.selectAllBook();
		for (Book book : allBook) {
			System.out.println(book);
		}

		// 关闭资源
		MyBatisUtil.close(sqlSession);
	}

	@Test
	public void test10() {
		BookServiceImpl asi = new BookServiceImpl();
		List<Sort> selectAllSecondSort = asi.selectAllSecondSort();
		for (Sort sort : selectAllSecondSort) {
			System.out.println(sort);
		}
	}

	@Test
	public void test11() {
		FrontServiceImpl frontServiceImpl = new FrontServiceImpl();
		List<Sort> selectFirstWithSecond = frontServiceImpl
				.selectFirstWithSecond();
		System.out.println(selectFirstWithSecond.size());
	}
	
	@Test
	public void test12() {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> maxSaleBooks = bookServiceImpl.maxSaleBooks();
		for (Book book : maxSaleBooks) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test13() {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> newBooks = bookServiceImpl.newBooks();
		for (Book book : newBooks) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test14() {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> newBooks = bookServiceImpl.hotMaxSaleBooks();
		for (Book book : newBooks) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test15() {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> booksList = bookServiceImpl.firstOrSecondSortBooks("", "7cdb39dd-162e-4446-a159-5bc8874a1905", 1, 2);
		for (Book book : booksList) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test16() {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		Integer sortBookSum = bookServiceImpl.sortBookSum("13a304ee-43ac-4002-b5eb-a954302e96b2", "");
		System.out.println(sortBookSum);
	}
	
	@Test
	public void test17() {
		AdminServiceImpl asi = new AdminServiceImpl();
		Sort oneSortWithAll = asi.oneSortWithAll("13a304ee-43ac-4002-b5eb-a954302e96b2");
		System.out.println(oneSortWithAll);
	}
}
