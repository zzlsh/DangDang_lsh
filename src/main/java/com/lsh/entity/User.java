package com.lsh.entity;

import java.util.Date;

public class User {
	private String user_id;
	private String user_nickname;
	private String user_email;
	private String user_code;
	private String user_password;
	private String user_status;
	private String salt;
	private Date regist_date;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user_id, String user_nickname, String user_email,
			String user_code, String user_password, String user_status,
			String salt, Date regist_date) {
		super();
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.user_code = user_code;
		this.user_password = user_password;
		this.user_status = user_status;
		this.salt = salt;
		this.regist_date = regist_date;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_nickname=" + user_nickname
				+ ", user_email=" + user_email + ", user_code=" + user_code
				+ ", user_password=" + user_password + ", user_status="
				+ user_status + ", salt=" + salt + ", regist_date="
				+ regist_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((regist_date == null) ? 0 : regist_date.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result
				+ ((user_code == null) ? 0 : user_code.hashCode());
		result = prime * result
				+ ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result
				+ ((user_nickname == null) ? 0 : user_nickname.hashCode());
		result = prime * result
				+ ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result
				+ ((user_status == null) ? 0 : user_status.hashCode());
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
		User other = (User) obj;
		if (regist_date == null) {
			if (other.regist_date != null)
				return false;
		} else if (!regist_date.equals(other.regist_date))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (user_code == null) {
			if (other.user_code != null)
				return false;
		} else if (!user_code.equals(other.user_code))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_nickname == null) {
			if (other.user_nickname != null)
				return false;
		} else if (!user_nickname.equals(other.user_nickname))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_status == null) {
			if (other.user_status != null)
				return false;
		} else if (!user_status.equals(other.user_status))
			return false;
		return true;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public java.sql.Date getRegist_date() {
		return new java.sql.Date(regist_date.getTime());
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	
	
	
	
}
