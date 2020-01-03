package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.lys.dao.IInventory;
import edu.lys.entity.Commodity;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.InventoryVO;
import edu.lys.entity.Page;
import edu.lys.utils.BaseDao;

public class InventoryImpl implements IInventory {

	@Override
	public List<InventoryVO> searchAllInventory(Page<InventoryVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<InventoryVO> list = new ArrayList<InventoryVO>();
		try {
			String sql = "select * from(select rownum rn,t4.* from (select t.commodity_id,t.commodity_unit,t.commodity_title,t2.marque_name,t3.types_id,t3.types_name,t5.inventory_amount from t_inventory t5, t_commodity t ,t_composition t1, t_marque t2 , t_types t3 where t.commodity_id = t5.commodity_id and t.composition_id = t1.composition_id and t1.marque_id = t2.marque_id and  t2.types_id = t3.types_id ";
			if(page.getEntity().getCommodityTitle() != null && !"".equals(page.getEntity().getCommodityTitle())){
				sql += " and t.commodity_title like '%" + page.getEntity().getCommodityTitle() + "%'";
			}
			if(page.getEntity().getTypesId() != -1) {
				sql += " and t3.types_id = " + page.getEntity().getTypesId() + " ";				
			}
			sql += " ) t4)t6 where rn between ? and ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, page.getStartIndex());
			pstm.setInt(2, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				InventoryVO inventoryVO = new InventoryVO();
				inventoryVO.setRn(rs.getInt(1));
				inventoryVO.setCommodityId(rs.getInt(2));
				inventoryVO.setUnit(rs.getString(3));
				inventoryVO.setCommodityTitle(rs.getString(4));
				inventoryVO.setMarqueName(rs.getString(5));
				inventoryVO.setTypesId(rs.getInt(6));
				inventoryVO.setTypesName(rs.getString(7));
				inventoryVO.setInventoryAmount(rs.getInt(8));
				list.add(inventoryVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return list;
	}

	@Override
	public int searchCount(Page<InventoryVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from(select rownum rn,t4.* from (select t.commodity_id,t.commodity_unit,t.commodity_title,t2.marque_name,t3.types_id,t3.types_name,t5.inventory_amount from t_inventory t5, t_commodity t ,t_composition t1, t_marque t2 , t_types t3 where t.commodity_id = t5.commodity_id and t.composition_id = t1.composition_id and t1.marque_id = t2.marque_id and  t2.types_id = t3.types_id ";
			if(page.getEntity().getCommodityTitle() != null && !"".equals(page.getEntity().getCommodityTitle())){
				sql += " and t.commodity_title like '%" + page.getEntity().getCommodityTitle() + "%'";
			}
			if(page.getEntity().getTypesId() != -1) {
				sql += " and t3.types_id = " + page.getEntity().getTypesId() + " ";				
			}
			sql += " ) t4)";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				 count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return count;
	}

	@Override
	public boolean addInventory(InventoryVO inventoryVO) {
		// TODO Auto-generated method stub
		String sql="insert into t_inventory values(seq_inventory.nextval,?,?)"; 
		if(inventoryVO.getCommodityId() ==-1) {
			return false;
		}
		Object rs[] = {
				inventoryVO.getInventoryAmount(),
				inventoryVO.getCommodityId()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public List<Commodity> searchAllCommodity() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Commodity> list = new ArrayList<Commodity>();;
		try {
			String sql = "select commodity_id,commodity_title from t_commodity";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setCommodityId(rs.getInt(1));
				commodity.setCommodityTitle(rs.getString(2));
				list.add(commodity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return list;
	}
	

}
