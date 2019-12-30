package com.lsh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lsh.entity.Order;
import com.lsh.entity.User;

public interface OrderDAO {
	
	//查询所有订单
	/**查询所有订单
	 * @return 所有订单对象组成的集合
	 */
	public List<Order> selectAllOrder();
	
	/**根据订单id查询单个订单所有信息
	 * @param order_id 订单id
	 * @return
	 */
	public Order queryOneOrder(@Param("order_id")String order_id);
	
	/**查询所有用户的方法
	 * @return
	 */
	public List<User> selectAllUser();
	
	/**修改一个用户的信息的方法
	 * @param user_id
	 */
	public void updateOneUser(@Param("user_id")String user_id, @Param("user_status")String user_status);
	//查状态
	public User queryStatus(@Param("user_id")String user_id);
}
