package edu.lys.entity;

import java.util.Date;

/**
 * @Author lys
 * @Date 2018年12月14日15:28:04
 * @Description 评价表VO类
 * */
public class AppraiseVO {

	private int rn;						//rn
	private int appraiseId;				//评价id
	private String appraiseContent;		//评价内容
	private Date appraiseDate;			//评价日期
	private int customerId;				//客户id
	private int commodityId	;			//商品id
	private String customerName;		//客户姓名
	private String customerPic;			//客户头像
	
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPic() {
		return customerPic;
	}
	public void setCustomerPic(String customerPic) {
		this.customerPic = customerPic;
	}
	
	
	
	
}
