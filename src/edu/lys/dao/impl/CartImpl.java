package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.lys.dao.ICart;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Order;
import edu.lys.entity.OrdercommodityVO;
import edu.lys.entity.Shopcart;
import edu.lys.entity.ShopcartVO;
import edu.lys.utils.BaseDao;

public class CartImpl implements ICart {

	@Override
	public boolean addCart(Shopcart cart) {
		// TODO Auto-generated method stub
		
		String sql="insert into t_shopcart values(seq_shopcart.nextval,?,?,?,?)"; 
		Object rs[] = {
				cart.getCommodityId(),
				cart.getCommodityAmount(),
				cart.getCommodityMoney(),
				cart.getCustomerId()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public int[] searchCartAmount(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int[] arr = null;
		try {
			String sql = "select count(*) count,sum(commodity_money) totalmoney from t_shopcart where customer_id = ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				arr = new int[2];
				arr[0] = rs.getInt(1);
				arr[1] = rs.getInt(2);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return arr;
	}

	@Override
	public List<ShopcartVO> searchCartInfo(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ShopcartVO shopcartVO = null;
		List<ShopcartVO> list = new ArrayList<ShopcartVO>();
		try {
			String sql = "select t.*,t1.commodity_title,t1.commodity_price,t1.commodity_headpic from t_shopcart t,t_commodity t1 where t.commodity_id = t1.commodity_id and  customer_id = ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				shopcartVO = new ShopcartVO();
				shopcartVO.setShopcartId(rs.getInt(1));
				shopcartVO.setCommodityId(rs.getInt(2));
				shopcartVO.setCommodityAmount(rs.getInt(3));
				shopcartVO.setCommodityMoney(rs.getInt(4));
				shopcartVO.setCustomerId(rs.getInt(5));
				shopcartVO.setCommodityTitle(rs.getString(6));
				shopcartVO.setCommodityPrice(rs.getInt(7));
				shopcartVO.setCommodityHeadPic(rs.getString(8));
				list.add(shopcartVO);
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
	public boolean deleteCart(int cartId) {
		// TODO Auto-generated method stub
		String sql="delete from t_shopcart where shopcart_id = ? "; 
		Object rs[] = {
				cartId
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean clearCart(int cusId) {
		// TODO Auto-generated method stub
		String sql="delete from t_shopcart where customer_id = ?"; 
		Object rs[] = {
				cusId
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public String checkPayWord(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String payWord = null;
		try {
			String sql = "select customer_paypassword from t_customer where customer_id = ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				payWord = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return payWord;
	}

	@Override
	public int selectNextOrderId() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String sql = "select seq_order.nextval from dual";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return id;
	}

	@Override
	public boolean addcOrder(int id, Order order) {
		// TODO Auto-generated method stub
		String sql="insert into t_order values(?,?,?,sysdate,0,?)"; 
		Object rs[] = {
				id,
				order.getSerialNumber(),
				order.getTotalMoney(),
				order.getCustomerId()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean addcOrderCommodity(int id,OrdercommodityVO commodity) {
		// TODO Auto-generated method stub
		String sql="insert into t_ordercommodity values(?,?,?,?)"; 
		Object rs[] = {
				id,
				commodity.getCommodityId(),
				commodity.getOrderCommodityAmount(),
				commodity.getOrderCommodityMoney()
		};
		return BaseDao.update(sql,rs);
	}

}
