package com.wanghuazhong.event.view.label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class SignInWindowLabel extends JLabel {
		

	
	public SignInWindowLabel() {
		super();
		
		//
		this.setText("Welcome");
		this.setFont(new Font("微软雅黑",0,50));
		this.setForeground(new Color(0,255,0));
		this.setToolTipText("欢迎使用该系统");
		
		
		if(this.isVisible()) {
		Dimension size=this.getPreferredSize();
		this.setBounds(0, 0, size.width, size.height);
			}
		
		
	}
	
	public Dimension labelDs() {
		return this.getPreferredSize();
	}
	
	
}
