package edu.lys.dao;

import java.util.List;

import edu.lys.entity.Appraise;
import edu.lys.entity.AppraiseVO;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Page;
import edu.lys.entity.ProductVO;

public interface IProduct {

	//根据商品成分及商品名查找所有商品(模糊)
	public List<ProductVO> searchAllProduct(Page<ProductVO> page);
	
	//查询总记录数
	public int searchCount(Page<ProductVO> page);

	//查看商品详情
	public CommodityVO searchCommodityInfo(int id); 
	
	//根据商品id查找对应评价
	public List<AppraiseVO> searchAllAppraise(Page<AppraiseVO> page,int id);
	
	//评价数量
	public int searchAppraiseCount(Page<AppraiseVO> page,int id);

	
}
