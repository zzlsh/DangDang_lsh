package com.lsh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsh.entity.Book;
import com.lsh.entity.Cart;
import com.lsh.entity.Sort;
import com.lsh.entity.User;
import com.lsh.service.AdminService;
import com.lsh.service.AdminServiceImpl;
import com.lsh.service.BookService;
import com.lsh.service.BookServiceImpl;
import com.lsh.service.FrontService;
import com.lsh.service.FrontServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FrontAction extends ActionSupport{
	//存储所有一级类别和所属的二级类别
	private List<Sort> firstWithSecond;
	//保存随机推荐的两本书
	private List<Book> randomBooks;
	//销量最高的两本图书的集合
	private List<Book> maxSaleBooks;
	//最新上架的两本图书
	private List<Book> newBooks;
	//新书热销榜
	private List<Book> hotMaxSaleBooks;
	//一本书的信息
	private Book queryBook;
	//接收fid，一级类别的id
	private String fid;
	//接收sid，二级类别的id
	private String sid;
	//当点击的是二级分类时，传出当前二级分类的名字
	private Sort thisSecondSort;
	//总页数
	private String pageSum;
	//接收当前页数pageNow
	private String pageNow;
	//分类展示，符合条件的书籍的集合
	private List<Book> sortBooks;
	//展示一个一级类别和其拥有的所有的二级类别
	private Sort allSorts;
	//接收到的一级类别名称
	private Sort thisFirstSort;
	//接收需要购买的商品
	private Book needBuyBook;
	//购物车的展示
	private Cart thisCart;
	//某本书籍需要变更的个数
	private String changeNum;
	//发送抛出的异常
	private String message;
	//当前登录的用户
	private User loginUser;
	
	
	//展示所有一级类别的方法
	public String showMainAction(){
		FrontService fsi = new FrontServiceImpl();
		BookService bsi = new BookServiceImpl();
		
		//一级类别和所属二级类别
		firstWithSecond = fsi.selectFirstWithSecond();
		
		//对书籍进行展示
		//查询出所有的书
		List<Book> allBooks = bsi.selectAllBook();
		System.out.println("查询出的所有书："+allBooks);
		//推荐图书
		Random random = new Random();
		Integer num1 = random.nextInt(allBooks.size());
		Integer num2 = random.nextInt(allBooks.size());
		while(true){
			if(num1 == num2){
				//保证两本书不相同
				num2 = random.nextInt(allBooks.size());
			} else {
				//不相同了，跳出循环
				break;
			}
		}
		System.out.println("两个随即展示的图书："+allBooks.get(num1)+"-------"+allBooks.get(num2));
		randomBooks = new ArrayList<Book>();
		randomBooks.add(allBooks.get(num1));
		randomBooks.add(allBooks.get(num2));
		System.out.println("随机展示的书的个数："+randomBooks.size());
		
		//获取销量最高的两本图书
		maxSaleBooks = bsi.maxSaleBooks();
		
		//获取最新上架的两本图书
		newBooks = bsi.newBooks();
		
		//新书热销榜--八本
		hotMaxSaleBooks = bsi.hotMaxSaleBooks();
		
		/*//判断登录的用户
		HttpSession session = ServletActionContext.getRequest().getSession();
		loginUser = (User) session.getAttribute("loginUser");
		System.out.println("登陆的用户："+loginUser);*/
		
		return Action.SUCCESS;
	}

	//查询一本书的所有信息
	public String queryOneBook(){
		
		BookService bsi = new BookServiceImpl();
		System.out.println("查询的书籍对象："+queryBook);
		queryBook = bsi.queryOneBook(queryBook);
		
		return Action.SUCCESS;
	}
	
	//根据用户选择的一级/二级类别，查询当前页包含的所有书籍
	public String FirstOrSecondSortBooksAction(){
		//一级类别fid，二级类别sid，当前页pageNow
		BookService bsi = new BookServiceImpl();
		//计算总页数<---通过总个数，和每页显示的个数4
		System.out.println("fid:"+fid);
		System.out.println("sid:"+sid);
		Integer booksSum = bsi.sortBookSum(fid, sid);
		//总页数：pageSum
		if(booksSum % 4 == 0) {
			//总个数刚好可以被4除尽，总页数即为 总个数/4
			pageSum = String.valueOf(booksSum/4);
		} else {
			//总个数除以4除不尽，总页数需要+1
			pageSum = String.valueOf(booksSum / 4 + 1);
		}
		
		//处理当前页需要展示的第一个数据和第二个数据---默认一页展示4个数据
		System.out.println("当前页："+pageNow);
		Integer x = Integer.valueOf(pageNow);
		if(x == 1){
			//第一页
			//展示的第一个数据rownum	以及	最后一个数据rownum
			Integer startNum = 1;
			Integer endNum = 4;
			sortBooks = bsi.firstOrSecondSortBooks(fid, sid, startNum, endNum);
		} else if (x == Integer.valueOf(pageSum)) {
			//最后一页
			Integer startNum = 4 * x - 3;
			Integer endNum = booksSum;
			sortBooks = bsi.firstOrSecondSortBooks(fid, sid, startNum, endNum);
		} else {
			//中间页数
			Integer startNum = 4 * x - 3;
			Integer endNum = 4 * x;
			sortBooks = bsi.firstOrSecondSortBooks(fid, sid, startNum, endNum);
		}
		
		//查询出所有该一级分类下的所有二级分类	或	二级分类所属的一级分类下的所有二级分类
		AdminService asi = new AdminServiceImpl();
		//将传进来的一级类别的id传给方法，以此来查询该一级类别和所拥有的二级类别
		allSorts = asi.oneSortWithAll(fid);
		if(sid != null) {
			thisSecondSort = asi.queryOneSort(sid);
			System.out.println("当前二级类别"+thisSecondSort);
		}
		thisFirstSort = asi.queryOneSort(fid);
		System.out.println("路径中一级类别的名称："+thisFirstSort);
		
		return Action.SUCCESS;
	}
	
	//购物车
	public String myCartAction(){
		//接收前台传递的商品数据
		System.out.println("需要购买的书籍："+needBuyBook);
		
		//将要购买的书添加进购物车
		//调用购物车方法
		FrontService fsi = new FrontServiceImpl();
		fsi.addBuyInBook(needBuyBook);
		
		//从session作用域中获取购物车
		//用域数据的传递
		/*HttpSession session = ServletActionContext.getRequest().getSession();
		thisCart = (Cart) session.getAttribute("thisCart");
		System.out.println("FrontAction中的当前购物车："+thisCart);*/
		//不再使用request传递购物车
		//购物车使用session作用域进行传递
		
		return Action.SUCCESS;
	}
	
	//购物车点击变更数据
	public String changeNumAction(){
		//接收需要变更的书籍的id,还有变更的数值的大小
		//           needBuyBook     changeNum 
		System.out.println("变更方法");
		
		FrontServiceImpl fsi = new FrontServiceImpl();
		try {
			System.out.println("变更目标个数："+changeNum);
			System.out.println("变更图书："+needBuyBook);
			fsi.changBuyBook(needBuyBook, changeNum);
		} catch (Exception e) {
			// TODO: handle exception
			//库存不足时抛出异常
			message = e.getMessage();
		}
		
		//从session作用域中获取购物车
		//用域数据的传递
		HttpSession session = ServletActionContext.getRequest().getSession();
		thisCart = (Cart) session.getAttribute("thisCart");
		System.out.println("变更书籍数量后的购物车："+thisCart);
		
		return Action.SUCCESS;
	}
	
	
	

	public List<Sort> getFirstWithSecond() {
		return firstWithSecond;
	}
	
	public void setFirstWithSecond(List<Sort> firstWithSecond) {
		this.firstWithSecond = firstWithSecond;
	}
	
	public List<Book> getRandomBooks() {
		return randomBooks;
	}
	
	public void setRandomBooks(List<Book> randomBooks) {
		this.randomBooks = randomBooks;
	}
	
	public List<Book> getMaxSaleBooks() {
		return maxSaleBooks;
	}
	
	public void setMaxSaleBooks(List<Book> maxSaleBooks) {
		this.maxSaleBooks = maxSaleBooks;
	}

	public List<Book> getNewBooks() {
		return newBooks;
	}

	public void setNewBooks(List<Book> newBooks) {
		this.newBooks = newBooks;
	}

	public List<Book> getHotMaxSaleBooks() {
		return hotMaxSaleBooks;
	}

	public void setHotMaxSaleBooks(List<Book> hotMaxSaleBooks) {
		this.hotMaxSaleBooks = hotMaxSaleBooks;
	}

	public Book getQueryBook() {
		return queryBook;
	}

	public void setQueryBook(Book queryBook) {
		this.queryBook = queryBook;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}

	public List<Book> getSortBooks() {
		return sortBooks;
	}

	public void setSortBooks(List<Book> sortBooks) {
		this.sortBooks = sortBooks;
	}

	public Sort getAllSorts() {
		return allSorts;
	}

	public void setAllSorts(Sort allSorts) {
		this.allSorts = allSorts;
	}

	public Sort getThisFirstSort() {
		return thisFirstSort;
	}

	public void setThisFirstSort(Sort thisFirstSort) {
		this.thisFirstSort = thisFirstSort;
	}

	public String getPageSum() {
		return pageSum;
	}

	public void setPageSum(String pageSum) {
		this.pageSum = pageSum;
	}

	public Sort getThisSecondSort() {
		return thisSecondSort;
	}

	public void setThisSecondSort(Sort thisSecondSort) {
		this.thisSecondSort = thisSecondSort;
	}

	public Book getNeedBuyBook() {
		return needBuyBook;
	}

	public void setNeedBuyBook(Book needBuyBook) {
		this.needBuyBook = needBuyBook;
	}

	public Cart getThisCart() {
		return thisCart;
	}

	public void setThisCart(Cart thisCart) {
		this.thisCart = thisCart;
	}

	public String getChangeNum() {
		return changeNum;
	}

	public void setChangeNum(String changeNum) {
		this.changeNum = changeNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	
	
}
