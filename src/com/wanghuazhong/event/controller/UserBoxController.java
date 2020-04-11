package com.wanghuazhong.event.controller;

import com.wanghuazhong.event.service.Impl.UserBoxService;

public class UserBoxController {
	
	private static UserBoxService service = new UserBoxService();
	
	public int getIsAdmin() {
		
		return service.getIsAdmin();
		
	}
}
