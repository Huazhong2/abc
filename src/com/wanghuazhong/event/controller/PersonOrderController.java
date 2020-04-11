package com.wanghuazhong.event.controller;

import java.util.List;

import com.wanghuazhong.event.bean.OrderIdBean;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.service.Impl.PersonOrderService;

public class PersonOrderController {
	
	private static PersonOrderService service = new PersonOrderService();
	
	//从数据库获取订单信息
	public List<OrderImformation> getOrderImformation(String search){
		
		return service.getOrderImformation(search);
	
	}
	
	
	//从数据库删除信息
	public boolean deleteImformation(OrderIdBean orderIdBean) {
		
		int [] idList = orderIdBean.getIdList();
		
		return service.deleteImformation(idList);
		
	}
	
	//对已预约且已经被受理的订单发表评论
	public boolean setReview(String review) {
		
		return service.setReview(review);
		
	}
}
