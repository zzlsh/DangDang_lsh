package com.lsh.entity;

import java.util.Date;
import java.util.List;

public class Order {
	private String order_id;//订单id
	private String order_serial;//订单编号
	private Double order_total;//订单总价
	private String order_status;//订单状态
	private String user_id;//用户id
	private String add_recipients;//收件人
	private String add_local;//收货地址
	private Date order_date;//订单创建时间
	private List<OrderConn> orderConnList;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String order_id, String order_serial, Double order_total,
			String order_status, String user_id, String add_recipients,
			String add_local, Date order_date, List<OrderConn> orderConnList) {
		super();
		this.order_id = order_id;
		this.order_serial = order_serial;
		this.order_total = order_total;
		this.order_status = order_status;
		this.user_id = user_id;
		this.add_recipients = add_recipients;
		this.add_local = add_local;
		this.order_date = order_date;
		this.orderConnList = orderConnList;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_serial=" + order_serial
				+ ", order_total=" + order_total + ", order_status="
				+ order_status + ", user_id=" + user_id + ", add_recipients="
				+ add_recipients + ", add_local=" + add_local + ", order_date="
				+ order_date + ", orderConnList=" + orderConnList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((add_local == null) ? 0 : add_local.hashCode());
		result = prime * result
				+ ((add_recipients == null) ? 0 : add_recipients.hashCode());
		result = prime * result
				+ ((orderConnList == null) ? 0 : orderConnList.hashCode());
		result = prime * result
				+ ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result
				+ ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result
				+ ((order_serial == null) ? 0 : order_serial.hashCode());
		result = prime * result
				+ ((order_status == null) ? 0 : order_status.hashCode());
		result = prime * result
				+ ((order_total == null) ? 0 : order_total.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		Order other = (Order) obj;
		if (add_local == null) {
			if (other.add_local != null)
				return false;
		} else if (!add_local.equals(other.add_local))
			return false;
		if (add_recipients == null) {
			if (other.add_recipients != null)
				return false;
		} else if (!add_recipients.equals(other.add_recipients))
			return false;
		if (orderConnList == null) {
			if (other.orderConnList != null)
				return false;
		} else if (!orderConnList.equals(other.orderConnList))
			return false;
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (order_serial == null) {
			if (other.order_serial != null)
				return false;
		} else if (!order_serial.equals(other.order_serial))
			return false;
		if (order_status == null) {
			if (other.order_status != null)
				return false;
		} else if (!order_status.equals(other.order_status))
			return false;
		if (order_total == null) {
			if (other.order_total != null)
				return false;
		} else if (!order_total.equals(other.order_total))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_serial() {
		return order_serial;
	}
	public void setOrder_serial(String order_serial) {
		this.order_serial = order_serial;
	}
	public Double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(Double order_total) {
		this.order_total = order_total;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAdd_recipients() {
		return add_recipients;
	}
	public void setAdd_recipients(String add_recipients) {
		this.add_recipients = add_recipients;
	}
	public String getAdd_local() {
		return add_local;
	}
	public void setAdd_local(String add_local) {
		this.add_local = add_local;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public List<OrderConn> getOrderConnList() {
		return orderConnList;
	}
	public void setOrderConnList(List<OrderConn> orderConnList) {
		this.orderConnList = orderConnList;
	}

}
