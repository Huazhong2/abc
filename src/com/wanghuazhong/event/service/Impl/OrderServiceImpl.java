package com.wanghuazhong.event.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import com.wanghuazhong.event.dao.Impl.OrderDaoImpl;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private static OrderDaoImpl dao = new OrderDaoImpl();
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	@Override
	public boolean addOrder(List<OrderImformation> orderImfoList) {
		// TODO 自动生成的方法存根
		if(Objects.equals(orderImfoList, null)) {
			return false;
		}
		else {
			dao.addOrder(orderImfoList);
			return true;
		}
	}


	@Override
	public boolean minusBalance(int bill) {
		// TODO 自动生成的方法存根
		int balance = userServiceImpl.getBalance();
		System.out.println("余额为   "+balance);
		if(balance>=bill) {
			dao.minusBalance(bill, UserServiceImpl.getUserAccount());
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public List<OrderImformation> getOrderImformation(String search) {
		// TODO 自动生成的方法存根
		String account = UserServiceImpl.getUserAccount();
		Vector<Object> data = dao.getOrderImformation(search, account);
		List<OrderImformation> orderImfoList = new ArrayList<OrderImformation>();
		int i = 0;
		if(!Objects.equals(data.get(0), null)) {
			while(i<data.size()) {
				OrderImformation orderImfo = new OrderImformation();
				orderImfo.setOrderId(((Long)data.get(i++)).intValue());
				orderImfo.setOrderType((String) data.get(i++));
				orderImfo.setOrderName((String) data.get(i++));
				orderImfo.setUserAccount((String) data.get(i++));
				orderImfo.setOrderTypeId(((Integer)data.get(i++)).intValue());
				orderImfo.setOrderTime((String) data.get(i++));
				orderImfo.setPrice(((Integer)data.get(i++)).intValue());
				orderImfo.setStatus((String) data.get(i++));
				orderImfoList.add(orderImfo);
			}
		}	
		return orderImfoList;
	}


	@Override
	public void deleteImformation(int[] idList) {
		// TODO 自动生成的方法存根
		dao.deleteImformation(idList);
	}


	@Override
	public void setRecharge(int rechargeNumber) {
		// TODO 自动生成的方法存根
		String account = UserServiceImpl.getUserAccount();
		dao.setRecharge(rechargeNumber, account);
	}


	@Override
	public void setOrderStatus(int []idList,boolean status) {
		// TODO 自动生成的方法存根
		if(status==false) {
			dao.setOrderStatus(idList, "驳回");
		}
		
		else {
			dao.setOrderStatus(idList, "受理");
		}
		
	}


	@Override
	public void dealReturnBalance(int[] idList) {
		// TODO 自动生成的方法存根
		for(int i=0;i<idList.length;i++) {
			int id = idList[i];
			Vector<Object> data = dao.getOrderPartImfo(id);
			String account = (String)data.get(0);
			int price = (Integer)data.get(1);
			String orderStatus = (String)data.get(2);
			String orderType = (String)data.get(3);
			if(Objects.equals(orderType,"赛事")){
				if(Objects.equals(orderStatus, "驳回")) {
					userServiceImpl.addBalance(price, account);
				}
			}
			if(Objects.equals(orderType,"充值服务")) {
				if(Objects.equals(orderStatus,"受理")) {
					userServiceImpl.addBalance(price,account);
				}
			}
		}
		
		
	}



	
}
