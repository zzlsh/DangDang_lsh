package com.lsh.entity;

public class Address {
	private String add_id;//地址id
	private String add_postcode;//邮编
	private String add_local;//详细地址
	private String add_recipients;//收件人
	private String add_tel;//收件人电话
	private String user_id;//用户id
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String add_id, String add_postcode, String add_local,
			String add_recipients, String add_tel, String user_id) {
		super();
		this.add_id = add_id;
		this.add_postcode = add_postcode;
		this.add_local = add_local;
		this.add_recipients = add_recipients;
		this.add_tel = add_tel;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Address [add_id=" + add_id + ", add_postcode=" + add_postcode
				+ ", add_local=" + add_local + ", add_recipients="
				+ add_recipients + ", add_tel=" + add_tel + ", user_id="
				+ user_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((add_id == null) ? 0 : add_id.hashCode());
		result = prime * result
				+ ((add_local == null) ? 0 : add_local.hashCode());
		result = prime * result
				+ ((add_postcode == null) ? 0 : add_postcode.hashCode());
		result = prime * result
				+ ((add_recipients == null) ? 0 : add_recipients.hashCode());
		result = prime * result + ((add_tel == null) ? 0 : add_tel.hashCode());
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
		Address other = (Address) obj;
		if (add_id == null) {
			if (other.add_id != null)
				return false;
		} else if (!add_id.equals(other.add_id))
			return false;
		if (add_local == null) {
			if (other.add_local != null)
				return false;
		} else if (!add_local.equals(other.add_local))
			return false;
		if (add_postcode == null) {
			if (other.add_postcode != null)
				return false;
		} else if (!add_postcode.equals(other.add_postcode))
			return false;
		if (add_recipients == null) {
			if (other.add_recipients != null)
				return false;
		} else if (!add_recipients.equals(other.add_recipients))
			return false;
		if (add_tel == null) {
			if (other.add_tel != null)
				return false;
		} else if (!add_tel.equals(other.add_tel))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public String getAdd_id() {
		return add_id;
	}
	public void setAdd_id(String add_id) {
		this.add_id = add_id;
	}
	public String getAdd_postcode() {
		return add_postcode;
	}
	public void setAdd_postcode(String add_postcode) {
		this.add_postcode = add_postcode;
	}
	public String getAdd_local() {
		return add_local;
	}
	public void setAdd_local(String add_local) {
		this.add_local = add_local;
	}
	public String getAdd_recipients() {
		return add_recipients;
	}
	public void setAdd_recipients(String add_recipients) {
		this.add_recipients = add_recipients;
	}
	public String getAdd_tel() {
		return add_tel;
	}
	public void setAdd_tel(String add_tel) {
		this.add_tel = add_tel;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
