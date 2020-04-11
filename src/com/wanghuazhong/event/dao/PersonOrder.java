package com.wanghuazhong.event.dao;

import java.util.List;

import com.wanghuazhong.event.entity.OrderImformation;

public interface PersonOrder {

	List<OrderImformation> getOrderImformation(String search,String account);
	
	int deleteImformation(int[] idList);
	
	int setReview(String review,String account);
}
