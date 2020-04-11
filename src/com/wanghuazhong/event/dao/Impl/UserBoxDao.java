package com.wanghuazhong.event.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wanghuazhong.event.dao.UserBox;
import com.wanghuazhong.event.util.DbUtil;

public class UserBoxDao implements UserBox {

	private static DbUtil dbUtil = new DbUtil();
	
	
	@Override
	public int getIsAdmin(String account) {
		// TODO 自动生成的方法存根
		
		Connection con = dbUtil.getCon();
		
		String sql = "select is_admin from user where account = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getInt("is_admin");
			}
	
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				dbUtil.close(pstmt, con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		return 0;
	}

}
