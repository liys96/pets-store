package edu.lys.entity;

import java.util.Date;

/**
 * @Author lys
 * @Date 2018年12月5日17:09:45
 * @Description 评价表实体类
 * */
public class Appraise {

	private int appraiseId;				//评价id
	private String appraiseContent;		//评价内容
	private Date appraiseDate;			//评价日期
	private int customerId;				//客户id
	private int commodityId	;			//商品id
	
	
	public int getAppraiseId() {
		return appraiseId;
	}
	public void setAppraiseId(int appraiseId) {
		this.appraiseId = appraiseId;
	}
	public String getAppraiseContent() {
		return appraiseContent;
	}
	public void setAppraiseContent(String appraiseContent) {
		this.appraiseContent = appraiseContent;
	}
	public Date getAppraiseDate() {
		return appraiseDate;
	}
	public void setAppraiseDate(Date appraiseDate) {
		this.appraiseDate = appraiseDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	
	
	
}
