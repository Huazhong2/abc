package com.wanghuazhong.event.view.button;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.wanghuazhong.event.controller.LogInAndSignInController;
import com.wanghuazhong.event.entity.UserImformation;
import com.wanghuazhong.event.view.operatewindows.WindowsCompoment;
import com.wanghuazhong.event.view.signwindow.SignInCompoment;

public class SignInButton extends JButton{

	private final static int X0 =(int) (SignInCompoment.frameX*0.4);
	private final static int Y0 =(int) (SignInCompoment.frameY*0.6);
	private final static int width = 74;
	private final static int height = 38;
	
	public SignInButton() {
		super();
		
		this.setText("登录");
		this.setFont(new Font("微软雅黑",0,20));

		if(this.isVisible()) {
			this.setBounds( X0,Y0,width,height);
		}
		
		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//
				String account = SignInCompoment.getAccounttextfield().getText();
				String password = SignInCompoment.getPasswordtextfield().getText();
				userImf.setAccount(account);
				userImf.setPassword(password);
				
				
				if(CheckAccPass(userImf)) {
					showSuccessMessage();
					System.out.println("登录成功");
					
					SignInCompoment.getSignInWindows().setVisible(false);
					
					showOperaWindows();
					
					
				}
				else {
					showWarMessage();
				}
			}
			
		});
		
		
	}

	//展示登录窗口！！
	public void showOperaWindows() {
		
		WindowsCompoment windowsCompoment = new WindowsCompoment();
		
		
	}
	
	
	public void showWarMessage() {
		
		JOptionPane.showMessageDialog(SignInCompoment.getSignInWindows(), "您的账号或者密码有错误");
	}
	
	public void showSuccessMessage() {
		JOptionPane.showMessageDialog(SignInCompoment.getSignInWindows(), "登录成功");
	}
	
	static LogInAndSignInController logInAndSignIn = new LogInAndSignInController();
	static UserImformation userImf = new UserImformation();
	
	public boolean CheckAccPass(UserImformation userImf) {
		
		return logInAndSignIn.checkAccPass(userImf);
		//需要用到数据库
	}
	
	//
	public void SignIn() {
		
			
	}
	
	
}
