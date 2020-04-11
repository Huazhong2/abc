package com.wanghuazhong.event.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wanghuazhong.event.dao.PersonOrder;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.util.DbUtil;

public class PersonOrderDao implements PersonOrder{

	
	private static DbUtil dbUtil  = new DbUtil();
	
	@Override
	public List<OrderImformation> getOrderImformation(String search,String account) {
		// TODO 自动生成的方法存根
		
		search = "%"+search+"%";
		List<OrderImformation> orderImfoList =new ArrayList<OrderImformation>();
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
	
		PreparedStatement pstmt =null;
		String sql = "select order_id, order_type, order_name, user_account, order_type_id, order_time, ticket_price, status "+
						"from match_order where user_account = ? and order_name like ?";	
		
		try {
			if(search.equals("%%")){
				sql = "select order_id, order_type, order_name, user_account, order_type_id, order_time, ticket_price, status "+
						"from match_order where user_account = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			}
			else {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account);
				pstmt.setString(2, search);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
				
			while(rs.next()) {
				
				OrderImformation orderImfo = new OrderImformation();
				orderImfo.setOrderId(rs.getInt("order_id"));
				orderImfo.setOrderName(rs.getString("order_type"));
				orderImfo.setOrderTime(rs.getString("order_time"));
				orderImfo.setOrderType(rs.getString("order_type"));
				orderImfo.setOrderTypeId(rs.getInt("order_type_id"));
				orderImfo.setPrice(rs.getInt("ticket_price"));
				orderImfo.setStatus(rs.getString("status"));
				orderImfo.setUserAccount(rs.getString("user_account"));
				orderImfoList.add(orderImfo);
			}
			
			return orderImfoList;
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			
			try {
				dbUtil.close(pstmt, con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		
		return orderImfoList;
	}

	@Override
	public int deleteImformation(int[] idList) {
		// TODO 自动生成的方法存根
		int result = 0;
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql = "delete from match_order where order_id = ?";
		
		PreparedStatement pstmt=null;
		try {
			
			pstmt = con.prepareStatement(sql);
			for(int i = 0; i <idList.length; i++) {
				pstmt.setInt(1, idList[i]);
				result = pstmt.executeUpdate();
			}
			
			return result;
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			dbUtil.close(pstmt, con);
		}
		
		return result;
		
	}

	//评论功能还没问完成
	@Override
	public int setReview(String review,String account) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	
}
