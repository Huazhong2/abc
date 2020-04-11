package com.wanghuazhong.event.service.Impl;

import java.util.List;

import com.wanghuazhong.event.dao.Impl.AdminMatchDao;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.service.AdminMatch;

public class AdminMatchService implements AdminMatch{

	private static AdminMatchDao dao =new AdminMatchDao();
	
	@Override
	public List<MatchImformation> getMatchImformation(String search) {
		// TODO 自动生成的方法存根
		return dao.getMatchImformation(search);
	}

	@Override
	public boolean addMatchImformation(MatchImformation matchImfo) {
		// TODO 自动生成的方法存根
		if(dao.addMatchImformation(matchImfo)!=0) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean checkEnter(MatchImformation matchImfo) {
		// TODO 自动生成的方法存根
		if(matchImfo.getId()>100000||matchImfo.getTicketPrice()>100000) {
			return false;
		}
		if(matchImfo.getName().length()>20||matchImfo.getTeamName1().length()>20||
				matchImfo.getTime().length()>20) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean deleteFromDataBase(int[] idList) {
		// TODO 自动生成的方法存根
		if(dao.deleteFromDataBase(idList)!=0) {
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
