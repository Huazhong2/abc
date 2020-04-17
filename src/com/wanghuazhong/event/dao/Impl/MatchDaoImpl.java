package com.wanghuazhong.event.dao.Impl;

import java.sql.SQLException;
import java.util.Vector;

import com.wanghuazhong.event.dao.MatchDao;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.util.DbOperation;

/** @version:1.0
* @Description:对赛事表进行查询删除添加操作
* @author:WHZ
* @date:2020年4月17日
*/ 
public class MatchDaoImpl implements MatchDao{

	@Override
	public Vector<Object> getMatchImformation(String search) {
		// TODO 自动生成的方法存根
		String entireSearch = "%%";
		Vector<Object> data = new Vector<Object>();
		Vector<Object> searchData = null;
		search = "%"+search+"%";
		String sql1 = "select id,name,team1_name,team2_name,time,ticket_price from lol_match "+
				"where team1_name like ? or team2_name like ?";
		String sql2 = "select id,name,team1_name,team2_name,time,ticket_price from lol_match";
		
		
			
		try {
				if(search.equals(entireSearch)) {
					searchData = DbOperation.select(data, sql2);
				}
				else {
						data.add(search);
						data.add(search);
						
						searchData = DbOperation.select(data, sql1);
				}
					
			} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
			}
			
		return searchData;
	}

	@Override
	public void setReview(String review) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addMatchImformation(MatchImformation matchImfo) {
		// TODO 自动生成的方法存根
		String sql  = "insert into lol_match(id, name, team1_name, team2_name, time, ticket_price) "+
				"values(0,?,?,?,?,?)";
		Vector<Object> data = new Vector<Object>();
		data.add(matchImfo.getName());
		data.add(matchImfo.getTeamName1());
		data.add(matchImfo.getTeamName2());
		data.add(matchImfo.getTime());
		data.add(matchImfo.getTicketPrice());
		try {
			DbOperation.insertUpdateDelete(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFromDataBase(int[] idList) {
		// TODO 自动生成的方法存根
		
		String sql = "delete from lol_match where id = ?";
		for(int i=0;i<idList.length;i++) {
			Vector<Object> data = new Vector<Object>();
			data.add(idList[i]);
			try {
				DbOperation.insertUpdateDelete(data, sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	
}
