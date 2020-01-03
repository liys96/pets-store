package edu.lys.dao;

import java.util.List;

import edu.lys.entity.Commodity;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Page;

public interface ICommodity {

	//添加商品
	public boolean addCommodity(Commodity commodity);
	
	//查找所有商品模糊分页
	public List<CommodityVO> searchAllCommodity(Page<CommodityVO> page);
	
	//查询总记录数
	public int searchCount(Page<CommodityVO> page);
	
	//根据id查找商品
	public Commodity searchCommodityById(int id);
	
	//修改商品
	public boolean updateCommodityById(Commodity commodity);
	
	//注销商品状态
	public boolean cancelCommodityState(int id);
	
	//恢复商品状态
	public boolean recoverCommodityState(int id);
}
