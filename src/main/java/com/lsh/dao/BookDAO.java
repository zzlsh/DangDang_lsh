package com.lsh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lsh.entity.Book;
import com.lsh.entity.Sort;

public interface BookDAO {
	
	//查询所有书籍的方法
	/**查询所有书籍
	 * @return List<Book>
	 */
	public List<Book> selectAllBook();
	
	/**添加图书的方法
	 * @param newBook
	 */
	public void addNewBook(Book newBook);
	
	/**查询所有二级类别（只要类别的id和名字）
	 * @return List<Sort>
	 */
	public List<Sort> selectAllSecondSort();
	
	/**删除一本书的方法
	 * @param deleteBook
	 */
	public void deleteOneBook(Book deleteBook);
	
	/**修改一本书
	 * @param updateBook
	 */
	public void updateOneBook(Book updateBook);
	public Book queryOneBook(Book queryBook);
	
	//根据条件查询一本书
	/**
	 * @param condition 条件
	 * @param words 查询语句
	 * @return 符合条件的Book集合
	 */
	public List<Book> selectConditionBooks(@Param("key")String key, @Param("words")String words);
	
	//热销图书展示--两本销量 最高的图书
	/**两本销量 最高的图书
	 * @return 根据销量排序后的图书集合
	 */
	public List<Book> maxSaleBooks();
	
	/**新书上架
	 * @return 根据上架时间排序后的图书集合
	 */
	public List<Book> newBooks();
	
	/**新书热销榜
	 * @return 根据上架时间和销量进行排序返回的集合
	 */
	public List<Book> hotMaxSaleBooks();
	
	
	
	/**根据前台传递的fid和sid，查询特定条件下的所有书籍
	 * @param fid
	 * @param sid
	 * @param startNum 当前页面第一条数据
	 * @param endNum 当前页面最后一条数据
	 * @return
	 */
	public List<Book> firstOrSecondSortBooks(@Param("fid")String fid, @Param("sid")String sid,@Param("startNum")Integer startNum, @Param("endNum")Integer endNum);
	
	
	/**根据一级类别或二级类别，查询类别中书籍的个数
	 * @return 个数
	 */
	public Integer sortBookSum(@Param("fid")String fid, @Param("sid")String sid);
}
