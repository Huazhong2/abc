package com.wanghuazhong.event.bean;


/** @version:1.0
* @Description:程序注册界面传给后端的数据
* @author:WHZ
* @date:2020年4月17日
*/ 
public class LogInUserImformationBean {
	
	private String name;
	private String account;
	private String sex;
	private String password;
	private byte is_admin=0;
	private byte is_vip=0;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public byte getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(byte is_admin) {
		this.is_admin = is_admin;
	}
	public byte getIs_vip() {
		return is_vip;
	}
	public void setIs_vip(byte is_vip) {
		this.is_vip = is_vip;
	}
	
	


}
