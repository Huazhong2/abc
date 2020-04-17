package com.wanghuazhong.event.dao.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.wanghuazhong.event.dao.OrderDao;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.util.DbOperation;

public class OrderDaoImpl implements OrderDao{

	@Override
	public Vector<Object> getOrderImformation(String search,String account) {
		// TODO 自动生成的方法存根
		search = "%"+search+"%";
		String entireSearch = "%%";
		Vector<Object> data = new Vector<Object>();
		Vector<Object> searchData = null;
		String sql1 = "select order_id, order_type, order_name, user_account, order_type_id, order_time, ticket_price, status "+
				"from match_order where user_account = ?";
		String sql2 = "select order_id, order_type, order_name, user_account, order_type_id, order_time, ticket_price, status "+
				"from match_order where user_account = ? and status = ?";
		try {
			if(search.equals(entireSearch)) {
				data.add(account);
				searchData = DbOperation.select(data, sql1);
			}
			else {
					data.add(account);
					data.add(search);
					searchData = DbOperation.select(data, sql2);
			}
				
		} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
		}
		
	return searchData;
	
	}

	@Override
	public void deleteImformation(int[] idList) {
		// TODO 自动生成的方法存根
		String sql = "delete from match_order where order_id = ?";
		for(int i=0;i<idList.length;i++) {
			Vector<Object> data = new Vector<Object>();
			data.add(idList[i]);
			try {
				DbOperation.insertUpdateDelete(data, sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addOrder(List<OrderImformation> orderImfoList) {
		// TODO 自动生成的方法存根
		String sql ="insert into match_order(order_id, order_type, order_name, user_account, order_type_id, "+
				"order_time, ticket_price, status)" + "values(0,?,?,?,?,NOW(),?,?)";
		for(int i=0;i<orderImfoList.size();i++) {
			Vector<Object> data = new Vector<Object>();
			data.add(orderImfoList.get(i).getOrderType());
			data.add(orderImfoList.get(i).getOrderName());
			data.add(orderImfoList.get(i).getUserAccount());
			data.add(orderImfoList.get(i).getOrderTypeId());
			data.add(orderImfoList.get(i).getPrice());
			data.add(orderImfoList.get(i).getStatus());
			try {
				DbOperation.insertUpdateDelete(data, sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
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
	public void setRecharge(int rechargeNumber,String account) {
		// TODO 自动生成的方法存根
		String orderType = "充值服务";
		String orderName = "充值订单";
		//默认值
		int orderTypeId=0;
		String status = "待受理";
		Vector<Object> data = new Vector<Object>();
		String sql = "insert into match_order(order_id, order_type, order_name, user_account, order_type_id, "+
				"order_time, ticket_price, status)" + "values(0,?,?,?,?,NOW(),?,?)";
		data.add(orderType);
		data.add(orderName);
		data.add(account);
		data.add(orderTypeId);
		data.add(rechargeNumber);
		data.add(status);
		try {
			DbOperation.insertUpdateDelete(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void setOrderStatus(int idList[],String status) {
		// TODO 自动生成的方法存根
		String sql = "update match_order set status = ? where order_id = ?";
		for(int i=0;i<idList.length;i++) {
			Vector<Object> data = new Vector<Object>();
			data.add(status);
			data.add(idList[i]);
			try {
				DbOperation.insertUpdateDelete(data, sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public Vector<Object> getOrderPartImfo(int id) {
		// TODO 自动生成的方法存根
		String sql = "select user_account,ticket_price,status,order_type from match_order where order_id = ?";
		Vector<Object> data = new Vector<Object>();
		data.add(id);
		Vector<Object> searchData = null;
		try {
			searchData = DbOperation.select(data, sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return searchData;
	}
	
	
}
