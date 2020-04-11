package com.wanghuazhong.event.service.Impl;

import java.util.List;
import java.util.Objects;

import com.wanghuazhong.event.dao.Impl.MatchOrderDao;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.service.MatchOrder;

public class MatchOrderService implements MatchOrder {

	private static MatchOrderDao dao = new MatchOrderDao();
	
	@Override
	public boolean addOrder(List<OrderImformation> orderImfoList) {
		// TODO 自动生成的方法存根
		if(Objects.equals(orderImfoList, null)) {
			return false;
		}
		else {
			return dao.addOrder(orderImfoList);
		}
	}

	@Override
	public List<MatchImformation> getMatchImformation(String search) {
		// TODO 自动生成的方法存根
		return dao.getMatchImformation(search);
	}

	@Override
	public boolean minusBalance(int bill) {
		// TODO 自动生成的方法存根
		int balance = checkBalance();
		if(balance>=bill) {
			dao.minusBalance(bill, LogInAndSignInService.getAccount());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int checkBalance() {
		// TODO 自动生成的方法存根
		return dao.checkBalance(LogInAndSignInService.getAccount());
	}
	
	
}
