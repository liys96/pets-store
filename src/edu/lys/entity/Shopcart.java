package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月5日17:18:22
 * @Description 购物车表实体类
 * */
public class Shopcart {

	private int shopcartId;			//购物车id
	private int commodityId;		//商品id
	private int commodityAmount;	//商品数量
	private double commodityMoney;	//商品金额
	private int customerId;			//客户id
	
	
	public int getShopcartId() {
		return shopcartId;
	}
	public void setShopcartId(int shopcartId) {
		this.shopcartId = shopcartId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public int getCommodityAmount() {
		return commodityAmount;
	}
	public void setCommodityAmount(int commodityAmount) {
		this.commodityAmount = commodityAmount;
	}
	public double getCommodityMoney() {
		return commodityMoney;
	}
	public void setCommodityMoney(double commodityMoney) {
		this.commodityMoney = commodityMoney;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
