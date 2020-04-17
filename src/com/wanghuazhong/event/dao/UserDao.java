package com.wanghuazhong.event.dao;

import java.util.Vector;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.entity.UserImformation;

public interface UserDao {
	
	
	int getIsAdmin(String account);
		
	void minusBalance(int bill,String account);
	
	int getBalance(String account);
	
	void addBalance(String account,int bill);
	 
	void userLogIn(UserImformation userImf);
	//用户登录	
	String userCheckAccPass(String account,String password);
	
	boolean userLogInCheck(String[] content);
	
	//检查注册时用户账号是否已经存在	
	String isAccountExist(String account);
	
	void checkImformation(AlterPersonImformationBean alterPersonImformationBean);
	
	void alterImformationWithPass(AlterPersonImformationBean alterPersonImformationBean);
	
	void alterImformationWithoutPass(AlterPersonImformationBean alterPersonImformationBean);
	
	Vector<Object> getPersonImformation(String account);

}