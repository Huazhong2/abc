package com.wanghuazhong.event.service.Impl;

import java.util.Objects;
import java.util.Vector;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.dao.Impl.UserDaoImpl;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.service.UserService;

public class UserServiceImpl implements UserService{

	private static UserDaoImpl dao = new UserDaoImpl();
	private static String userAccount;
	
	@Override
	public int getIsAdmin() {
		// TODO 自动生成的方法存根
		int isAdmin = dao.getIsAdmin(getUserAccount());
		return isAdmin;
	}


	@Override
	public int getBalance() {
		// TODO 自动生成的方法存根
		String account=getUserAccount();
		return dao.getBalance(account);
	}

	@Override
	public void userLogIn(UserImformation userImf) {
		// TODO 自动生成的方法存根
		dao.userLogIn(userImf);
	}

	@Override
	public boolean userCheckAccPass(String account, String password) {
		// TODO 自动生成的方法存根
		String accountData  = dao.userCheckAccPass(account, password);
		if(Objects.equals(accountData, account)) {
			setUserAccount(account);
			return true;
		}
			
		else {
			return false;
		}
	}

	@Override
	public boolean isAccountExist(String account) {
		// TODO 自动生成的方法存根
		String accountData = dao.isAccountExist(account);
		if(Objects.equals(accountData, null)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void alterImformation(AlterPersonImformationBean alterPersonImformationBean) {
		// TODO 自动生成的方法存根
		alterPersonImformationBean.setAccount(getUserAccount());
		if(Objects.equals(alterPersonImformationBean.getPassword(),null)) {
			dao.alterImformationWithoutPass(alterPersonImformationBean);
				
		}
		else {
			dao.alterImformationWithPass(alterPersonImformationBean);
		}
	}

	@Override
	public UserImformation getPersonImformation() {
		// TODO 自动生成的方法存根
		String account=getUserAccount();
		UserImformation userImfo = new UserImformation();
		Vector<Object> data = dao.getPersonImformation(account);
		userImfo.setName((String) data.get(0));
		userImfo.setSex((String) data.get(1));
		return userImfo;
	}
	
		@Override
	public void addBalance(int bill,String account) {
		// TODO 自动生成的方法存根
		dao.addBalance(account,bill);
	}

	public static String getUserAccount() {
		return userAccount;
	}


	public static void setUserAccount(String userAccount) {
		UserServiceImpl.userAccount = userAccount;
	}



	
	
}
