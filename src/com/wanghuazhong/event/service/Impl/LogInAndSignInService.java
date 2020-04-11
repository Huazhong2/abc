package com.wanghuazhong.event.service.Impl;

import java.lang.reflect.Array;
import java.util.Objects;

import com.wanghuazhong.event.dao.Impl.LogInAndSignInDao;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.service.LogInAndSignIn;

public class LogInAndSignInService implements LogInAndSignIn {

	private static LogInAndSignInDao dao = new LogInAndSignInDao();
	
	private static String account;
	
	
	@Override//进行注册
	public boolean userLogIn(UserImformation userImf) {
		return dao.userLogIn(userImf);
		
	}

	
	@Override//检查注册信息是否合格
	public boolean userLogInCheck(String[] content) {
		// TODO 自动生成的方法存根
		
		
		for(int i=0;i<Array.getLength(content);i++) {
		
		if(Objects.equals(content[i], "")||Objects.equals(content[i], "请选择")||content[i].length()>15) {
			System.out.println("错误");return true;
		}
		if(i==2) {
			if(content[i].length()!=10) {
				return true;
			}
			char str[]=content[i].toCharArray();
			for(int j=0;j<str.length;j++) {
				if(!Character.isDigit(str[j])) {
					System.out.println("错误4");
					break;
				}
			}
	
		}
		
	}
	return false;
		
		
	}

	@Override//检测登录信息是否正确
	public boolean userCheckAccPass(String account, String password) {
		// TODO 自动生成的方法存根
		
		UserImformation userImf = dao.userCheckAccPass(account, password);
		if(Objects.equals(userImf.getAccount(), account)) {
			LogInAndSignInService.setAccount(account);
			return true;
		}
			
		else {
				return false;
		}
		
	
		
		
	}
	
	@Override
	public boolean isAccountExist(String account) {
		// TODO 自动生成的方法存根
		String record = dao.isAccountExist(account);
		if(Objects.equals(record, null)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//负责登录成功后账号记录
	public static String getAccount() {
		return account;
	}

	public static void setAccount(String account) {
		LogInAndSignInService.account = account;
	}




	
	
	
}
