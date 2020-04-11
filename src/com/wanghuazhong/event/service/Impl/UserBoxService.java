package com.wanghuazhong.event.service.Impl;

import com.wanghuazhong.event.dao.Impl.UserBoxDao;
import com.wanghuazhong.event.service.UserBox;

public class UserBoxService implements UserBox {

	private static UserBoxDao dao = new UserBoxDao();
	
	@Override
	public int getIsAdmin() {
		// TODO 自动生成的方法存根
		int isAdmin = dao.getIsAdmin(LogInAndSignInService.getAccount());
		return isAdmin;
	}

	
}
