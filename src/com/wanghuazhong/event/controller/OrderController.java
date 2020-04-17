package com.wanghuazhong.event.controller;

import java.util.List;

import com.wanghuazhong.event.bean.OrderIdBean;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.service.Impl.OrderServiceImpl;

/** @version:1.0
* @Description:订单模块控制层
* @author:WHZ
* @date:2020年4月17日
*/ 
public class OrderController {
	
	/**
	 * 获取订单模块的实例
	 */
	private static OrderServiceImpl service = new OrderServiceImpl();
	
	
	/**添加订单
	 * @param orderImfoList 从界面的JTable model 获取到的订单信息
	 * @return 是否添加成功的布尔值
	 */
	public boolean addOrder(List<OrderImformation> orderImfoList) {
		
		return service.addOrder(orderImfoList);
		
	}
	
	/**获取订单的信息
	 * @param search 用户输入的查询数据
	 * @return 查询到的订单信息
	 */
	public List<OrderImformation> getOrderImformation(String search){
		
		return service.getOrderImformation(search);
		
	}
	
	/**用户删除订单
	 * @param orderIdBean 订单ID的封装类
	 */
	public void deleteImformation(OrderIdBean orderIdBean) {
		
		int [] idList = orderIdBean.getIdList();
		
		service.deleteImformation(idList);
	}
	
	/**下订单时扣除余额
	 * @param bill 下订单时需扣除的金额
	 * @return 是否扣除成功的布尔值
	 */
	public boolean minusBalance(int bill) {

		return service.minusBalance(bill);
	 }
	 
	
	/**提交充值订单
	 * @param rechargeNumber 充值金额
	 */
	public  void setRecharge(int rechargeNumber) {
		service.setRecharge(rechargeNumber);
	 }


	/**用户对订单设置评论
	 * @param review 用户的评论
	 * @return 是否评论成功的布尔值
	 */
	public boolean setReview(String review) {
		// TODO 自动生成的方法存根
		return false;
	}
	 
	 
	public void setOrderStatus(OrderIdBean orderIdBean,boolean status) {
		
		int [] idList = orderIdBean.getIdList();
		
		service.setOrderStatus(idList,status);
	}
	
	public void dealReturnBalance(OrderIdBean orderIdBean) {
		
		int [] idList = orderIdBean.getIdList();
		service.dealReturnBalance(idList);
	}
}
