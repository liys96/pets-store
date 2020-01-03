package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import edu.lys.dao.ICustomer;
import edu.lys.entity.Customer;
import edu.lys.entity.Page;
import edu.lys.utils.BaseDao;

/**
 * 
 * @author lys
 * @Date 2018年12月6日09:29:41
 * @Description 客户接口实现类
 */
public class CustomerImpl implements ICustomer {

	@Override
	public List<Customer> searchAllCustomer(Page<Customer> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		try {
			String sql = "select * from (select rownum rn,t.* from t_customer t where 1 = 1 ";
			if(page.getEntity().getCustomerName() != null && !"".equals(page.getEntity().getCustomerName())){
				sql += " and t.customer_name like '%" + page.getEntity().getCustomerName() + "%'";
			}
			if(page.getEntity().getCustomerAccount() != null && !"".equals(page.getEntity().getCustomerAccount()) ){
				sql += " and t.customer_account like '%"+page.getEntity().getCustomerAccount() +"%'";
			}
			if(page.getEntity().getState() != -1) {
				sql += " and t.customer_state = " + page.getEntity().getState() + " ";
				
			}
			sql += ") where rn between ? and ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, page.getStartIndex());
			pstm.setInt(2, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setRn(rs.getInt(1));
				customer.setCustomerId(rs.getInt(2));
				customer.setCustomerName(rs.getString(3));
				customer.setCustomerSex(rs.getString(4));
				customer.setPhoneNumber(rs.getString(5));
				customer.setCustomerAccount(rs.getString(6));
				customer.setLoginPassword(rs.getString(7));
				customer.setPayPassword(rs.getString(8));
				customer.setReceivedAddress(rs.getString(9));
				customer.setCreateDate(rs.getDate(10));
				customer.setState(rs.getInt(11));
				list.add(customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return list;
	}
	
	@Override
	public int searchCount(Page<Customer> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from t_customer t where 1 = 1 ";
			if(page.getEntity().getCustomerName() != null && !"".equals(page.getEntity().getCustomerName())){
				sql += " and t.customer_name like '%" + page.getEntity().getCustomerName() + "%'";
			}
			if(page.getEntity().getCustomerAccount() != null && !"".equals(page.getEntity().getCustomerAccount()) ){
				sql += " and t.customer_account like '%"+page.getEntity().getCustomerAccount() +"%'";
			}
			if(page.getEntity().getState() != -1) {
				sql += " and t.customer_state = " + page.getEntity().getState() + " ";
				
			}
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}
		return count;
	}

	@Override
	public Customer searchCustomerById(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		Customer customer = null;
		try {
			String sql = "select * from t_customer where customer_id = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerSex(rs.getString(3));
				customer.setPhoneNumber(rs.getString(4));
				customer.setCustomerAccount(rs.getString(5));
				customer.setLoginPassword(rs.getString(6));
				customer.setReceivedAddress(rs.getString(8));
				customer.setCreateDate(rs.getDate(9));
				customer.setState(rs.getInt(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}
		return customer;
	}

	@Override
	public boolean cancelCustomerById(int id) {
		// TODO Auto-generated method stub
		String sql="update t_customer set customer_state  = 0 where customer_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean recoverCustomerById(int id) {
		// TODO Auto-generated method stub
		String sql="update t_customer set customer_state  = 1 where customer_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}
	
	@Override
	public boolean customerRegister(Customer customer) {
		// TODO Auto-generated method stub
		String sql="insert into t_customer values(seq_customer.nextval,?,?,?,?,?,?,?,sysdate,1,?)"; 
		Object rs[] = {
				customer.getCustomerName(),
				customer.getCustomerSex(),
				customer.getPhoneNumber(),
				customer.getCustomerAccount(),
				customer.getLoginPassword(),
				customer.getPayPassword(),
				customer.getReceivedAddress(),
				customer.getCustomerHeadPic()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public String customerLogin(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String flag = null;
		try {
			String sql = "select * from t_customer where customer_account = ? and customer_loginpassword = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, customer.getCustomerAccount());
			pstm.setString(2, customer.getLoginPassword());
			rs = pstm.executeQuery();
			if(rs.next()) {				
				if(rs.getInt(10)==0) {
					flag = "0";
				}else {
					flag = "1";
				}
			}else {
				flag = "2";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}
		return flag;
	}

	@Override
	public boolean checkAccountExists(String account) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean flag = true;
		try {
			String sql = "select * from t_customer where customer_account = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, account);
			rs = pstm.executeQuery();
			if(rs.next()) {
				flag = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}
		return flag;
	}

	@Override
	public Customer searchCustomerNameByAccount(String account) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		Customer customer = null;
		try {
			String sql = "select * from t_customer where customer_account = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, account);
			rs = pstm.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerAccount(rs.getString(5));
				customer.setLoginPassword(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}
		return customer;
	}

	
	

}
