package com.wanghuazhong.event.dao;

import com.wanghuazhong.event.entity.UserImformation;

public interface SearchAndUpdatePersonImformation {
	
	UserImformation searchPersonImformation(String account);
	
	int updatePersonImformation(UserImformation userImformation);
}
