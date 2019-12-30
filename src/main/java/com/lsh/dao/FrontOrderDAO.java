package com.lsh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lsh.entity.Address;
import com.lsh.entity.Book;
import com.lsh.entity.Order;
import com.lsh.entity.OrderConn;
import com.lsh.entity.User;

public interface FrontOrderDAO {
	
	/**根据登录用户的用户id，查询其所有的地址
	 * @param loginUser 登录用户
	 * @return 地址类型的集合
	 */
	public List<Address> selectAllAddressById(User loginUser);
	
	
	/**根据一个地址id查询一个地址的所有信息
	 * @param address 地址的id
	 * @return
	 */
	public Address queryOneAddress(@Param("address")String address);
	
	/**添加一个新的地址
	 * @param newAddress
	 */
	public void addNewAddress(Address newAddress);
	
	/**根据地址id修改某一地址信息
	 * @param newAddress 承载着全新的地址信息
	 */
	public void updateOneAddress(Address newAddress);
	
	/**订单入库
	 * @param newOrder
	 */
	public void addNewOrder(Order newOrder);
	
	/**关联表入库
	 * @param newOrder
	 */
	public void dealConnOrder(OrderConn newOrderConn);
	
	/**处理单个书籍的库存数据
	 * @param thisBook
	 */
	public void dealOneBook(Book thisBook);
}
