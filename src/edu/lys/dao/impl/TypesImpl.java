package edu.lys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.lys.dao.ITypes;
import edu.lys.entity.Composition;
import edu.lys.entity.Marque;
import edu.lys.entity.Types;
import edu.lys.entity.User;
import edu.lys.utils.BaseDao;

public class TypesImpl implements ITypes {

	@Override
	public List<Types> searchAllTypes() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Types> list = new ArrayList<Types>();
		try {
			String sql = "select * from t_types";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Types types = new Types();
				types.setTypesId(rs.getInt(1));
				types.setTypesName(rs.getString(2));
				list.add(types);
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
	public List<Marque> searchMarqueByTypesId(int typesId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Marque> list = new ArrayList<Marque>();
		try {
			String sql = "select * from t_marque where types_id = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, typesId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Marque marque = new Marque();
				marque.setMarqueId(rs.getInt(1));
				marque.setMarqueName(rs.getString(2));
				marque.setTypesId(rs.getInt(3));
				list.add(marque);
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
	public List<Composition> searchCompositionByMarqueId(int marqueId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Composition> list = new ArrayList<Composition>();
		try {
			String sql = "select * from t_composition where marque_id = ?";
			conn = BaseDao.getConn(); 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, marqueId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Composition composition = new Composition();
				composition.setCompositionId(rs.getInt(1));
				composition.setCompositionName(rs.getString(2));
				composition.setMarqueId(rs.getInt(3));
				list.add(composition);
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
