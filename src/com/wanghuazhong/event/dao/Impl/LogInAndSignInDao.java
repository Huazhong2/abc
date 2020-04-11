package com.wanghuazhong.event.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wanghuazhong.event.dao.LogInAndSignIn;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.util.DbUtil;

public class LogInAndSignInDao implements LogInAndSignIn{

	private static DbUtil dbUtil = new DbUtil();
	
	@Override//检测登录信息是否正确
	public UserImformation userCheckAccPass(String account, String password)  {
		// TODO 自动生成的方法存根
		
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		UserImformation userImf = new UserImformation();
		
		String sql = "select account from user where account=? and password=PASSWORD(?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				userImf.setAccount(rs.getString("account"));
			}
			return userImf;
			
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
		
		return null;
		
	
	}
 
	@Override//注册
	public boolean userLogIn(UserImformation userImf) {
		
		// TODO 自动生成的方法存根
		String name =userImf.getName();
		String account = userImf.getAccount();
		String sex = userImf.getSex();
		String password = userImf.getPassword();
		
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "insert into user(name,sex,account,password) values(?,?,?,PASSWORD(?))";
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,sex );
			pstmt.setString(3,account);
			pstmt.setString(4,password);
			pstmt.executeUpdate();
			System.out.println("ssssss");
			return true;
			}
			
		 catch (SQLException e) {
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
		
		return true;
		
	}

	@Override
	public String isAccountExist(String account) {
		// TODO 自动生成的方法存根
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "select account from user where account=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				return rs.getString("account");
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
		
		return null;
	}


	
}
