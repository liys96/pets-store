package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.lys.dao.ICommodity;
import edu.lys.entity.Commodity;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Customer;
import edu.lys.entity.Page;
import edu.lys.utils.BaseDao;

public class CommodityImpl implements ICommodity {

	@Override
	public boolean addCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		String sql="insert into t_commodity values(seq_commodity.nextval,?,?,?,?,?,sysdate,1,?,?)"; 
		Object rs[] = {
				commodity.getCommodityTitle(),
				commodity.getCommodityHeadpic(),
				commodity.getCommodityPrice(),
				commodity.getCommodityQuantity(),
				commodity.getCommodityDescription(),
				commodity.getCompositionId(),
				commodity.getUnit()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public List<CommodityVO> searchAllCommodity(Page<CommodityVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CommodityVO> list = new ArrayList<CommodityVO>();
		try {
			String sql = "select * from(select rownum rn,t4.* from (select t.*,t1.composition_name,t2.marque_name,t3.types_id,t3.types_name from t_commodity t , t_composition t1 ,t_marque t2 , t_types t3 where t.composition_id = t1.composition_id and t1.marque_id = t2.marque_id and t2.types_id = t3.types_id ";
			if(page.getEntity().getCommodityTitle() != null && !"".equals(page.getEntity().getCommodityTitle())){
				sql += " and t.commodity_title like '%" + page.getEntity().getCommodityTitle() + "%'";
			}
			if(page.getEntity().getTypesId() != -1){
				sql += " and t3.types_id = "+page.getEntity().getTypesId() +"";
			}
			if(page.getEntity().getState() != -1) {
				sql += " and t.commodity_state = " + page.getEntity().getState() + " ";
				
			}
			sql += " ) t4) t5 where rn between ? and ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, page.getStartIndex());
			pstm.setInt(2, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				CommodityVO commodity = new CommodityVO();
				commodity.setRn(rs.getInt(1));
				commodity.setCommodityId(rs.getInt(2));
				commodity.setCommodityTitle(rs.getString(3));
				commodity.setCommodityHeadpic(rs.getString(4));
				commodity.setCommodityPrice(rs.getInt(5));
				commodity.setCommodityQuantity(rs.getString(6));
				commodity.setCommodityDescription(rs.getString(7));
				commodity.setCreateDate(rs.getDate(8));
				commodity.setState(rs.getInt(9));
				commodity.setCompositionId(rs.getInt(10));
				commodity.setCompositionName(rs.getString(12));
				commodity.setMarqueName(rs.getString(13));
				commodity.setTypesId(rs.getInt(14));
				commodity.setTypesName(rs.getString(15));
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

	@Override
	public int searchCount(Page<CommodityVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from(select rownum rn,t4.* from (select t.*,t1.composition_name,t2.marque_name,t3.types_id,t3.types_name from t_commodity t , t_composition t1 ,t_marque t2 , t_types t3 where t.composition_id = t1.composition_id and t1.marque_id = t2.marque_id and t2.types_id = t3.types_id ";
			if(page.getEntity().getCommodityTitle() != null && !"".equals(page.getEntity().getCommodityTitle())){
				sql += " and t.commodity_title like '%" + page.getEntity().getCommodityTitle() + "%'";
			}
			if(page.getEntity().getTypesId() != -1){
				sql += " and t3.types_id = "+page.getEntity().getTypesId() +"";
			}
			if(page.getEntity().getState() != -1) {
				sql += " and t.commodity_state = " + page.getEntity().getState() + " ";
				
			}
			sql += " ) t4) t5";
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
	public Commodity searchCommodityById(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Commodity commodity = null;
		try {
			String sql = "select * from t_commodity where commodity_id = ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				commodity = new Commodity();
				commodity.setCommodityId(rs.getInt(1));
				commodity.setCommodityTitle(rs.getString(2));
				commodity.setCommodityHeadpic(rs.getString(3));
				commodity.setCommodityPrice(rs.getInt(4));
				commodity.setCommodityDescription(rs.getString(6));
				commodity.setState(rs.getInt(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return commodity;
	}

	@Override
	public boolean updateCommodityById(Commodity commodity) {
		// TODO Auto-generated method stub
		String sql="update t_commodity set commodity_title = ?, ";
		if(commodity.getCommodityHeadpic() != null && !"".equals(commodity.getCommodityHeadpic())){
			sql += " commodity_headpic = ?,";
		}
		sql +="commodity_price = ?,commodity_description = ?,commodity_state = ? where commodity_id = ? ";		
		List<Object> list = new ArrayList<Object>();
		list.add(commodity.getCommodityTitle());
		list.add(commodity.getCommodityPrice());
		list.add(commodity.getCommodityDescription());
		list.add(commodity.getState());
		list.add(commodity.getCommodityId());
		if(commodity.getCommodityHeadpic()!=null && !"".equals(commodity.getCommodityHeadpic())) {
			int index = 1;
			String value = commodity.getCommodityHeadpic();
			List<Object> newlist = new ArrayList<Object>(); 
			//将原数组数据赋值给新数组
			for (int i = 0; i < list.size(); i++) { 
				newlist.add(list.get(i)); 
			} 
			//将大于i的数据向后移动一位 
			for (int i =list.size()-1;i>index; i--) { 
				newlist.set(i, newlist.get(i-1));
				} 
			newlist.add(list.get(4));
			//赋值到index位置 
			newlist.set(index, value);
			list.add(1);
			for(int i =0;i<list.size();i++) {
				list.set(i, newlist.get(i));
			}
		}
	
		return BaseDao.update1(sql,list);
	

}

	@Override
	public boolean cancelCommodityState(int id) {
		// TODO Auto-generated method stub
		String sql="update t_commodity set commodity_state  = 0 where commodity_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean recoverCommodityState(int id) {
		// TODO Auto-generated method stub
		String sql="update t_commodity set commodity_state  = 1 where commodity_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}
}