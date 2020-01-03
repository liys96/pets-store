package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月12日14:43:52
 * @Description 库存VO类
 * */
public class InventoryVO {

	private int rn;					//rn
	private int inventoryId;		//库存id
	private int inventoryAmount;	//库存数量
	private int commodityId;		//商品id
	private int typesId;			//类型id
	private String typesName;		//类型名称
	private String marqueName;		//型号名称
	private String commodityTitle;	//商品名称
	private String unit;			//单位
	
	
	
	public int getTypesId() {
		return typesId;
	}
	public void setTypesId(int typesId) {
		this.typesId = typesId;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getCommodityTitle() {
		return commodityTitle;
	}
	public void setCommodityTitle(String commodityTitle) {
		this.commodityTitle = commodityTitle;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTypesName() {
		return typesName;
	}
	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}
	public String getMarqueName() {
		return marqueName;
	}
	public void setMarqueName(String marqueName) {
		this.marqueName = marqueName;
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getInventoryAmount() {
		return inventoryAmount;
	}
	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	
	
}
