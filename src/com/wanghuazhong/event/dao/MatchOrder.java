package com.wanghuazhong.event.dao;

import java.util.List;

import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.entity.OrderImformation;

public interface MatchOrder {
	
	boolean addOrder(List<OrderImformation> orderImfoList);
	
	List<MatchImformation> getMatchImformation(String search);
	
	int minusBalance(int bill,String account);
	
	int checkBalance(String account);
}
