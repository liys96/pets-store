package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月17日10:27:37
 * @Description 购物车表VO类
 * */
public class ShopcartVO {

	private int shopcartId;			//购物车id
	private int commodityId;		//商品id
	private int commodityAmount;	//商品数量
	private int commodityMoney;	//商品金额
	private int customerId;			//客户id
	private String commodityHeadPic;	//商品图片
	private String  commodityTitle;		//商品标题
	private int commodityPrice;		//商品单价
	
	
	
	
	public String getCommodityHeadPic() {
		return commodityHeadPic;
	}
	public void setCommodityHeadPic(String commodityHeadPic) {
		this.commodityHeadPic = commodityHeadPic;
	}
	public String getCommodityTitle() {
		return commodityTitle;
	}
	public void setCommodityTitle(String commodityTitle) {
		this.commodityTitle = commodityTitle;
	}
	public int getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(int commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
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
	public int getCommodityMoney() {
		return commodityMoney;
	}
	public void setCommodityMoney(int commodityMoney) {
		this.commodityMoney = commodityMoney;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
