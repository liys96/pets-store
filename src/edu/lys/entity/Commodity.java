package edu.lys.entity;

import java.util.Date;

/**
 * @Author lys
 * @Date 2018年12月5日17:03:18
 * @Description 商品表实体类
 * */
public class Commodity {

	private int commodityId;				//商品id
	private String commodityTitle;			//商品标题
	private String commodityHeadpic;		//商品图片
	private int commodityPrice;			//商品价格
	private String commodityQuantity;			//商品净含量
	private String commodityDescription;	//商品描述
	private Date createDate;				//创建时间
	private int state;						//状态
	private String unit;					//单位
	private int compositionId;				//成分id
	
	
	
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	
	
}
