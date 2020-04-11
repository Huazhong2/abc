package com.wanghuazhong.event.service;

import java.util.List;

import com.wanghuazhong.event.bean.MatchIdBean;
import com.wanghuazhong.event.entity.MatchImformation;

public interface AdminMatch {
	
	
	
	List<MatchImformation> getMatchImformation(String search);
	
	boolean addMatchImformation(MatchImformation matchImfo);
	
	boolean checkEnter(MatchImformation matchImfo);
	
	boolean deleteFromDataBase(int[] idList);
	
}
