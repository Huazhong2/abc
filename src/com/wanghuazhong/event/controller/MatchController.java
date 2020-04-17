package com.wanghuazhong.event.controller;

import java.util.List;

import com.wanghuazhong.event.bean.MatchIdBean;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.service.Impl.MatchServiceImpl;

/** @version:1.0
* @Description:赛事模块控制层
* @author:WHZ
* @date:2020年4月17日
*/ 
public class MatchController {
	
	/**
	 * 获得服务模块的实例
	 */
	private static MatchServiceImpl service = new MatchServiceImpl();
	
	
	/**获取赛事
	 * @param search 程序搜索赛事时输入的信息
	 * @return 返回从后端查询到的赛事信息集合
	 */
	public List<MatchImformation> getMatchImformation(String search){
		
		return service.getMatchImformation(search);
		
	}
	
	/**设置用户评论
	 * @param review 用户的评论
	 * @return 返回评论是否成功的值
	 */
	public boolean setReview(String review) {
		
		return service.setReview(review);
		
	}
	
	/**添加赛事
	 * @param matchImfo 管理员添加赛事时从界面获取到的数据
	 */
	public void addMatchImformation(MatchImformation matchImfo) {
		 
		service.addMatchImformation(matchImfo);
	}
	
	/**从数据库删除赛事
	 * @param matchIdBean 管理员从赛事管理界面的JTabel model获取到的赛事id集
	 */
	public void deleteFromDataBase(MatchIdBean matchIdBean) {
		
		int[] idList = matchIdBean.getId();
		
		 service.deleteFromDataBase(idList);
	}
	
	
}
