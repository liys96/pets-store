package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月5日16:58:45
 * @Description 商品型号表实体类
 * */
public class Marque {

	private int marqueId;		//型号id
	private String marqueName;	//型号名称
	private int typesId;		//类型id
	public int getMarqueId() {
		return marqueId;
	}
	public void setMarqueId(int marqueId) {
		this.marqueId = marqueId;
	}
	public String getMarqueName() {
		return marqueName;
	}
	public void setMarqueName(String marqueName) {
		this.marqueName = marqueName;
	}
	public int getTypesId() {
		return typesId;
	}
	public void setTypesId(int typesId) {
		this.typesId = typesId;
	}
	
	
}
