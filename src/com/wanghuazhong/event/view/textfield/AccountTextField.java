package com.wanghuazhong.event.view.textfield;

import java.awt.Dimension;

import javax.swing.JTextField;

import com.wanghuazhong.event.view.label.AccountLabel;


public class AccountTextField extends JTextField {
	
	

	public AccountTextField () {
		super(15);
		
		Dimension size = this.getPreferredSize();
		
		if (this.isVisible()) {
			this.setBounds(AccountLabel.X0 + AccountLabel.width+5, AccountLabel.Y0+5, size.width,
					size.height);
		}
		
		
	}

	

	
	
	
}
