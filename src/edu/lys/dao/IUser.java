package edu.lys.dao;

import java.util.List;

import edu.lys.entity.Customer;
import edu.lys.entity.Page;
import edu.lys.entity.User;

/**
 * @Author lys
 * @Date 2018年12月10日10:36:09
 * @Description 用户接口
 * */

public interface IUser {

		//查询所有用户带模糊条件
		public List<User> searchAllUser(Page<User> page);
		
		//查询总记录数
		public int searchCount(Page<User> page);
		
		//根据id查看用户
		public User searchUserById(int id);
		
		//修改用户信息
		public boolean updateUserInfo(User user);
		
		//添加用户
		public boolean addUser(User user);
		
		//修改用户状态(注销)
		public boolean cancelUserById(int id);
		
		//删除用户(软删除)
		public boolean deleteUser(int id);
		
		//修改用户状态(恢复)
		public boolean recoverUserById(int id);
	
		//用户登录		 
		public String userLogin(User user);
		
		//根据用户账号查找用户名
		public String searchUserNameByAccount(String account);
		
		
}
