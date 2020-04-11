package com.wanghuazhong.event.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.wanghuazhong.event.dao.AdminMatch;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.util.DbUtil;

public class AdminMatchDao implements AdminMatch{

	private static DbUtil dbUtil = new DbUtil();
	
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
	public int addMatchImformation(MatchImformation matchImfo) {
		// TODO 自动生成的方法存根
		int result = 0;
		Connection con=null;
		try {
			con = dbUtil.getCon();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		String sql  = "insert into lol_match(id, name, team1_name, team2_name, time, ticket_price) "+
						"values(0,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,matchImfo.getName());
			pstmt.setString(2, matchImfo.getTeamName1());
			pstmt.setString(3, matchImfo.getTeamName2());
			pstmt.setString(4, matchImfo.getTime());
			pstmt.setInt(5, matchImfo.getTicketPrice());
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
	public int deleteFromDataBase(int[] idList) {
		// TODO 自动生成的方法存根
		int result  = 0;
		Connection con = dbUtil.getCon();
		String sql = "delete from lol_match where id = ?";
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
	
	
}
