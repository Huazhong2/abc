package com.wanghuazhong.event.service;

import com.wanghuazhong.event.entity.UserImformation;

public interface LogInAndSignIn {

	boolean userLogInCheck(String[] content);
	
	boolean userLogIn(UserImformation userImf);
	
	boolean userCheckAccPass(String account,String password);

	boolean isAccountExist(String account);
}
