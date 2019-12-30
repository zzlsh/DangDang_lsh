package com.lsh.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lsh.entity.Book;
import com.lsh.entity.Sort;
import com.lsh.service.AdminServiceImpl;
import com.lsh.service.BookServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	// 用于操作的书籍对象
	private Book DMLBook;
	// 接收页面传递的异常信息
	private String message;
	// 展示所有的书籍
	private List<Book> allBookList;
	// 包含的是所有二级类别
	private List<Sort> secondIdAndNameList;
	// 接收新添加的书籍
	private Book newBook;
	// 接收新图书的封面照片
	private File cover;
	// 封面图的文件名
	private String coverFileName;
	// 封面图的文件类型
	private String coverContentType;
	//模糊查询的条件
	private String key;
	//模糊查询的关键字
	private String words;
	
	

	// 展示所有书籍的方法
	public String selectAllBookAction() {
		BookServiceImpl bsi = new BookServiceImpl();
		allBookList = bsi.selectAllBook();

		return Action.SUCCESS;
	}

	// 添加书籍的方法
	public String addBookAction() {
		System.out.println("新添加的书籍信息：" + newBook);
		System.out.println("添加的封面图：" + cover);
		System.out.println("添加的封面图文件名：" + coverFileName);
		System.out.println("添加的封面图文件类型：" + coverContentType);
		// 获取真实路径
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"\\back\\img");
		// 获取文件保存的文件名
		String uuid = UUID.randomUUID().toString();
		String copyLoad = uuid + coverFileName;
		File copyFileLoad = new File(realPath, copyLoad);
		System.out.println("服务器保存的文件：" + copyFileLoad);
		// 将上传的文件copy进服务器的文件夹中
		try {
			FileUtils.copyFile(cover, copyFileLoad);
			System.out.println("copy了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 将文件名保存到书籍的封面路径中
		newBook.setBook_cover(coverFileName);

		// 调用service方法
		BookServiceImpl bsi = new BookServiceImpl();
		try {
			bsi.addNewBook(newBook);
			return Action.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
			System.out.println(message);
			return Action.ERROR;
		}

	}

	// 查询所有二级类别的方法
	public String allSecondSortNameAction() {
		BookServiceImpl bsi = new BookServiceImpl();
		secondIdAndNameList = bsi.selectAllSecondSort();
		return Action.SUCCESS;
	}

	// 删除一本书的方法
	public String deleteOneBook() {
		System.out.println("删除的书籍的id：" + DMLBook.getBook_id());
		BookServiceImpl bsi = new BookServiceImpl();
		bsi.deleteOneBook(DMLBook);

		return Action.SUCCESS;
	}

	// 修改一本书的方法
	public String updateOneBookAction() {
		System.out.println("修改后的书籍信息：" + DMLBook);
		BookServiceImpl bsi = new BookServiceImpl();

		// 判断是否接收到图片，如果为null不再添加图片路径
		if (cover == null) {

		} else {
			// 将新图片存入服务器
			// 获取真实路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("\\back\\img");
			// 获取文件保存的文件名
			String uuid = UUID.randomUUID().toString();
			String copyLoad = uuid + coverFileName;
			File copyFileLoad = new File(realPath, copyLoad);
			System.out.println("服务器保存的文件：" + copyFileLoad);

			// 设置书籍封面
			System.out.println("修改的书籍封面文件名：" + coverFileName);
			DMLBook.setBook_cover(copyLoad);

			// 将上传的文件copy进服务器的文件夹中
			try {
				FileUtils.copyFile(cover, copyFileLoad);
				System.out.println("copy了");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			bsi.updateOneBook(DMLBook);
			return Action.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
			return Action.ERROR;
		}
	}

	// 查询一本书
	public String queryOneBook() {
		System.out.println("需要修改的书籍的信息：" + DMLBook);
		BookServiceImpl bsi = new BookServiceImpl();
		DMLBook = bsi.queryOneBook(DMLBook);

		// 查询所有二级分类
		secondIdAndNameList = bsi.selectAllSecondSort();

		return Action.SUCCESS;
	}
	
	//根据条件查询书的集合
	public String selectConditionBooksAction(){
		System.out.println("传进来的两个参数："+key+"-----"+words);
		
		BookServiceImpl bsi = new BookServiceImpl();
		allBookList = bsi.selectConditionBooks(key, words);
		
		
		return Action.SUCCESS;
	}
	
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Book> getAllBookList() {
		return allBookList;
	}

	public void setAllBookList(List<Book> allBookList) {
		this.allBookList = allBookList;
	}

	public List<Sort> getSecondIdAndNameList() {
		return secondIdAndNameList;
	}

	public void setSecondIdAndNameList(List<Sort> secondIdAndNameList) {
		this.secondIdAndNameList = secondIdAndNameList;
	}

	public Book getNewBook() {
		return newBook;
	}

	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public String getCoverContentType() {
		return coverContentType;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}

	public Book getDMLBook() {
		return DMLBook;
	}

	public void setDMLBook(Book dMLBook) {
		DMLBook = dMLBook;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

}
