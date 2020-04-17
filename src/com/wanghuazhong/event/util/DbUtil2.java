package com.wanghuazhong.event.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class DbUtil2 {
	
	private static String dbUrl;
	private static String dbUserName;
	private static String dbPassword;
	private static String jdbcName;
	private static LinkedList<Connection> cons = new LinkedList<Connection>();
	
	static {
		//加载properties文件
		InputStream jdbcImformation = DbUtil2.class.getClassLoader().getResourceAsStream("com/wanghuazhong/event/util/db.properties");
		Properties pro = new Properties();
		try {
			pro.load(jdbcImformation);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//根据文件信息给域赋值
		dbUrl = pro.getProperty("dbUrl");
		dbUserName = pro.getProperty("dbUserName");
		dbPassword = pro.getProperty("dbPassword");
		jdbcName = pro.getProperty("jdbcName");
		
		//加载驱动
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		int initialSize = Integer.valueOf(pro.getProperty("initialSize"));
		
		//初始化连接池
		
		for (int i = 0; i < initialSize; i++) {
			try {
				Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
				cons.add(con);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	//获得数据库连接
	public static Connection getCon() {
		
		Connection con=null;
		if(cons.size()>0) {
		con = cons.getFirst();
		cons.removeFirst();
		System.out.println("取走一个连接");
		return con;
		}
		//否则抛出异常
		else throw new RuntimeException("连接数量到达上限");
		
	}
	
	//返还数据库连接
	public static void returnCon(Connection con) {
		cons.addLast(con);
	}
	
	
	//关闭连接
	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	
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
