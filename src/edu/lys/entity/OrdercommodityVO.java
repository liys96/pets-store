package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月5日17:15:49
 * @Description 订单商品表实体类
 * */
public class OrdercommodityVO {

	private int rn;							//rn
	private int orderId;					//订单id
	private int commodityId;				//商品id
	private String commodityTitle;			//商品名
	private String commodityHeadpic;		//图片
	private int orderCommodityAmount;		//订单商品数量
	private int commodityPrice;				//商品单价
	private int orderCommodityMoney;		//订单商品金额
	
	

	
	public String getCommodityHeadpic() {
		return commodityHeadpic;
	}
	public void setCommodityHeadpic(String commodityHeadpic) {
		this.commodityHeadpic = commodityHeadpic;
	}
	public String getCommodityTitle() {
		return commodityTitle;
	}
	public void setCommodityTitle(String commodityTitle) {
		this.commodityTitle = commodityTitle;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(int commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	
	public int getOrderCommodityAmount() {
		return orderCommodityAmount;
	}
	public void setOrderCommodityAmount(int orderCommodityAmount) {
		this.orderCommodityAmount = orderCommodityAmount;
	}
	public int getOrderCommodityMoney() {
		return orderCommodityMoney;
	}
	public void setOrderCommodityMoney(int orderCommodityMoney) {
		this.orderCommodityMoney = orderCommodityMoney;
	}
	
	
}
