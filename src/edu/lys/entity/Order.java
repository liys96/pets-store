package edu.lys.entity;

import java.util.Date;

/**
 * @Author lys
 * @Date 2018年12月5日17:12:14
 * @Description 订单表实体类
 * */
public class Order {

	private int orderId	;			//订单id
	private String serialNumber;	//订单编号
	private int totalMoney;		//订单总金额
	private Date  orderDate;		//下单时间
	private int orderState;			//状态
	private int customerId;			//客户id
	
	
	

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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
