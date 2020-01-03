package edu.lys.entity;

import java.util.Date;

/**
 * @Author lys
 * @Date 2018年12月5日16:52:17
 * @Description 用户表实体类
 * */
public class User {

	private int rn;					//rn
	private int userId;				//用户id
	private String userName;		//用户名称
	private String userAccount;		//用户账号
	private String userPassword;	//登录密码
	private Date createDate;		//创建时间
	private int state;				//状态
	private int deleteState;		//删除状态
	
	
	
	public int getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
}
