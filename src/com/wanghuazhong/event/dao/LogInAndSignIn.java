package com.wanghuazhong.event.dao;

import com.wanghuazhong.event.entity.UserImformation;

public interface LogInAndSignIn {

	UserImformation userCheckAccPass(String account,String password);
	
	boolean userLogIn(UserImformation userImf);
	
	String isAccountExist(String account);
}
