package com.lsh.entity;

import java.util.Date;

public class OrderConn {
	private String conn_id;
	private String order_id;
	private String book_id;//书籍id
	private String book_name;//书籍名
	private String book_num;//本书的个数
	private Double conn_original_price;
	private Double conn_dangdang_price;
	private String book_cover;
	private Date conn_date;
	public OrderConn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderConn(String conn_id, String order_id, String book_id,
			String book_name, String book_num, Double conn_original_price,
			Double conn_dangdang_price, String book_cover, Date conn_date) {
		super();
		this.conn_id = conn_id;
		this.order_id = order_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_num = book_num;
		this.conn_original_price = conn_original_price;
		this.conn_dangdang_price = conn_dangdang_price;
		this.book_cover = book_cover;
		this.conn_date = conn_date;
	}
	@Override
	public String toString() {
		return "OrderConn [conn_id=" + conn_id + ", order_id=" + order_id
				+ ", book_id=" + book_id + ", book_name=" + book_name
				+ ", book_num=" + book_num + ", conn_original_price="
				+ conn_original_price + ", conn_dangdang_price="
				+ conn_dangdang_price + ", book_cover=" + book_cover
				+ ", conn_date=" + conn_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((book_cover == null) ? 0 : book_cover.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result
				+ ((book_name == null) ? 0 : book_name.hashCode());
		result = prime * result
				+ ((book_num == null) ? 0 : book_num.hashCode());
		result = prime
				* result
				+ ((conn_dangdang_price == null) ? 0 : conn_dangdang_price
						.hashCode());
		result = prime * result
				+ ((conn_date == null) ? 0 : conn_date.hashCode());
		result = prime * result + ((conn_id == null) ? 0 : conn_id.hashCode());
		result = prime
				* result
				+ ((conn_original_price == null) ? 0 : conn_original_price
						.hashCode());
		result = prime * result
				+ ((order_id == null) ? 0 : order_id.hashCode());
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
		OrderConn other = (OrderConn) obj;
		if (book_cover == null) {
			if (other.book_cover != null)
				return false;
		} else if (!book_cover.equals(other.book_cover))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (book_num == null) {
			if (other.book_num != null)
				return false;
		} else if (!book_num.equals(other.book_num))
			return false;
		if (conn_dangdang_price == null) {
			if (other.conn_dangdang_price != null)
				return false;
		} else if (!conn_dangdang_price.equals(other.conn_dangdang_price))
			return false;
		if (conn_date == null) {
			if (other.conn_date != null)
				return false;
		} else if (!conn_date.equals(other.conn_date))
			return false;
		if (conn_id == null) {
			if (other.conn_id != null)
				return false;
		} else if (!conn_id.equals(other.conn_id))
			return false;
		if (conn_original_price == null) {
			if (other.conn_original_price != null)
				return false;
		} else if (!conn_original_price.equals(other.conn_original_price))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		return true;
	}
	public String getConn_id() {
		return conn_id;
	}
	public void setConn_id(String conn_id) {
		this.conn_id = conn_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_num() {
		return book_num;
	}
	public void setBook_num(String book_num) {
		this.book_num = book_num;
	}
	public Double getConn_original_price() {
		return conn_original_price;
	}
	public void setConn_original_price(Double conn_original_price) {
		this.conn_original_price = conn_original_price;
	}
	public Double getConn_dangdang_price() {
		return conn_dangdang_price;
	}
	public void setConn_dangdang_price(Double conn_dangdang_price) {
		this.conn_dangdang_price = conn_dangdang_price;
	}
	public String getBook_cover() {
		return book_cover;
	}
	public void setBook_cover(String book_cover) {
		this.book_cover = book_cover;
	}
	public Date getConn_date() {
		return conn_date;
	}
	public void setConn_date(Date conn_date) {
		this.conn_date = conn_date;
	}
	
	
}
