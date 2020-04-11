package com.wanghuazhong.event.view.textfield;

import java.awt.Dimension;

import javax.swing.JTextField;

import com.wanghuazhong.event.view.label.PasswordLabel;


public class PasswordTextField extends JTextField {

	public PasswordTextField() {
		super(15);
		// TODO 自动生成的构造函数存根
		
		
		Dimension size = this.getPreferredSize();
		if (this.isVisible()) {

			this.setBounds(PasswordLabel.X0+ PasswordLabel.width+5, PasswordLabel.Y0+5,
					size.width, size.height);
		}
		
		
	}
	
	
	
	
}
