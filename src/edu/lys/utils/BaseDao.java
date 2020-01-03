package edu.lys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BaseDao {

	
		//获取连接
	private static final String DB_DRIVER="oracle.jdbc.OracleDriver";
	private static final String DB_URL="jdbc:oracle:thin:localhost:1521:orcl";
	private static final String USER="SCOTT";
	private static final String PASS="admin";
	
	public static Connection getConn() {
		Connection conn = null;
		try {			
			 Class.forName(DB_DRIVER);
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		return conn;
	}
		//关闭数据库连接
		public static void closeAll(ResultSet rs,Statement pstm,Connection conn){
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstm != null){
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//update("select * from emp where emp_id= ? and emp_name= ?",1,"ww");
			
		}
		
		/**
		 * 支持添加,删除,修改
		 * */
		
		public static boolean update(String sql,Object...aaa){
			Connection conn = null;
			PreparedStatement pstm = null;
			int result = 0;
			boolean flag=false;
			try {
				conn = getConn();
				pstm = conn.prepareStatement(sql);
				for (int i = 0; i < aaa.length; i++) {
					pstm.setObject(i+1,aaa[i]);
				}
				result = pstm.executeUpdate();
				if(result!=0){
					flag=true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				closeAll(null, pstm, conn);
			}
			return flag;
		}
		
		public static boolean update1(String sql,List<Object> list){
			Connection conn = null;
			PreparedStatement pstm = null;
			int result = 0;
			boolean flag=false;
			try {
				conn = getConn();
				pstm = conn.prepareStatement(sql);
				for (int i = 0; i < list.size(); i++) {
					pstm.setObject(i+1,list.get(i));
				}
				result = pstm.executeUpdate();
				if(result!=0){
					flag=true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				closeAll(null, pstm, conn);
			}
			return flag;
		}
	
}
