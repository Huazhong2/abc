package com.wanghuazhong.event.controller;

import com.wanghuazhong.event.service.Impl.BalanceService;

public class BalanceController {
	
	private static BalanceService service = new BalanceService();
	
	
	public boolean setRecharge(int rechargeNumber) {
		
		
		return service.setRecharge(rechargeNumber);
		
	}
	
	
	public int getBalance() {
		
		return service.getBalance();
		
	}
}
