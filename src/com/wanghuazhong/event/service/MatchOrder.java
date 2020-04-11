package com.wanghuazhong.event.service;

import java.util.List;

import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.entity.OrderImformation;

public interface MatchOrder {
	
	
	boolean addOrder(List<OrderImformation> orderImfoList);
		

	public List<MatchImformation> getMatchImformation(String search) ;
	
	
	 boolean minusBalance(int bill);

	 int checkBalance();
	
	 
	
}
