package com.wanghuazhong.event.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import com.wanghuazhong.event.dao.Impl.MatchDaoImpl;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.service.MatchService;

public class MatchServiceImpl implements MatchService{

	private static MatchDaoImpl dao = new MatchDaoImpl();
	
	@Override
	public List<MatchImformation> getMatchImformation(String search) {
		// TODO 自动生成的方法存根
		Vector<Object> data = dao.getMatchImformation(search);
		List<MatchImformation> matchImfoList = new ArrayList<MatchImformation>();
		int i =0;
		if(!Objects.equals(data.get(0), null)) {
			while(i<data.size()) {
				MatchImformation matchImfo = new MatchImformation();
				System.out.println(data.size()+"   这是matchdata");
				matchImfo.setId(((Long)data.get(i++)).intValue());
				matchImfo.setName((String) data.get(i++));
				matchImfo.setTeamName1((String) data.get(i++));
				matchImfo.setTeamName2((String) data.get(i++));
				matchImfo.setTime((String) data.get(i++));
				matchImfo.setTicketPrice(((Integer)data.get(i++)).intValue());
				matchImfoList.add(matchImfo);
			}
		}
		return matchImfoList;
	}

	@Override
	public boolean setReview(String review) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void addMatchImformation(MatchImformation matchImfo) {
		// TODO 自动生成的方法存根
		dao.addMatchImformation(matchImfo);
	}

	@Override
	public void deleteFromDataBase(int[] idList) {
		// TODO 自动生成的方法存根
		dao.deleteFromDataBase(idList);
		
	}

}
