package com.lsh.entity;

import java.util.Map;

public class Cart {
	//商品们
	private Map<Book,Integer> books;
	//总价
	private Double total;
	//优惠价格
	private Double discounts;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Map<Book, Integer> books, Double total, Double discounts) {
		super();
		this.books = books;
		this.total = total;
		this.discounts = discounts;
	}
	@Override
	public String toString() {
		return "Cart [books=" + books + ", total=" + total + ", discounts="
				+ discounts + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result
				+ ((discounts == null) ? 0 : discounts.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (discounts == null) {
			if (other.discounts != null)
				return false;
		} else if (!discounts.equals(other.discounts))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	public Map<Book, Integer> getBooks() {
		return books;
	}
	public void setBooks(Map<Book, Integer> books) {
		this.books = books;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Double discounts) {
		this.discounts = discounts;
	}
	

}
