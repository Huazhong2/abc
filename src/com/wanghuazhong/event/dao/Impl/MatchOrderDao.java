package com.wanghuazhong.event.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.wanghuazhong.event.dao.MatchOrder;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.util.DbUtil;

public class MatchOrderDao implements MatchOrder {

	private static DbUtil dbUtil = new DbUtil();

	@Override
	public boolean addOrder(List<OrderImformation> orderImfoList) {
		// TODO 自动生成的方法存根
		
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		String sql ="insert into match_order(order_id, order_type, order_name, user_account, order_type_id, "+
					"order_time, ticket_price, status)" + "values(0,?,?,?,?,NOW(),?,?)";
		PreparedStatement pstmt=null;
		try {
			
			for(int i=0;i<orderImfoList.size();i++) {
			pstmt = con.prepareStatement(sql);
			OrderImformation orderImfo =  orderImfoList.get(i);
			pstmt.setString(1,orderImfo.getOrderType());
			pstmt.setString(2,orderImfo.getOrderName());
			pstmt.setString(3,orderImfo.getUserAccount());
			pstmt.setInt(4,orderImfo.getOrderTypeId());
			pstmt.setInt(5,orderImfo.getPrice());
			pstmt.setString(6,orderImfo.getStatus());
			pstmt.executeUpdate();
			}

			System.out.println("插入成功");
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
	public List<MatchImformation> getMatchImformation(String search) {
		// TODO 自动生成的方法存根
	
		search = "%"+search+"%";
		List<MatchImformation> matchImfoList =new ArrayList<MatchImformation>();
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		
		System.out.println("dao    "+search);
		PreparedStatement pstmt =null;
		String sql = "select id,name,team1_name,team2_name,time,ticket_price from lol_match "+
						"where team1_name like ? or team2_name like ?";	
		
		try {
			if(search.equals("%%")){
				sql = "select id,name,team1_name,team2_name,time,ticket_price from lol_match";
			pstmt = con.prepareStatement(sql);
			}
			else {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
				
			while(rs.next()) {
				
				MatchImformation matchImfo = new MatchImformation();
				matchImfo.setId(rs.getInt("id"));
				matchImfo.setName(rs.getString("name"));
				matchImfo.setTeamName1(rs.getString("team1_name"));
				matchImfo.setTeamName2(rs.getString("team2_name"));
				matchImfo.setTicketPrice(rs.getInt("ticket_price"));
				matchImfo.setTime(rs.getString("time"));
				matchImfoList.add(matchImfo);
				
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			
			dbUtil.close(pstmt, con);
			
		}
		
		return matchImfoList;
	}

	@Override
	public int minusBalance(int bill,String account) {
		// TODO 自动生成的方法存根
		int result = 0;
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		String sql = "update user set balance=balance-? where account=?";
		PreparedStatement pstmt =null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bill);
			pstmt.setString(2,account);
		    result = pstmt.executeUpdate();
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

	@Override
	public int checkBalance(String account) {
		// TODO 自动生成的方法存根
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		String sql = "select balance from user where account=?";
		PreparedStatement pstmt =null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("balance");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			dbUtil.close(pstmt, con);
		}
		
		return -1;
	}

}
