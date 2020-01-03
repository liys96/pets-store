package edu.lys.entity;

import java.util.Date;

/**
 * @Author lys
 * @Date 2018年12月12日17:19:04
 * @Description 订单表VO类
 * */
public class OrderVO {

	private int rn;					//rn
	private int orderId	;			//订单id
	private String serialNumber;	//订单编号
	private int totalMoney;			//订单总金额
	private Date  orderDate;		//下单时间
	private int orderState;			//状态
	private String customerName;	//下单人
	private String customerPhoneNumber;	//客户电话
	private String receivedAddress;	//收货地址
	private int customerId;			//客户id
	
	
	
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getReceivedAddress() {
		return receivedAddress;
	}
	public void setReceivedAddress(String receivedAddress) {
		this.receivedAddress = receivedAddress;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
