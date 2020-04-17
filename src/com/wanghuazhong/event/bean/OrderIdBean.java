package com.wanghuazhong.event.bean;

/** @version:1.0
* @Description:订单ID的封装类
* @author:WHZ
* @date:2020年4月17日
*/ 
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
