package com.wanghuazhong.event.view.signwindow;

import javax.swing.JFrame;


/** @version:1.0
* @Description:程序开始的位置，加载GUI。
* @author:WHZ
* @date:data2020年4月17日
*/ 

public class Stat {


	/**
	 * 创建开始窗口，并设置窗口的参数
	 */
	private static void createGUI() {
		
			SignInWindows frame=SignInCompoment.getSignInWindows();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setResizable(false);
			frame.setLocation(500,200);
			frame.setSize(500,300);  
			frame.setVisible(true);
		    
		
	}
	

	/**开始运行程序
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createGUI();
			}
		}
		);

	}
}
