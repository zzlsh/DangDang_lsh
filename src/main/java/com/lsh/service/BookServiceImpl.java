package com.lsh.service;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.lsh.dao.AdminDAO;
import com.lsh.dao.BookDAO;
import com.lsh.entity.Book;
import com.lsh.entity.Sort;
import com.lsh.util.MyBatisUtil;

public class BookServiceImpl implements BookService {

	@Override
	// 查询所有书籍的方法
	public List<Book> selectAllBook() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		// 调用dao方法
		List<Book> allBookList = bookDAO.selectAllBook();
		for (Book book : allBookList) {
			System.out.println("所有书籍中的一员："+book);
		}

		// 关闭资源
		MyBatisUtil.close(sqlSession);

		return allBookList;
	}

	@Override
	// 添加新书的方法
	public void addNewBook(Book newBook) {
		// TODO Auto-generated method stub
		System.out.println("bookservice中的addNewBook方法");

		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);

		// 查询所有书籍，进行比较--保证书籍名和作者名不能同时重复
		List<Book> allBook = bookDAO.selectAllBook();
		for (Book book : allBook) {
			System.out.println("判断名字和作者是否重复");
			if (newBook.getBook_author().equals(book.getBook_author())
					&& newBook.getBook_name().equals(book.getBook_name())) {
				MyBatisUtil.rollback(sqlSession);
				throw new RuntimeException("有重复的书籍存在");
			}
		}
		System.out.println("没有重复");
		// 给新书添加--1.唯一标识 2.上架时间 3.销量
		newBook.setBook_id(UUID.randomUUID().toString());
		System.out.println("获取了uuid");
		newBook.setBook_putaway_time(new java.sql.Date(new java.util.Date()
				.getTime()));
		System.out.println("获取了上架时间");
		newBook.setBook_sales_volume("0");
		System.out.println("获取了销量");
		// 调用dao方法
		bookDAO.addNewBook(newBook);
		MyBatisUtil.commit(sqlSession);
	}

	@Override
	// 查询二级类别的id和名字的方法
	public List<Sort> selectAllSecondSort() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Sort> secondIdAndName = bookDAO.selectAllSecondSort();

		MyBatisUtil.close(sqlSession);
		return secondIdAndName;
	}

	@Override
	// 删除一本书的方法
	public void deleteOneBook(Book deleteBook) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		bookDAO.deleteOneBook(deleteBook);

		MyBatisUtil.commit(sqlSession);
	}
	
	@Override
	//修改一本书的方法
	public void updateOneBook(Book updateBook) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		// 查询所有书籍，进行比较--保证书籍名和作者名不能同时重复
		List<Book> allBook = bookDAO.selectAllBook();
		for (Book book : allBook) {
			if(updateBook.getBook_id()!=book.getBook_id()){
				//当查到自己，跳过
				continue;
			}
			System.out.println("判断名字和作者是否重复");
			if (updateBook.getBook_author().equals(book.getBook_author())&& updateBook.getBook_name().equals(book.getBook_name())) {
				MyBatisUtil.rollback(sqlSession);
				throw new RuntimeException("有重复的书籍存在");
			}
		}
		System.out.println("出了修改的查重循环");
		// 调用修改方法
		System.out.println("调用修改方法前要传进去的Book对象："+updateBook);
		bookDAO.updateOneBook(updateBook);
		// 关闭资源
		MyBatisUtil.commit(sqlSession);
	}
	//查询一本书的全部信息
	public Book queryOneBook(Book queryBook){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		
		Book oneBook = bookDAO.queryOneBook(queryBook);
		return oneBook;
	}
	
	//根据条件查询书的集合
	public List<Book> selectConditionBooks(String key, String words){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> conditionBooksList = bookDAO.selectConditionBooks(key, words);
		
		return conditionBooksList;
	}
	
	//热销图书展示--两本销量 最高的图书
	public List<Book> maxSaleBooks(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> maxSaleBooks = bookDAO.maxSaleBooks();
		
		MyBatisUtil.close(sqlSession);

		return maxSaleBooks;
	}
	
	//热销图书展示--两本销量 最高的图书
	public List<Book> newBooks(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> newBooks = bookDAO.newBooks();
		
		MyBatisUtil.close(sqlSession);
		return newBooks;
	}
	
	//根据上架时间和销量进行排序返回的集合
	public List<Book> hotMaxSaleBooks(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> hotMaxSaleBooks = bookDAO.hotMaxSaleBooks();
		for (Book book : hotMaxSaleBooks) {
			System.out.println("新书热卖榜一员："+book);
		}
		MyBatisUtil.close(sqlSession);
		return hotMaxSaleBooks;	
	}
	
	//根据用户点击的分类，以及当前页，查询相应的书籍集合
	public List<Book> firstOrSecondSortBooks(String fid, String sid, Integer startNum, Integer endNum){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> sortBooks = bookDAO.firstOrSecondSortBooks(fid, sid, startNum, endNum);
		
		System.out.println("一级类别："+fid+"   二级类别："+sid);
		for (Book book : sortBooks) {
			System.out.println("当前页包含的书籍之一："+book);
		}
		
		MyBatisUtil.close(sqlSession);
		return sortBooks;
	}
	
	//根据一级类别或二级类别，查询符合条件的书籍的个数
	public Integer sortBookSum(String fid, String sid){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		
		Integer sortBookSum = bookDAO.sortBookSum(fid, sid);
		System.out.println("service层查询需要展示的个数:"+sortBookSum);
		MyBatisUtil.close(sqlSession);
		return sortBookSum;
	}
}
