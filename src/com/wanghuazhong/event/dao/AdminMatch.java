package com.wanghuazhong.event.dao;

import java.util.List;


import com.wanghuazhong.event.entity.MatchImformation;

public interface AdminMatch {
	
	List<MatchImformation> getMatchImformation(String search);
	
	int addMatchImformation(MatchImformation matchImfo);
	
	int deleteFromDataBase(int[] idList);
}
