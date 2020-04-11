package com.wanghuazhong.event.dao;

public interface Banlance {
	
	boolean setRecharge(int rechargeNumber,String account);
	
	int getBalance(String account);
}
