package com.lsh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lsh.entity.Admin;
import com.lsh.entity.Sort;

public interface AdminDAO {
	
	//登录方法
	/**后台管理员模块：登陆方法
	 * @param admin_username
	 * @return 该账号密码的对象
	 */
	public Admin login(String admin_username);
	
	/**查询所有的类别
	 * @return 集合：List<Sort>
	 */
	public List<Sort> queryAllSort();
	
	
	/**添加一级类别的方法
	 * @param sort
	 */
	public void addFirstSort(Sort newFirstSort);
	//查询所有一级类别
	public List<Sort> selectFirst();
	
	//添加二级类别的方法
	public void addSecondSort(Sort newSecondSort);
	//查询所有二级类别
	public List<Sort> selectSecond();
	
	//删除一级类别的方法
	/**删除一级类别的方法--先删下属二级
	 * @param deleteFirstSort
	 */
	public void deleteFSort(Sort deleteFirstSort);
	
	/**删除二级类别的方法--直接删除
	 * @param deleteSecondSort
	 */
	public void deleteSSort(Sort deleteSecondSort);
	
	
	
	/**查询所有一级类别和其拥有的二级类别
	 * @return
	 */
	public List<Sort> selectFirstAndSecond();
	
	
	
	/**查一个一级分类和其拥有的所有二级分类
	 * @param oneSort
	 * @return
	 */
	public Sort oneSortWithAll(String fid);
	
	public Sort queryOneSort(@Param("sort_id")String sort_id);
}
