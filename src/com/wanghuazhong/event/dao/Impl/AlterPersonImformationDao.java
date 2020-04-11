package com.wanghuazhong.event.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.dao.AlterPersonImformation;
import com.wanghuazhong.event.dao.SearchAndUpdatePersonImformation;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.util.DbUtil;

public class AlterPersonImformationDao implements AlterPersonImformation,SearchAndUpdatePersonImformation{

	private static DbUtil dbUtil = new DbUtil();
	
	
	@Override//插入个人信息的数据
	public int alterImformation1(AlterPersonImformationBean alterPersonImformationBean) {
		// TODO 自动生成的方法存根
		String name =alterPersonImformationBean.getName();
		String sex = alterPersonImformationBean.getSex();
		String password = alterPersonImformationBean.getPassword();
		String account = alterPersonImformationBean.getAccount();
		Connection con=null;
		int result=0;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "update user set name=? ,sex=? ,password=PASSWORD(?) where account=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,sex );
			pstmt.setString(3,password);
			pstmt.setString(4,account);
			result = pstmt.executeUpdate();
			System.out.println("ssssss");
			return result;
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
		
		return result;
		
	}

	@Override//获取个人信息部分的数据
	public UserImformation searchPersonImformation(String account) {
		// TODO 自动生成的方法存根
		Connection con=null;
		UserImformation userImformation=new UserImformation();
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "select name,sex from user where account=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,account);
			ResultSet rs =pstmt.executeQuery();
			
			while(rs.next()) {
				
				userImformation.setName(rs.getString("name"));
				userImformation.setSex(rs.getString("sex"));
			}
			
			return userImformation;
			
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
		
		return null;
	}

	
	

	@Override
	public int alterImformation2(AlterPersonImformationBean alterPersonImformationBean) {
		// TODO 自动生成的方法存根
		String name =alterPersonImformationBean.getName();
		String sex = alterPersonImformationBean.getSex();
		String account = alterPersonImformationBean.getAccount();
		Connection con=null;
		int result=0;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "update user set name=?,sex=? where account=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,sex );
			pstmt.setString(3,account);
			result = pstmt.executeUpdate();
			System.out.println("ssssss");
			return result;
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
		
		return result;
		
	}

	@Override
	public int updatePersonImformation(UserImformation userImformation) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	
}
