package edu.lys.entity;

/**
 * @Author lys
 * @Date 2018年12月5日17:00:22
 * @Description 商品成分表实体类
 * */
public class Composition {

	private int compositionId;		//成分id
	private String compositionName;	//成分名称
	private int marqueId;			//型号id
	
	
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
	public int getMarqueId() {
		return marqueId;
	}
	public void setMarqueId(int marqueId) {
		this.marqueId = marqueId;
	}
	
}
