package com.wanghuazhong.event.view.operatewindows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.wanghuazhong.event.view.button.BalanceButton;
import com.wanghuazhong.event.view.button.PersonImformation;
import com.wanghuazhong.event.view.button.table.AdminMatchButton;
import com.wanghuazhong.event.view.button.table.AdminOrderButton;
import com.wanghuazhong.event.view.button.table.MatchOrderButton;
import com.wanghuazhong.event.view.button.table.PersonOrderButton;
import com.wanghuazhong.event.view.swinglayout.ColumnLayout;
import com.wanghuazhong.event.view.swinglayout.RowLayout;
import com.wanghuazhong.event.view.userbox.UserBox;

public class WindowsCompoment {
	
	public static JFrame operaPane = new JFrame("图书馆座位系统");
	public static JPanel root = new JPanel();
	public static JPanel blank = new JPanel();
	public static JPanel cards = new JPanel();
	public static JPanel commonUserArea = new JPanel();
	public static JPanel adminArea = new JPanel();
	public static JPanel cLeft = new JPanel();
	public static JPanel cRight = new JPanel();
	public static JPanel aLeft = new JPanel();
	public static JPanel aRight = new JPanel();
	public static UserBox userBox = new UserBox();
	public static MatchOrderButton matchOrder = new MatchOrderButton();
	public static PersonImformation personImformation = new PersonImformation();
	public static AdminMatchButton adminMatchButton = new AdminMatchButton();
	public static PersonOrderButton personOrderButto = new PersonOrderButton();
	public static BalanceButton balanceButton = new BalanceButton();
	public static AdminOrderButton adminOrderButton = new AdminOrderButton();
	
//	public static final 
	
	public WindowsCompoment(){
		
		//根容器界面构造
		operaPane.setContentPane(root);
		//放入下拉框，设置布局
		root.setLayout(new BorderLayout());
		root.add(userBox,BorderLayout.PAGE_START);
		root.add(cards,BorderLayout.CENTER);
		
		//设置，blank欢迎界面，放入组件
		
		//
		
		//cards使用卡片布局
		cards.setLayout(new CardLayout());
		cards.add(blank,"blank");
		cards.add(commonUserArea,"commonUserArea");
		cards.add(adminArea,"adminArea");
		
		//对第一个卡片commonUserArea和第二个卡片第二个卡片adminArea进行设置
		commonUserArea.setLayout(new RowLayout(30));
		commonUserArea.add(cLeft,"35%");
		commonUserArea.add(cRight,"35%");
		adminArea.setLayout(new RowLayout(30));
		adminArea.add(aLeft,"35%");
		adminArea.add(aRight,"35%");
		
		//对第一个卡片的两侧和第二个卡片的两侧进行设置
		cLeft.setLayout(new ColumnLayout(20));
		cRight.setLayout(new ColumnLayout(20));
		aLeft.setLayout(new ColumnLayout(20));
		aRight.setLayout(new ColumnLayout(20));
		
		//对第一张卡片的两侧，也就是普通用户的功能区添加组件
		
		cLeft.add(matchOrder);
		cRight.add(personImformation);
		cLeft.add(personOrderButto);
		cRight.add(balanceButton);
		
		
		///////////////////////////////////
		
		//对第二张卡片的两侧，也就是管理员的功能区添加组件
		
		aLeft.add(adminMatchButton);
		aRight.add(adminOrderButton);
		
		
		
		
		////////////////////////////////////
		
		//
		operaPane.setResizable(true);
		operaPane.setSize(500,310);
		operaPane.setLocation(600, 300);
		operaPane.setVisible(true); // 这和JFrame.setVisible()
		operaPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口关闭时的操作
		operaPane.addWindowListener(new WindowAdapter(){
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
            

		});
		
		
		
		
	}
	
	
}
