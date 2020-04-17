package com.wanghuazhong.event.bean;


/** @version:1.0
* @Description:程序的修改个人信息功能界面穿给后端和从后端获取的数据
* @author:WHZ
* @date:2020年4月17日
*/ 
public class AlterPersonImformationBean {
	
	
	private String name;
	private String sex;
	private String password;
	private String account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}



	

}
