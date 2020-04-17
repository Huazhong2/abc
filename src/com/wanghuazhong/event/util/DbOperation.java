package com.wanghuazhong.event.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DbOperation {
	
	
	public static void main(String[] args) {
		
	}
	
	public static void insertUpdateDelete(Vector<Object> data,String sql) throws SQLException {
		
		Connection con  = DbUtil2.getCon();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for(int i=0;i<data.size();i++) {
			if(data.get(i) instanceof String ) {
				pstmt.setString(i+1, (String) data.get(i));
			}
			if(data.get(i) instanceof Integer) {
				pstmt.setInt(i+1, ((Integer)data.get(i)));
			}
		}
		pstmt.executeUpdate();
		pstmt.close();
		DbUtil2.returnCon(con);
		
		
	}
	
	//
	public static Vector<Object> select(Vector<Object> data,String sql) throws SQLException {
		
		Connection con  = DbUtil2.getCon();
		PreparedStatement pstmt = con.prepareStatement(sql);
		Vector<Object> searchData = new Vector<Object>();
		System.out.println("数据长度为   "+data.size());
		for(int i=0;i<data.size();i++) {
			if(data.get(i) instanceof String ) {
				pstmt.setString(i+1, (String) data.get(i));
			}
			if(data.get(i) instanceof Integer) {
				pstmt.setInt(i+1, (Integer)data.get(i));
			}
			if(data.get(i) instanceof Long) {
				pstmt.setInt(i+1, ((Long)data.get(i)).intValue());
			}
			
		}
		
		ResultSet rs = pstmt.executeQuery();
		int column = rs.getMetaData().getColumnCount();
		while(rs.next()) {
			for(int i=1;i<=column;i++) {
//				String type = rs.getMetaData().getColumnTypeName(i);
//				String columnName = rs.getMetaData().getColumnName(i);
//				System.out.println("columnName = "+type+"   columnName = "+columnName);
//				if(type.equals("varchar")||type.equals("text")||type.equals("char")) {
//					searchData.add(rs.getString(columnName));
//				}
//				if(type.equals("tinyint")||type.equals("int")) {
//					searchData.add(rs.getInt(columnName));
//				}
				searchData.add(rs.getObject(i));
			}
		}
		
		if(searchData.size()==0) {
			searchData.add(null);
			System.out.println(searchData.size()+" check Dboperationlength");
		}
		
		rs.close();
		pstmt.close();
		DbUtil2.returnCon(con);
		
		return searchData;
		
	}
	
	
}
