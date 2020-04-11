package com.wanghuazhong.event.service.Impl;

import java.lang.reflect.Array;
import java.util.Objects;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.dao.Impl.AlterPersonImformationDao;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.service.AlterPersonImformation;

public class AlterPersonImformationService implements AlterPersonImformation {

	private static AlterPersonImformationDao dao = new AlterPersonImformationDao();
	
	@Override
	public boolean checkImformation(AlterPersonImformationBean alterPersonImformationBean) {
		// TODO 自动生成的方法存根
		String [] content = new String[3];
		content[0]=alterPersonImformationBean.getName();
		content[1]=alterPersonImformationBean.getPassword();
		content[2]=alterPersonImformationBean.getSex();
	
		for(int i=0;i<Array.getLength(content);i++) {
			System.out.println("错误22");
			if(Objects.equals(content[i], null))
				continue;
			if(Objects.equals(content[i], "")||Objects.equals(content[i], "请选择")||content[i].length()>15) {
				return true;
			}
	}
		return false;
	}
	
	@Override
	public boolean alterImformation(AlterPersonImformationBean alterPersonImformationBean) {
		
		// TODO 自动生成的方法存根
		alterPersonImformationBean.setAccount(LogInAndSignInService.getAccount());
		if(Objects.equals(alterPersonImformationBean.getPassword(),null)) {
			if(dao.alterImformation2(alterPersonImformationBean)!=0) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(dao.alterImformation1(alterPersonImformationBean)!=0) {
				return true;
			}
			else {
				return false;
			}
		}
	}


	@Override
	public UserImformation getPersonImformation() {
		// TODO 自动生成的方法存根
		
		return  dao.searchPersonImformation(LogInAndSignInService.getAccount());
		
		
	}

	
	
}
