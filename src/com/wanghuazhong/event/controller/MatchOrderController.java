package com.wanghuazhong.event.controller;

import java.util.List;

import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.service.Impl.MatchOrderService;

public class MatchOrderController {

	private static MatchOrderService service = new MatchOrderService();
	
	public boolean addOrder(List<OrderImformation> orderImfoList) {
		
		return service.addOrder(orderImfoList);
		
	}
	
	public List<MatchImformation> getMatchImformation(String search) {
		
		return service.getMatchImformation(search);
		
	}
	//用到数据库
	public boolean minusBalance(int bill) {
		
		return service.minusBalance(bill);
	}
	//用到数据库

}
