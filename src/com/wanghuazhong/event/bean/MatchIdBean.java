package com.wanghuazhong.event.bean;



/** @version:1.0
* @Description:赛事ID数据的封装类
* @author:WHZ
* @date:2020年4月17日
*/ 
public class MatchIdBean {

	private int[] id ;
	
	public MatchIdBean(int length){
		
		id = new int[length];
	}

	public int[] getId() {
		return id;
	}


	
}
