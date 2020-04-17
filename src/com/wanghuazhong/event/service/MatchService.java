package com.wanghuazhong.event.service;

import java.util.List;

import com.wanghuazhong.event.entity.MatchImformation;

public interface MatchService {
	
	List<MatchImformation> getMatchImformation(String search);
	
	boolean setReview(String review);
	
	void addMatchImformation(MatchImformation matchImfo);
	
	void deleteFromDataBase(int[] idList);
	
	//boolean checkEnter(MatchImformation matchImfo);
}
