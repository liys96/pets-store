package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import edu.lys.dao.IOrder;
import edu.lys.entity.Appraise;
import edu.lys.entity.OrderVO;
import edu.lys.entity.OrdercommodityVO;
import edu.lys.entity.Page;
import edu.lys.utils.BaseDao;
import sun.security.x509.SerialNumber;

public class OrderImpl implements IOrder {

	@Override
	public List<OrderVO> searchAllOrder(Page<OrderVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			String sql = "select * from (select rownum rn,t2.* from(select t.*,t1.customer_name,t1.customer_receivedaddress from t_order t,t_customer t1 where t.customer_id = t1.customer_id ";
			if(page.getEntity().getSerialNumber() != null && !"".equals(page.getEntity().getSerialNumber())){
				sql += " and t.order_serialnumber like '%" + page.getEntity().getSerialNumber() + "%'";
			}
			if(page.getEntity().getOrderState() != -1) {
				sql += " and t.order_state = " + page.getEntity().getOrderState() + " ";
				
			}
			sql += ") t2) t3 where rn between ? and ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, page.getStartIndex());
			pstm.setInt(2, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				OrderVO orderVO = new OrderVO();
				orderVO.setRn(rs.getInt(1));
				orderVO.setOrderId(rs.getInt(2));
				orderVO.setSerialNumber(rs.getString(3));
				orderVO.setTotalMoney(rs.getInt(4));
				orderVO.setOrderDate(rs.getDate(5));
				orderVO.setOrderState(rs.getInt(6));
				orderVO.setCustomerId(rs.getInt(7));
				orderVO.setCustomerName(rs.getString(8));
				orderVO.setReceivedAddress(rs.getString(9));				
				list.add(orderVO);
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
	public int searchCount(Page<OrderVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from (select rownum rn,t2.* from(select t.*,t1.customer_name,t1.customer_receivedaddress from t_order t,t_customer t1 where t.customer_id = t1.customer_id ";
			if(page.getEntity().getSerialNumber() != null && !"".equals(page.getEntity().getSerialNumber())){
				sql += " and t.order_serialnumber like '%" + page.getEntity().getSerialNumber() + "%'";
			}
			if(page.getEntity().getOrderState() != -1) {
				sql += " and t.order_state = " + page.getEntity().getOrderState() + " ";
				
			}
			sql += ") t2)";
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
	public OrderVO searchOrderInfo(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		OrderVO orderVO = null;
		try {
			String sql = "select t.*,t1.customer_name,t1.customer_phonenumber,t1.customer_receivedaddress from t_order t,t_customer t1 where t.customer_id = t1.customer_id and t.order_id = ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderId(rs.getInt(1));
				orderVO.setSerialNumber(rs.getString(2));
				orderVO.setTotalMoney(rs.getInt(3));
				orderVO.setOrderDate(rs.getDate(4));
				orderVO.setOrderState(rs.getInt(5));
				orderVO.setCustomerName(rs.getString(7));
				orderVO.setCustomerPhoneNumber(rs.getString(8));
				orderVO.setReceivedAddress(rs.getString(9));				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return orderVO;
	}

	@Override
	public List<OrdercommodityVO> searchOrderCommodity(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<OrdercommodityVO> list = new ArrayList<OrdercommodityVO>();
		try {
			String sql = "select rownum rn ,t2.* from(select t.*,t1.commodity_title,t1.commodity_headpic,t1.commodity_price from t_ordercommodity t,t_commodity t1 where t.commodity_id = t1.commodity_id and t.order_id = ?) t2";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				OrdercommodityVO ordercommodityVO = new OrdercommodityVO();
				ordercommodityVO.setRn(rs.getInt(1));
				ordercommodityVO.setOrderId(rs.getInt(2));
				ordercommodityVO.setCommodityId(rs.getInt(3));
				ordercommodityVO.setOrderCommodityAmount(rs.getInt(4));
				ordercommodityVO.setOrderCommodityMoney(rs.getInt(5));
				ordercommodityVO.setCommodityTitle(rs.getString(6));
				ordercommodityVO.setCommodityHeadpic(rs.getString(7));
				ordercommodityVO.setCommodityPrice(rs.getInt(8));				
				list.add(ordercommodityVO);
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
	public int searchInventryAmount(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int amount = 0;
		try {
			String sql = "select inventory_amount from t_inventory where commodity_id = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {							
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, pstm, conn);
		}	
		return amount;
	}

	@Override
	public boolean changeInventryAmount(int amount,int id) {
		// TODO Auto-generated method stub
		String sql="update t_inventory set inventory_amount  = ? where commodity_id = ?"; 
		Object rs[] = {amount,id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean sendOrder(int id) {
		// TODO Auto-generated method stub
		String sql="update t_order set order_state  = 1 where order_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean backOrder(int id) {
		// TODO Auto-generated method stub
		String sql="update t_order set order_state  = 5 where order_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public StringBuffer serialNumber() {
		// TODO Auto-generated method stub
		int totalCount = orderCount();
		totalCount++;
		StringBuffer sb = new StringBuffer("OD");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append(sdf.format(new Date()));
		if (totalCount < 10 && totalCount >= 0) {
			sb.append("000" + totalCount);
		} else if (totalCount < 100 && totalCount >= 10) {
			sb.append("00" + totalCount);
		} else if (totalCount < 1000 && totalCount >= 100) {
			sb.append("0" + totalCount);
		} else {
			sb.append(totalCount);
		}
		return sb;
	}

	@Override
	public int orderCount() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from t_order ";
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

	//前台订单模糊
	@Override
	public List<OrderVO> searchcOrder(int id,Page<OrderVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			String sql = "select * from (select rownum rn,t.* from t_order t where customer_id = ? ";
			if(page.getEntity().getSerialNumber() != null && !"".equals(page.getEntity().getSerialNumber())){
				sql += " and order_serialnumber like '%" + page.getEntity().getSerialNumber() + "%'";
			}
			if(page.getEntity().getOrderState() != -1) {
				sql += " and order_state = " + page.getEntity().getOrderState() + " ";
				
			}
			//若起始时间和结束时间都不为空,则都需要拼接在Sql语句中
			if((page.getStartTimeStr() != null && !"".equals(page.getStartTimeStr()))
				&&
				(page.getEndTimeStr() != null && !"".equals(page.getEndTimeStr()))){
				sql += " and order_date between to_date('"+page.getStartTimeStr()+"','yyyy-mm-dd HH24:mi:ss') and to_date('"+page.getEndTimeStr()+"','yyyy-mm-dd HH24:mi:ss') ";
			}
			//若起始时间不为空,结束时间为空,则只需要拼接如下Sql语句
			if((page.getStartTimeStr() != null && !"".equals(page.getStartTimeStr()))
					&&
					(page.getEndTimeStr() == null || "".equals(page.getEndTimeStr()))){
					sql += " and order_date >= to_date('"+page.getStartTimeStr()+"','yyyy-mm-dd HH24:mi:ss') ";
			}
			//若起始时间为空,结束时间不为空,则只需要拼接如下Sql语句
			if((page.getStartTimeStr() == null || "".equals(page.getStartTimeStr()))
					&&
					(page.getEndTimeStr() != null && !"".equals(page.getEndTimeStr()))){
					sql += " and order_date <= to_date('"+page.getEndTimeStr()+"','yyyy-mm-dd HH24:mi:ss') ";
			}
			sql += ") where rn between ? and ? ";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setInt(2, page.getStartIndex());
			pstm.setInt(3, page.getEndIndex());
			rs = pstm.executeQuery();
			while(rs.next()) {
				OrderVO orderVO = new OrderVO();
				orderVO.setRn(rs.getInt(1));
				orderVO.setOrderId(rs.getInt(2));	
				orderVO.setSerialNumber(rs.getString(3));
				orderVO.setTotalMoney(rs.getInt(4));
				orderVO.setOrderDate(rs.getDate(5));
				orderVO.setOrderState(rs.getInt(6));
				orderVO.setCustomerId(rs.getInt(7));
				list.add(orderVO);
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
	public int searchcOrderCount(int id,Page<OrderVO> page) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from (select rownum rn,t.* from t_order t where customer_id = ? ";
			if(page.getEntity().getSerialNumber() != null && !"".equals(page.getEntity().getSerialNumber())){
				sql += " and order_serialnumber like '%" + page.getEntity().getSerialNumber() + "%'";
			}
			if(page.getEntity().getOrderState() != -1) {
				sql += " and order_state = " + page.getEntity().getOrderState() + " ";
				
			}
			//若起始时间和结束时间都不为空,则都需要拼接在Sql语句中
			if((page.getStartTimeStr() != null && !"".equals(page.getStartTimeStr()))
				&&
				(page.getEndTimeStr() != null && !"".equals(page.getEndTimeStr()))){
				sql += " and order_date between to_date('"+page.getStartTimeStr()+"','yyyy-mm-dd HH24:mi:ss') and to_date('"+page.getEndTimeStr()+"','yyyy-mm-dd HH24:mi:ss') ";
			}
			//若起始时间不为空,结束时间为空,则只需要拼接如下Sql语句
			if((page.getStartTimeStr() != null && !"".equals(page.getStartTimeStr()))
					&&
					(page.getEndTimeStr() == null || "".equals(page.getEndTimeStr()))){
					sql += " and order_date >= to_date('"+page.getStartTimeStr()+"','yyyy-mm-dd HH24:mi:ss') ";
			}
			//若起始时间为空,结束时间不为空,则只需要拼接如下Sql语句
			if((page.getStartTimeStr() == null || "".equals(page.getStartTimeStr()))
					&&
					(page.getEndTimeStr() != null && !"".equals(page.getEndTimeStr()))){
					sql += " and order_date <= to_date('"+page.getEndTimeStr()+"','yyyy-mm-dd HH24:mi:ss') ";
			}
			sql +=" )";
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

	@Override
	public boolean cancelOrder(int id) {
		// TODO Auto-generated method stub
		String sql="update t_order set order_state  = 6 where order_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean receiveOrder(int id) {
		// TODO Auto-generated method stub
		String sql="update t_order set order_state  = 2 where order_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean returnOrder(int id) {
		// TODO Auto-generated method stub
		String sql="update t_order set order_state  = 4 where order_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean addAppraise(Appraise appraise) {
		// TODO Auto-generated method stub
		String sql="insert into t_appraise values(seq_appraise.nextval,?,sysdate,?,?)"; 
		Object rs[] = {
				appraise.getAppraiseContent(),
				appraise.getCustomerId(),
				appraise.getCommodityId()
		};
		return BaseDao.update(sql,rs);
	}

	@Override
	public boolean finishOrder(int id) {
		// TODO Auto-generated method stub
		String sql="update t_order set order_state  = 7 where order_id = ?"; 
		Object rs[] = {id};
		return BaseDao.update(sql,rs);
	}


}
