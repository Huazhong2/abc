package com.wanghuazhong.event.view.signwindow;

import com.wanghuazhong.event.view.button.LogInButton;
import com.wanghuazhong.event.view.button.SignInButton;
import com.wanghuazhong.event.view.label.AccountLabel;
import com.wanghuazhong.event.view.label.PasswordLabel;
import com.wanghuazhong.event.view.label.SignInWindowLabel;
import com.wanghuazhong.event.view.textfield.AccountTextField;
import com.wanghuazhong.event.view.textfield.PasswordTextField;


public class SignInCompoment {

	private static final SignInWindowLabel signInWindowLabel= new SignInWindowLabel();
			
	private static final AccountLabel accountLabel = new AccountLabel();
	
	private static final PasswordLabel passwordLabel = new PasswordLabel();
	
	private static final SignInButton signInButton = new SignInButton();
	
	private static final AccountTextField accountTextField= new AccountTextField();
	
	private static final PasswordTextField passwordTextField= new PasswordTextField();
	
	private static final LogInButton logInButton = new LogInButton();

	private static final SignInWindows signInWindows = new SignInWindows("英雄联盟赛事订票系统");
	
	//窗口组件位置
	public static final int frameX=500;
	public static final int frameY=300;
	

	public static SignInWindows getSignInWindows() {
		return signInWindows;
	}


	public static SignInWindowLabel getSigninwindowlabel() {
		return signInWindowLabel;
	}


	public static AccountLabel getAccountlabel() {
		return accountLabel;
	}


	public static PasswordLabel getPasswordlabel() {
		return passwordLabel;
	}


	public static SignInButton getSigninbutton() {
		return signInButton;
	}


	public static AccountTextField getAccounttextfield() {
		return accountTextField;
	}


	public static PasswordTextField getPasswordtextfield() {
		return passwordTextField;
	}


	public static LogInButton getLoginbutton() {
		return logInButton;
	}


	public static int getFramex() {
		return frameX;
	}


	public static int getFramey() {
		return frameY;
	}
	
	
	
	
	
}
