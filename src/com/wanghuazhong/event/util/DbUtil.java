package com.wanghuazhong.event.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {
	
	//
	public static String dbUrl = "jdbc:mysql://localhost:3306/library";
	
	//
	private static String dbUserName = "root";
	
	//
	private static String dbPassword = "123456";
	
	//
	public static String jdbcName = "com.mysql.jdbc.Driver";
	
	
	//
	public Connection getCon() {
		
		//
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Connection con=null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return con;
	}
	
	//
	public void close(PreparedStatement pstmt,Connection con) {
		
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	
}
