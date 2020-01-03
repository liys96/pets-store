package edu.lys.entity;
import java.util.Date;
/**
 * @Author lys
 * @Date 2018年12月5日16:48:54
 * @Description 客户表实体类
 * */
public class Customer {

	private int rn;					//rn
	private int customerId;			//客户id
	private String customerName;	//客户名称
	private String customerHeadPic;	//客户头像
	private String customerSex;		//客户性别
	private String phoneNumber;		//客户电话
	private String customerAccount;	//客户账号
	private String loginPassword;	//登录密码
	private String payPassword;		//支付密码
	private String receivedAddress;	//收货地址
	private Date createDate;		//创建时间
	private int state;				//状态
	
	
	
	public String getCustomerHeadPic() {
		return customerHeadPic;
	}
	public void setCustomerHeadPic(String customerHeadPic) {
		this.customerHeadPic = customerHeadPic;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public String getReceivedAddress() {
		return receivedAddress;
	}
	public void setReceivedAddress(String receivedAddress) {
		this.receivedAddress = receivedAddress;
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
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerSex=" + customerSex
				+ ", phoneNumber=" + phoneNumber + ", customerAccount=" + customerAccount + ", loginPassword="
				+ loginPassword + ", payPassword=" + payPassword + ", receivedAddress=" + receivedAddress
				+ ", createDate=" + createDate + ", state=" + state + "]";
	}
	
	
	
}
