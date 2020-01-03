package edu.lys.dao;

import java.util.List;

import edu.lys.entity.Commodity;
import edu.lys.entity.InventoryVO;
import edu.lys.entity.Page;

public interface IInventory {

	//查询所有客户带模糊条件
	public List<InventoryVO> searchAllInventory(Page<InventoryVO> page);
		
	//查询总记录数
	public int searchCount(Page<InventoryVO> page);
	
	//添加库存
	public boolean addInventory(InventoryVO inventoryVO);
	
	//查找所有商品名及id
	public List<Commodity> searchAllCommodity();
}
