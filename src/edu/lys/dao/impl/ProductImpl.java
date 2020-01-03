package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;      
import edu.lys.dao.IProduct;
import edu.lys.entity.Appraise;
import edu.lys.entity.AppraiseVO;
import edu.lys.entity.Commodity;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Page;
import edu.lys.entity.ProductVO;
import edu.lys.utils.BaseDao;

public class ProductImpl implements IProduct {

	@Override
	public List<ProductVO> searchAllProduct(Page<ProductVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			String sql = "select * from(\r\n" + 
					"select rownum rn ,t8.* from (\r\n" + 
					"select t7.inventory_amount,t6.* from(\r\n" + 
					"\r\n" + 
					"    select t4.appraiseamount,t5.* from (\r\n" + 
					"    select t1.saleamount,t2.* from(\r\n" + 
					"    select commodity_id,sum(commodity_amount) saleamount from t_ordercommodity where order_id in(\r\n" + 
					"    (select order_id from t_order where order_state = 2) \r\n" + 
					"    )group by commodity_amount,commodity_id) t1, t_commodity t2 where t1.commodity_id(+) = t2.commodity_id\r\n" + 
					"    ) t5,\r\n" + 
					"\r\n" + 
					"    (\r\n" + 
					"    select commodity_id,count(commodity_id) appraiseamount  from t_appraise group by commodity_id\r\n" + 
					"    ) t4 where t4.commodity_id(+) = t5.commodity_id \r\n" + 
					"\r\n" + 
					") t6,t_inventory t7 where t6.commodity_id  = t7.commodity_id and commodity_state = 1 ";
			if(page.getEntity().getCommodityTitle() != null && !"".equals(page.getEntity().getCommodityTitle())){
				sql += " and t6.commodity_title like '%" + page.getEntity().getCommodityTitle() + "%'";
			}
			if(page.getEntity().getCompositionId() != -1) {
				sql += " and t6.composition_id = " + page.getEntity().getCompositionId() + " ";
				
			}
			if(page.getEntity().getAccSale() != null && !"".equals(page.getEntity().getAccSale())){
				sql += "order by saleamount ";
			}
			if(page.getEntity().getAccTime() != null && !"".equals(page.getEntity().getAccTime())){
				sql += "order by commodity_createdate ";
			}
			if(page.getEntity().getAccAppraise() != null && !"".equals(page.getEntity().getAccAppraise())){
				sql += "order by appraiseamount ";
			}
			if(page.getEntity().getAccPrice() != null && !"".equals(page.getEntity().getAccPrice())){
				sql += "order by commodity_price ";
			}
			
			sql += ") t8) t9 where rn between ? and ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, page.getStartIndex());
			pstm.setInt(2, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				productVO.setCommodityInventory(rs.getInt(2));
				productVO.setAppraiseAmount(rs.getInt(3));
				productVO.setSaleAmount(rs.getInt(4));
				productVO.setCommodityId(rs.getInt(5));
				productVO.setCommodityTitle(rs.getString(6));
				productVO.setCommodityHeadPic(rs.getString(7));
				productVO.setCommodityPrice(rs.getInt(8));
				productVO.setCommodityQuantity(rs.getString(9));
				productVO.setCommodityUnit(rs.getString(14));
				list.add(productVO);
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
	public int searchCount(Page<ProductVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from(\r\n" + 
					"select rownum rn ,t8.* from (\r\n" + 
					"select t7.inventory_amount,t6.* from(\r\n" + 
					"\r\n" + 
					"    select t4.appraiseamount,t5.* from (\r\n" + 
					"    select t1.saleamount,t2.* from(\r\n" + 
					"    select commodity_id,sum(commodity_amount) saleamount from t_ordercommodity where order_id in(\r\n" + 
					"    (select order_id from t_order where order_state = 2) \r\n" + 
					"    )group by commodity_amount,commodity_id) t1, t_commodity t2 where t1.commodity_id(+) = t2.commodity_id\r\n" + 
					"    ) t5,\r\n" + 
					"\r\n" + 
					"    (\r\n" + 
					"    select commodity_id,count(commodity_id) appraiseamount  from t_appraise group by commodity_id\r\n" + 
					"    ) t4 where t4.commodity_id(+) = t5.commodity_id \r\n" + 
					"\r\n" + 
					") t6,t_inventory t7 where t6.commodity_id  = t7.commodity_id and commodity_state = 1";
			if(page.getEntity().getCommodityTitle() != null && !"".equals(page.getEntity().getCommodityTitle())){
				sql += " and t6.commodity_title like '%" + page.getEntity().getCommodityTitle() + "%'";
			}
			if(page.getEntity().getCompositionId() != -1) {
				sql += " and t6.composition_id = " + page.getEntity().getCompositionId() + " ";
				
			}
			sql += ") t8) t9";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
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
	public CommodityVO searchCommodityInfo(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		CommodityVO commodityVO = null;
		try {
			String sql = "select * from t_commodity t,t_inventory t1 where t.commodity_id = t1.commodity_id and t.commodity_id = ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				commodityVO = new CommodityVO();				
				commodityVO.setCommodityId(rs.getInt(1));
				commodityVO.setCommodityTitle(rs.getString(2));
				commodityVO.setCommodityHeadpic(rs.getString(3));
				commodityVO.setCommodityPrice(rs.getInt(4));
				commodityVO.setCommodityQuantity(rs.getString(5));
				commodityVO.setCommodityDescription(rs.getString(6));
				commodityVO.setCommodityUnit(rs.getString(10));
				commodityVO.setInventoryAmount(rs.getInt(12));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return commodityVO;
	}

	@Override
	public List<AppraiseVO> searchAllAppraise(Page<AppraiseVO> page,int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AppraiseVO> list = new ArrayList<AppraiseVO>();
		try {
			String sql = "select * from (\r\n" + 
					"select rownum rn ,t3.* from(\r\n" + 
					"select t1.*,t2.customer_headpic,t2.customer_name from t_commodity t,t_appraise t1,t_customer t2 where t.commodity_id = t1.commodity_id and t1.customer_id = t2.customer_id\r\n" + 
					"\r\n" + 
					"and t1.commodity_id = ? order by appraise_date desc) t3) t4 where rn between ? and ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setInt(2, page.getStartIndex());
			pstm.setInt(3, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				AppraiseVO appraiseVO = new AppraiseVO();
				appraiseVO.setRn(rs.getInt(1));
				appraiseVO.setAppraiseId(rs.getInt(2));
				appraiseVO.setAppraiseContent(rs.getString(3));
				appraiseVO.setAppraiseDate(rs.getDate(4));
				appraiseVO.setCommodityId(rs.getInt(6));
				appraiseVO.setCustomerPic(rs.getString(7));
				appraiseVO.setCustomerName(rs.getString(8));				
				list.add(appraiseVO);
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
	public int searchAppraiseCount(Page<AppraiseVO> page,int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from (\r\n" + 
					"select rownum rn ,t3.* from(\r\n" + 
					"select t1.*,t2.customer_headpic,t2.customer_name from t_commodity t,t_appraise t1,t_customer t2 where t.commodity_id = t1.commodity_id and t1.customer_id = t2.customer_id\r\n" + 
					"\r\n" + 
					"and t1.commodity_id = ? order by appraise_date desc) t3) t4 ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
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


}
