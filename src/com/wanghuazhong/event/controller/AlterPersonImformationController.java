package com.wanghuazhong.event.controller;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.service.Impl.AlterPersonImformationService;

public class AlterPersonImformationController {

	private static AlterPersonImformationService service = new AlterPersonImformationService();
	
	public boolean checkImformation(AlterPersonImformationBean alterPersonImformationBean) {
		
		return service.checkImformation(alterPersonImformationBean);
		
	}
	
	
	public boolean alterImformation(AlterPersonImformationBean alterPersonImformationBean) {
		
		return service.alterImformation(alterPersonImformationBean);
		
	}
	
	public AlterPersonImformationBean getPersonImformation() {
		
		UserImformation userImformation = service.getPersonImformation();
	
		AlterPersonImformationBean alterPersonImformationBean = new AlterPersonImformationBean();
		alterPersonImformationBean.setName(userImformation.getName());
		alterPersonImformationBean.setSex(userImformation.getSex());
		
		return alterPersonImformationBean;
	}
	
}
