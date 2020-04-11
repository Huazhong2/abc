package com.wanghuazhong.event.entity;

public class UserImformation {
	
	private String name;
	private String account;
	private String sex;
	private String password;
	private byte isAdmin=0;
	private byte isVip=0;
	private double yourBalance = 0;
	
	
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
	public byte getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}
	public byte getIsVip() {
		return isVip;
	}
	public void setIsVip(byte isVip) {
		this.isVip = isVip;
	}
	public double getYourBalance() {
		return yourBalance;
	}
	public void setYourBalance(double yourBalance) {
		this.yourBalance = yourBalance;
	}
	
	



}
