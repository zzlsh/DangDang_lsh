package com.lsh.dao;

import org.apache.ibatis.annotations.Param;

import com.lsh.entity.User;

public interface UserDAO {
	
	//根据id查询一个用户信息方法
	public User queryOneUser(String user_id);
	
	//注册方法
	/**注册方法
	 * @param registUser注册的用户对象
	 */
	public void registOneUser(User registUser);
	
	//完善用户信息的方法----根据传入的id
	public void fullUser(@Param("user_code")String user_code, @Param("user_id")String user_id);
	
	//登录方法
	public User loginUser(User loginUser);
}
