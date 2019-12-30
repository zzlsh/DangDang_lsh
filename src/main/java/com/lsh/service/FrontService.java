package com.lsh.service;

import java.util.List;

import com.lsh.entity.Book;
import com.lsh.entity.Sort;

public interface FrontService {
	
	//查询所有一级类别和所属的子类
	public List<Sort> selectFirstWithSecond();
	
	//购物车的添加
	public void addBuyInBook(Book buyBook);
	
	//购物车的变更
	public void changBuyBook(Book buyBook, String changeNum);
}
