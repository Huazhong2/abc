package com.wanghuazhong.event.view.signwindow;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import com.wanghuazhong.event.view.button.LogInButton;
import com.wanghuazhong.event.view.button.SignInButton;
import com.wanghuazhong.event.view.label.AccountLabel;
import com.wanghuazhong.event.view.label.PasswordLabel;
import com.wanghuazhong.event.view.label.SignInWindowLabel;
import com.wanghuazhong.event.view.textfield.AccountTextField;
import com.wanghuazhong.event.view.textfield.PasswordTextField;


public class SignInWindows extends JFrame {

	SignInWindowLabel signInWindowLabel = SignInCompoment.getSigninwindowlabel();
	AccountLabel accountLabel = SignInCompoment.getAccountlabel();
	PasswordLabel passwordLabel = SignInCompoment.getPasswordlabel();
	SignInButton signInButton = SignInCompoment.getSigninbutton();
	AccountTextField accountTextField = SignInCompoment.getAccounttextfield();
	PasswordTextField passwordTextField = SignInCompoment.getPasswordtextfield();
	LogInButton logInButton = SignInCompoment.getLoginbutton();

	public SignInWindows(String title) {
		super(title);
		//
		Container contentPane = getContentPane();//
		LayoutManager layoutMgr = new FreeLayManager();

		contentPane.setLayout(layoutMgr);// 

		//
		contentPane.add(signInWindowLabel);
		contentPane.add(signInButton);
		contentPane.add(accountTextField);
		contentPane.add(accountLabel);
		contentPane.add(passwordTextField);
		contentPane.add(passwordLabel);
		contentPane.add(logInButton);
		//

	}

	
	
	
	
	private class FreeLayManager implements LayoutManager {

		@Override
		public void addLayoutComponent(String name, Component comp) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void layoutContainer(Container parent) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public void removeLayoutComponent(Component comp) {
			// TODO 自动生成的方法存根
			
		}

		}

	

}
		

		
	
	//

