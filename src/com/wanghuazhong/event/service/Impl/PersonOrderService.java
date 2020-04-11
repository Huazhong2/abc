package com.wanghuazhong.event.service.Impl;

import java.util.List;


import com.wanghuazhong.event.dao.Impl.PersonOrderDao;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.service.PersonOrder;

public class PersonOrderService implements PersonOrder{

	private static PersonOrderDao dao = new PersonOrderDao();
	
	@Override
	public List<OrderImformation> getOrderImformation(String search) {
		// TODO 自动生成的方法存根
		return dao.getOrderImformation(search,LogInAndSignInService.getAccount());
	}

	@Override
	public boolean deleteImformation(int[] idList) {
		// TODO 自动生成的方法存根
		
		if(dao.deleteImformation(idList)!=0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	
	//等待完成
	@Override
	public boolean setReview(String review) {
		// TODO 自动生成的方法存根
		if(review.trim().length()==0) {
			return false;
		}
		
		if(dao.setReview(review,LogInAndSignInService.getAccount())!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
