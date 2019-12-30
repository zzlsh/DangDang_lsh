package com.lsh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lsh.entity.Book;
import com.lsh.entity.Sort;

public interface BookService {
	// 展示所有书籍的方法
	public List<Book> selectAllBook();

	// 添加新书的方法
	public void addNewBook(Book newBook);

	// 查询二级类别的id和名字的方法
	public List<Sort> selectAllSecondSort();
	
	//删除一本书的方法
	public void deleteOneBook(Book deleteBook);
	
	//修改一本书的方法
	public void updateOneBook(Book updateBook);
	//查询一本书的全部信息
	public Book queryOneBook(Book queryBook);
	
	//根据条件查询书的集合
	public List<Book> selectConditionBooks(String key, String words);
	
	//热销图书展示--两本销量 最高的图书
	public List<Book> maxSaleBooks();
	
	//热销图书展示--两本销量 最高的图书
	public List<Book> newBooks();
	
	//根据上架时间和销量进行排序返回的集合
	public List<Book> hotMaxSaleBooks();
	
	//根据用户点击的分类，以及当前页，查询相应的书籍集合
	public List<Book> firstOrSecondSortBooks(String fid, String sid, Integer startNum, Integer endNum);
	
	//根据一级类别或二级类别，查询符合条件的书籍的个数
	public Integer sortBookSum(String fid, String sid);
	
}
