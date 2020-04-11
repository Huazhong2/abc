package com.wanghuazhong.event.bean;

public class OrderIdBean {

	private int [] idList;
	
	public OrderIdBean(int length) {
		
		super();
		idList = new int[length];
		
	}

	public int[] getIdList() {
		return idList;
	}

	public void setIdList(int[] idList) {
		this.idList = idList;
	}
	
}
