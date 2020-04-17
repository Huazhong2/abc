package com.wanghuazhong.event.dao;

import java.util.Vector;

import com.wanghuazhong.event.entity.MatchImformation;

public interface MatchDao {
	
	Vector<Object> getMatchImformation(String search) ;
	
	void setReview(String review);
	
	void addMatchImformation(MatchImformation matchImfo);
	
	//boolean checkEnter(MatchImformation matchImfo);
	
	void deleteFromDataBase(int[] idList);
}
