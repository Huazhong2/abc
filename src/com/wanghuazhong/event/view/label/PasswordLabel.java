package com.wanghuazhong.event.view.label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class PasswordLabel extends JLabel {
	
	public static final int X0 = 125;
	public static final int Y0 = 133;
	public static final int width = 45;
	public static final int height = 28;
	
	public PasswordLabel() {
		super();

		// 
		this.setText("密码:");
		this.setFont(new Font("微软雅黑", 0, 20));
		this.setForeground(new Color(0, 200, 0));
		this.setToolTipText("请输入密码");

		if (this.isVisible()) {
			this.setBounds(X0,Y0,width,height);


		}

	}

	public Dimension labelDs() {
		return this.getPreferredSize();
	}
}
