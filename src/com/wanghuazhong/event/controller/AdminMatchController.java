package com.wanghuazhong.event.controller;

import java.util.List;

import com.wanghuazhong.event.bean.MatchIdBean;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.service.Impl.AdminMatchService;

public class AdminMatchController {

	
	private static AdminMatchService service = new AdminMatchService();
	
	
	public List<MatchImformation> getMatchImformation(String search){
		
		return service.getMatchImformation(search);
	}
	
	public boolean addMatchImformation(MatchImformation matchImfo) {

		return service.addMatchImformation(matchImfo);
	}
	
	public boolean checkEnter(MatchImformation matchImfo) {
		
		return service.checkEnter(matchImfo);
	}
	
	public boolean deleteFromDataBase(MatchIdBean matchIdBean) {
		
		int[] idList = matchIdBean.getId();
		
		return service.deleteFromDataBase(idList);
	}

}
