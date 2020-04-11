package com.wanghuazhong.event.service;

import java.util.List;

import com.wanghuazhong.event.bean.OrderIdBean;
import com.wanghuazhong.event.entity.OrderImformation;

public interface PersonOrder {
	
	List<OrderImformation> getOrderImformation(String search);
	
	boolean deleteImformation(int[] idList);
	
	boolean setReview(String review);
}
