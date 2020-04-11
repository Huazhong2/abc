package com.wanghuazhong.event.service.Impl;

import com.wanghuazhong.event.dao.Impl.BalanceDao;
import com.wanghuazhong.event.service.Balance;

public class BalanceService implements Balance{

	private static BalanceDao dao = new BalanceDao();
	
	@Override
	public boolean setRecharge(int rechargeNumber) {
		// TODO 自动生成的方法存根
		return dao.setRecharge(rechargeNumber, LogInAndSignInService.getAccount());
	}

	@Override
	public int getBalance() {
		// TODO 自动生成的方法存根
		return dao.getBalance(LogInAndSignInService.getAccount());
	}
	
	
}
