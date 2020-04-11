package com.wanghuazhong.event.service;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.entity.UserImformation;


public interface AlterPersonImformation {
	
	boolean checkImformation(AlterPersonImformationBean alterPersonImformationBean);
	
	boolean alterImformation(AlterPersonImformationBean alterPersonImformationBean);
	
	UserImformation getPersonImformation();
}
