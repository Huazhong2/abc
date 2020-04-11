package com.wanghuazhong.event.controller;

import com.wanghuazhong.event.bean.LogInUserImformationBean;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.service.Impl.LogInAndSignInService;

public class LogInAndSignInController {

	private static LogInAndSignInService logInAndSignInService = new LogInAndSignInService();
	
	//进行注册注册
	public boolean logIn(LogInUserImformationBean logInUserImf) {
		
		UserImformation useImf = new UserImformation();
		useImf.setAccount(logInUserImf.getAccount());
		useImf.setName(logInUserImf.getName());
		useImf.setPassword(logInUserImf.getPassword());
		useImf.setSex(logInUserImf.getSex());
		
		return logInAndSignInService.userLogIn(useImf);
		
		
	}
	
	//检测注册信息是否合格
	public boolean logInCheck(LogInUserImformationBean logInUserImf) {
		
		String [] imformation = new String[4];
		imformation[0]=logInUserImf.getName();
		imformation[1]=logInUserImf.getSex();
		imformation[2]=logInUserImf.getAccount();
		imformation[3]=logInUserImf.getPassword();
		
		return logInAndSignInService.userLogInCheck(imformation);
		
		
	}
	
	//检查登录信息是否正确
	public boolean checkAccPass(UserImformation userImf) {
		
		String account = userImf.getAccount();
		String password = userImf.getPassword();
		
		return logInAndSignInService.userCheckAccPass(account, password);
		
		
		//
	}
	
	public boolean isAccountExist(String account) {
		return logInAndSignInService.isAccountExist(account);
		
	}
	
	
}
