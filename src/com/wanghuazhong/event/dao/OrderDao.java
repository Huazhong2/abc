package com.wanghuazhong.event.dao;

import java.util.List;
import java.util.Vector;

import com.wanghuazhong.event.entity.OrderImformation;

public interface OrderDao {
	
	Vector<Object> getOrderImformation(String search,String account);
	
	void deleteImformation(int[] idList);
	
	void addOrder(List<OrderImformation> orderImfoList);
	
	void minusBalance(int bill,String account);
	
	void setRecharge(int rechargeNumber,String account);
	
	void setOrderStatus(int[] idList,String status);
	
	Vector<Object> getOrderPartImfo(int id);
	
	
}
