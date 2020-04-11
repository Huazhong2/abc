package com.wanghuazhong.event.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wanghuazhong.event.dao.Banlance;
import com.wanghuazhong.event.util.DbUtil;

public class BalanceDao implements Banlance {

	
	private static DbUtil dbUtil = new DbUtil();
	
	@Override
	public boolean setRecharge(int rechargeNumber, String account) {
		// TODO 自动生成的方法存根
		String orderType = "充值服务";
		String orderName = "充值订单";
		int orderTypeId=0;//废弃不用
		String status = "待受理";
		
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "insert into match_order(order_id, order_type, order_name, user_account, order_type_id, "+
				"order_time, ticket_price, status)" + "values(0,?,?,?,?,NOW(),?,?)";
		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,orderType);
			pstmt.setString(2,orderName);
			pstmt.setString(3,account);
			pstmt.setInt(4,orderTypeId);
			pstmt.setInt(5,rechargeNumber);
			pstmt.setString(6,status);
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
		
		
		return false;
	}

	@Override
	public int getBalance(String account) {
		// TODO 自动生成的方法存根
		
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "select balance from user where account = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getInt("balance");
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
		
		return -1;
	}

}
