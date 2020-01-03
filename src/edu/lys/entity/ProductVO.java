package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月13日16:48:36
 * @Description 商品详情类
 * */
public class ProductVO {

	private int commodityId;		//商品id
	private String commodityTitle;	//商品标题
	private String commodityHeadPic;	//商品图片
	private int commodityPrice;			//商品价格
	private String commodityQuantity;	//商品净含量
	private String commodityUnit;		//商品单位
	private int compositionId;			//成分id
	private int commodityInventory;		//商品库存
	private int appraiseAmount;			//评价数量
	private int saleAmount;				//销售数量
	private String description;			//描述
	private String AccSale;				//按销量
	private String AccTime;				//按时间
	private String AccAppraise;			//按评价
	private String AccPrice;			//按价格
	
	
	
	public String getAccTime() {
		return AccTime;
	}
	public void setAccTime(String accTime) {
		AccTime = accTime;
	}
	public String getAccAppraise() {
		return AccAppraise;
	}
	public void setAccAppraise(String accAppraise) {
		AccAppraise = accAppraise;
	}
	public String getAccPrice() {
		return AccPrice;
	}
	public void setAccPrice(String accPrice) {
		AccPrice = accPrice;
	}
	public String getAccSale() {
		return AccSale;
	}
	public void setAccSale(String accSale) {
		AccSale = accSale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}
	public int getAppraiseAmount() {
		return appraiseAmount;
	}
	public void setAppraiseAmount(int appraiseAmount) {
		this.appraiseAmount = appraiseAmount;
	}
	public int getCompositionId() {
		return compositionId;
	}
	public void setCompositionId(int compositionId) {
		this.compositionId = compositionId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getCommodityTitle() {
		return commodityTitle;
	}
	public void setCommodityTitle(String commodityTitle) {
		this.commodityTitle = commodityTitle;
	}
	public String getCommodityHeadPic() {
		return commodityHeadPic;
	}
	public void setCommodityHeadPic(String commodityHeadPic) {
		this.commodityHeadPic = commodityHeadPic;
	}
	public int getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(int commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public String getCommodityQuantity() {
		return commodityQuantity;
	}
	public void setCommodityQuantity(String commodityQuantity) {
		this.commodityQuantity = commodityQuantity;
	}
	public String getCommodityUnit() {
		return commodityUnit;
	}
	public void setCommodityUnit(String commodityUnit) {
		this.commodityUnit = commodityUnit;
	}
	public int getCommodityInventory() {
		return commodityInventory;
	}
	public void setCommodityInventory(int commodityInventory) {
		this.commodityInventory = commodityInventory;
	}
	
	
	
}
