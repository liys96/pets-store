package edu.lys.entity;

import java.util.Date;

/**
 * @Author lys
 * @Date 2018年12月11日17:14:40
 * @Description 商品VO类
 * */
public class CommodityVO {

	private int rn;							//RN
	private int commodityId;				//商品id
	private String commodityTitle;			//商品标题
	private String commodityHeadpic;		//商品图片
	private int commodityPrice;				//商品价格
	private String commodityQuantity;		//商品净含量
	private String commodityDescription;	//商品描述
	private Date createDate;				//创建时间
	private int state;						//状态
	private int compositionId;				//成分id
	private String compositionName;			//成分名
	private String marqueName;				//型号名
	private String typesName;				//类型名
	private int typesId;					//类型id
	private int inventoryAmount;			//库存数量
	private String commodityUnit;			//单位
	
	
	public String getCommodityUnit() {
		return commodityUnit;
	}
	public void setCommodityUnit(String commodityUnit) {
		this.commodityUnit = commodityUnit;
	}
	public int getInventoryAmount() {
		return inventoryAmount;
	}
	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getTypesId() {
		return typesId;
	}
	public void setTypesId(int typesId) {
		this.typesId = typesId;
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
	public String getCommodityHeadpic() {
		return commodityHeadpic;
	}
	public void setCommodityHeadpic(String commodityHeadpic) {
		this.commodityHeadpic = commodityHeadpic;
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
	public String getCommodityDescription() {
		return commodityDescription;
	}
	public void setCommodityDescription(String commodityDescription) {
		this.commodityDescription = commodityDescription;
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
	public int getCompositionId() {
		return compositionId;
	}
	public void setCompositionId(int compositionId) {
		this.compositionId = compositionId;
	}
	public String getCompositionName() {
		return compositionName;
	}
	public void setCompositionName(String compositionName) {
		this.compositionName = compositionName;
	}
	public String getMarqueName() {
		return marqueName;
	}
	public void setMarqueName(String marqueName) {
		this.marqueName = marqueName;
	}
	public String getTypesName() {
		return typesName;
	}
	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}
	
	
	
}
