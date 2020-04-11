package com.wanghuazhong.event.view.signwindow;

import javax.swing.JFrame;


public class Stat {

	private static void createGUI() {
		
			SignInWindows frame=SignInCompoment.getSignInWindows();//
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
			
			frame.setResizable(false);
			frame.setLocation(500,200);
			frame.setSize(500,300);  //
			frame.setVisible(true);//
		    
		
	}
	
		
	public static void main(String[] args) {
		// TODO 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		}
		);

	}
}
