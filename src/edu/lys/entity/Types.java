package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月5日16:56:31
 * @Description 商品类型表实体类
 * */
public class Types {
	
	private int typesId;		//类型id
	private String typesName;	//类型名称
	
	
	public int getTypesId() {
		return typesId;
	}
	public void setTypesId(int typesId) {
		this.typesId = typesId;
	}
	public String getTypesName() {
		return typesName;
	}
	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}
	
}
