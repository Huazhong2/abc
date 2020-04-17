package com.wanghuazhong.event.dao.Impl;


import java.sql.SQLException;
import java.util.Vector;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.dao.UserDao;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.util.DbOperation;

public class UserDaoImpl implements UserDao{

	@Override
	public int getIsAdmin(String account) {
		// TODO 自动生成的方法存根
		int isAdmin = 0;
		
		String sql = "select is_admin from user where account = ?";
		Vector<Object> data = new Vector<Object>();
		Vector<Object> searchData =null;
		data.add(account);
		
		try {
			searchData =  DbOperation.select(data, sql);
			isAdmin = (int) searchData.get(0);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isAdmin;
	}

	@Override
	public void minusBalance(int bill,String account) {
		// TODO 自动生成的方法存根
		String sql = "update user set balance=balance-? where account=?";
		Vector<Object> data = new Vector<Object>();
		data.add(bill);
		data.add(account);
		try {
			DbOperation.insertUpdateDelete(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	@Override
	public int getBalance(String account) {
		// TODO 自动生成的方法存根
		int balance = 0;
		
		String sql = "select balance from user where account=?";
		Vector<Object> data = new Vector<Object>();
		data.add(account);
		Vector<Object> searchData = null;
		try {
			searchData = DbOperation.select(data, sql);
			balance = (int) searchData.get(0);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return balance;
	}

	
	@Override
	public void userLogIn(UserImformation userImf) {
		// TODO 自动生成的方法存根
	
		Vector<Object> data = new Vector<Object>();
		data.add(userImf.getName());
		data.add(userImf.getSex());
		data.add(userImf.getAccount());
		data.add(userImf.getPassword());
		System.out.println(userImf.getPassword()+"   mima");
		String sql = "insert into user(name,sex,account,password) values(?,?,?,PASSWORD(?))";
		
		try {
			DbOperation.insertUpdateDelete(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public String userCheckAccPass(String account, String password) {
		// TODO 自动生成的方法存根
		
		String accountData = null;
		
		String sql = "select account from user where account=? and password=PASSWORD(?)";
		Vector<Object> data = new Vector<Object>();
		data.add(account);
		data.add(password);
		Vector<Object> searchData = null;
		try {
			searchData = DbOperation.select(data, sql);
			System.out.println(searchData.size()+" check length");
			accountData = (String) searchData.get(0);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return accountData;
	}

	@Override
	public boolean userLogInCheck(String[] content) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public String isAccountExist(String account) {
		// TODO 自动生成的方法存根
		String accountData = null;
		
		String sql = "select account from user where account=?";
		Vector<Object> data = new Vector<Object>();
		Vector<Object> searchData = null;
		data.add(account);
		try {
			searchData = DbOperation.select(data, sql);
			accountData = (String) searchData.get(0);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return accountData;
	}

	@Override
	public void checkImformation(AlterPersonImformationBean alterPersonImformationBean) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void alterImformationWithPass(AlterPersonImformationBean alterPersonImformationBean) {
		// TODO 自动生成的方法存根
		String sql = "update user set name=? ,sex=? ,password=PASSWORD(?) where account=?";
		Vector<Object> data = new Vector<Object>();
		data.add(alterPersonImformationBean.getName());
		data.add(alterPersonImformationBean.getSex());
		data.add(alterPersonImformationBean.getPassword());
		data.add(alterPersonImformationBean.getAccount());
		
		try {
			DbOperation.insertUpdateDelete(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	@Override
	public Vector<Object> getPersonImformation(String account) {
		// TODO 自动生成的方法存根
	
		String sql = "select name,sex from user where account=?";
		Vector<Object> data = new Vector<Object>();
		data.add(account);
		Vector<Object> searchData = null;
		try {
			searchData = DbOperation.select(data, sql);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return searchData;
	}

	@Override
	public void alterImformationWithoutPass(AlterPersonImformationBean alterPersonImformationBean) {
		// TODO 自动生成的方法存根
		
		String sql = "update user set name=?,sex=? where account=?";
		Vector<Object> data = new Vector<Object>();
		data.add(alterPersonImformationBean.getName());
		data.add(alterPersonImformationBean.getSex());
		data.add(alterPersonImformationBean.getAccount());
		try {
			DbOperation.insertUpdateDelete(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void addBalance(String account, int bill) {
		// TODO 自动生成的方法存根
		String sql = "update user set balance = balance+ ? where account = ?";
		Vector<Object> data = new Vector<Object>();
		data.add(bill);
		data.add(account);
		try {
			DbOperation.insertUpdateDelete(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	

	
}
