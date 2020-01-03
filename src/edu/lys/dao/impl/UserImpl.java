package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.lys.dao.IUser;
import edu.lys.entity.Customer;
import edu.lys.entity.Page;
import edu.lys.entity.User;
import edu.lys.utils.BaseDao;

public class UserImpl implements IUser {

	@Override
	public List<User> searchAllUser(Page<User> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			String sql = "select * from (select rownum rn,t.* from t_user t where  1 = 1 and t.user_deletestate = 1 ";
			if(page.getEntity().getUserName() != null && !"".equals(page.getEntity().getUserName())){
				sql += " and t.user_name like '%" + page.getEntity().getUserName() + "%'";
			}
			if(page.getEntity().getUserAccount() != null && !"".equals(page.getEntity().getUserAccount()) ){
				sql += " and t.user_account like '%"+page.getEntity().getUserAccount() +"%'";
			}
			if(page.getEntity().getState() != -1) {
				sql += " and t.user_state = " + page.getEntity().getState() + " ";
				
			}
			sql += ") where rn between ? and ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, page.getStartIndex());
			pstm.setInt(2, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setRn(rs.getInt(1));
				user.setUserId(rs.getInt(2));
				user.setUserName(rs.getString(3));
				user.setUserAccount(rs.getString(4));
				user.setUserPassword(rs.getString(5));
				user.setCreateDate(rs.getDate(6));
				user.setState(rs.getInt(7));
				list.add(user);
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
	public int searchCount(Page<User> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from t_user t where 1 = 1 and t.user_deletestate = 1 ";
			if(page.getEntity().getUserName() != null && !"".equals(page.getEntity().getUserName())){
				sql += " and t.user_name like '%" + page.getEntity().getUserName() + "%'";
			}
			if(page.getEntity().getUserAccount() != null && !"".equals(page.getEntity().getUserAccount()) ){
				sql += " and t.user_account like '%"+page.getEntity().getUserAccount() +"%'";
			}
			if(page.getEntity().getState() != -1) {
				sql += " and t.user_state = " + page.getEntity().getState() + " ";
				
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
	public User searchUserById(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		User user = null;
		try {
			String sql = "select * from t_user where user_id = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserAccount(rs.getString(3));
				user.setUserPassword(rs.getString(4));
				user.setCreateDate(rs.getDate(5));
				user.setState(rs.getInt(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}
		return user;
	}

	@Override
	public boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
		String sql="update t_user set user_name = ?,user_password = ?,user_createdate = sysdate,user_state = ? where user_id = ?"; 
		Object rs[] = {
			user.getUserName(),
			user.getUserPassword(),
			user.getState(),
			user.getUserId()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean cancelUserById(int id) {
		// TODO Auto-generated method stub
		String sql="update t_user set user_state  = 0 where user_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean recoverUserById(int id) {
		// TODO Auto-generated method stub
		String sql="update t_user set user_state  = 1 where user_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		String sql="insert into t_user values(seq_user.nextval,?,?,?,sysdate,1,1)"; 
		Object rs[] = {
				user.getUserName(),
				user.getUserAccount(),
				user.getUserPassword()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql="update t_user set user_deletestate = 0 where user_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public String userLogin(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String flag = null;
		try {
			String sql = "select * from t_user where user_account = ? and user_password = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUserAccount());
			pstm.setString(2, user.getUserPassword());
			rs = pstm.executeQuery();
			if(rs.next()) {				
				if(rs.getInt(6)==0) {
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
	public String searchUserNameByAccount(String account) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		String userName = null;
		try {
			String sql = "select user_name from t_user where user_account = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, account);
			rs = pstm.executeQuery();
			if(rs.next()) {
				userName = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}
		return userName;
	}

}
