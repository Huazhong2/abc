package com.wanghuazhong.event.service;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.entity.UserImformation;

public interface UserService {
	
	int getIsAdmin();
	
	int getBalance();
	
	void userLogIn(UserImformation userImf);
	
	boolean userCheckAccPass(String account,String password);
	
//	boolean userLogInCheck(String[] content);
	
	boolean isAccountExist(String account);
	
//  boolean checkImformation(AlterPersonImformationBean alterPersonImformationBean);
	
	void alterImformation(AlterPersonImformationBean alterPersonImformationBean);
	
	UserImformation getPersonImformation();
	
	void addBalance(int bill,String account);
}
