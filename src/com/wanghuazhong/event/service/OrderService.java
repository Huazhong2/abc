package com.wanghuazhong.event.service;

import java.util.List;

import com.wanghuazhong.event.entity.OrderImformation;

public interface OrderService {
	
	boolean addOrder(List<OrderImformation> orderImfoList);
	
	List<OrderImformation> getOrderImformation(String search);
	
	void deleteImformation(int[] idList);
	
	boolean minusBalance(int bill);
	 
	void setRecharge(int rechargeNumber);
	 
	void setOrderStatus(int[] idList,boolean status);

	void dealReturnBalance(int[] idList);
	
}
