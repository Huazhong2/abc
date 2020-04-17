package com.wanghuazhong.event.controller;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.bean.LogInUserImformationBean;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.service.Impl.UserServiceImpl;

/** @version:1.0
* @Description:用户模块控制层
* @author:WHZ
* @date:2020年4月17日
*/ 
public class UserController {
	
	/**
	 * 获得服务层用户模块的数据
	 */
	private static UserServiceImpl service = new UserServiceImpl();
	
	/**获取鉴别用户是否为管理的信息
	 * @return 鉴别用户是否为管理员的值
	 */
	public int getIsAdmin() {
		return service.getIsAdmin();
	}
	
	/**获取余额的信息
	 * @return 用户的余额
	 */
	public int getBalance() {
		
		return service.getBalance();
		
	}
	
	/**封装用户的注册信息
	 * @param logInUserImf 从注册界面获取的用户注册信息
	 */
	public void userLogIn(LogInUserImformationBean logInUserImf) {
		
		UserImformation useImf = new UserImformation();
		useImf.setAccount(logInUserImf.getAccount());
		useImf.setName(logInUserImf.getName());
		useImf.setPassword(logInUserImf.getPassword());
		useImf.setSex(logInUserImf.getSex());
		
		 service.userLogIn(useImf);
	}
	
	/**检查用户的账号密码是否存在
	 * @param userImf 从登录界面获取的用户信息封装类
	 * @return
	 */
	public boolean userCheckAccPass(UserImformation userImf) {
		String account = userImf.getAccount();
		String password = userImf.getPassword();
		
		return service.userCheckAccPass(account, password);
		
	}

	
	/**获得注册时用户是否存在的信息
	 * @param account 注册时用户提交的账号
	 * @return 判断提交的账号是否已经存在的布尔值
	 */
	public boolean isAccountExist(String account) {
		return service.isAccountExist(account);
		
	}
	
	
	/**在用户信息界面修改个人信息
	 * @param alterPersonImformationBean 修改用户信息界面获取的用户提交的信息封装类
	 */
	public void alterImformation(AlterPersonImformationBean alterPersonImformationBean) {
		
		 service.alterImformation(alterPersonImformationBean);
		
	}
	
	/**从后台获取的可供修改的个人信息
	 * @return 可供修改的个人信息部分
	 */
	public AlterPersonImformationBean getPersonImformation() {
		
		UserImformation userImformation = service.getPersonImformation();
	
		AlterPersonImformationBean alterPersonImformationBean = new AlterPersonImformationBean();
		alterPersonImformationBean.setName(userImformation.getName());
		alterPersonImformationBean.setSex(userImformation.getSex());
		
		return alterPersonImformationBean;
	}
}
