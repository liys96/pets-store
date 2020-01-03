package edu.lys.dao;

import java.util.List;


import edu.lys.entity.Customer;
import edu.lys.entity.Page;

/**
 * @Author lys
 * @Date 2018年12月5日17:26:30
 * @Description 客户接口
 * */
public interface ICustomer {

	//查询所有客户带模糊条件
	public List<Customer> searchAllCustomer(Page<Customer> page);
	
	//查询总记录数
	public int searchCount(Page<Customer> page);
	
	//根据id查看客户
	public Customer searchCustomerById(int id);
	
	//修改客户状态(注销)
	public boolean cancelCustomerById(int id);
	
	//修改客户状态(恢复)
	public boolean recoverCustomerById(int id);
	
	//客户注册
	public boolean customerRegister(Customer customer);	
	
	//客户登录
	public String customerLogin(Customer customer);
	
	
	//根据客户账号查找用户名
	public Customer searchCustomerNameByAccount(String account);
	
	//查询注册客户账号是否存在
	public boolean checkAccountExists(String account);
	

}
