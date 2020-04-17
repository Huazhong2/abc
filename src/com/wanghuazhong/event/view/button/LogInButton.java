package com.wanghuazhong.event.view.button;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wanghuazhong.event.bean.LogInUserImformationBean;
import com.wanghuazhong.event.controller.UserController;
import com.wanghuazhong.event.view.signwindow.SignInCompoment;


public class LogInButton extends JButton {

	public final static int X0 = 0;
	public final static int Y0 = SignInCompoment.frameY-63;
	public final static int width = 74;
	public final static int height = 38;
	private String [] field = new String[4];
	private static LogInUserImformationBean logInUserImf = new LogInUserImformationBean();
	
	public LogInButton() {
		super();
		
		this.setText("注册");
		this.setFont(new Font("微软雅黑",0,20));
		
		
		
		if(this.isVisible()) {
			this.setBounds(X0,Y0, width,height);
		}
		
		
	this.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 

			deal();
			
		}
		
	});
		
	}
	
	public void deal() {
		
		
		JDialog dialog = new JDialog(SignInCompoment.getSignInWindows(), "用户注册",  true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		dialog.setContentPane(panel);
		
		JLabel labelName = new JLabel("姓名:");
		JLabel labelSex= new JLabel("性别");
		JLabel labelAccount= new JLabel("账号:");
		JLabel blankLabel = new JLabel("           ");
		JLabel labelPassword= new JLabel("密码:");
		JLabel labelEnterRule1=new JLabel("提示:输入账号应为10位数字");
		JLabel labelEnterRule2=new JLabel("       其它输入应不超过15位        ");
		
		JTextField fieldName = new JTextField(15);
		JTextField fieldAccount  = new JTextField(15);
		JTextField fieldPassword =new JTextField(15);
		
		JComboBox<String> boxSex = new JComboBox<>();
		boxSex.addItem("请选择");
		boxSex.addItem("男");
		boxSex.addItem("女");
		
		JButton button = new JButton("确定");	
			
		boxSex.addActionListener(e->{
			
			field[1]=(String)boxSex.getSelectedItem();
			});
		
		button.addActionListener(e->{
			

			field[0]=fieldName.getText();
			field[2]=fieldAccount.getText();
			field[3]=fieldPassword.getText();
			
			logInUserImf.setName(field[0]);
			logInUserImf.setSex(field[1]);
			logInUserImf.setAccount(field[2]);
			logInUserImf.setPassword(field[3]);
			
			
			if(logInCheck(field)) {
					showEnterWarMessage();
			}
			//检测账号是否已经存在
			else if(!isAccountExist(field[2])) {
				showAccountWarMessage();
			}
			else {
				System.out.println("aaa");	
				logIn(logInUserImf);
				JOptionPane.showMessageDialog(dialog, "注册成功");
				dialog.setVisible(false);
				System.out.println("aaa");
			}
		});
			
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelSex);
		panel.add(boxSex);
		panel.add(blankLabel);
		panel.add(labelAccount);
		panel.add(fieldAccount);
		panel.add(labelPassword);
		panel.add(fieldPassword);
		panel.add(labelEnterRule1);
		panel.add(labelEnterRule2);
		panel.add(button);
		

		
		// 显示对话框 ( setVisible()方法会阻塞，直到对话框关闭 )
		dialog.setResizable(true);
		dialog.setSize(185,310);
		dialog.setLocation(600, 300);
		dialog.setVisible(true); // 这和JFrame.setVisible()

		
		// 对话框被关闭后，取得用户的输入，并返回
		
		
		
	}
	
	public void showEnterWarMessage() {
		JOptionPane.showMessageDialog(SignInCompoment.getSignInWindows(), "您的输入不规范\n请重新输入");
	}

	public void showAccountWarMessage() {
		JOptionPane.showMessageDialog(SignInCompoment.getSignInWindows(), "该账号已存在");
	}
		
	public boolean logInCheck(String[] content) {
		for(int i=0;i<Array.getLength(content);i++) {
			
		if(Objects.equals(content[i], "")||Objects.equals(content[i], "请选择")||content[i].length()>15) {
			System.out.println("错误");return true;
		}
		if(i==2) {
			if(content[i].length()!=10) {
				return true;
			}
			char str[]=content[i].toCharArray();
			for(int j=0;j<str.length;j++) {
				if(!Character.isDigit(str[j])) {
					System.out.println("错误4");
					break;
				}
			}
		}
		
		}
	return false;
	}
	
	
	
	
	static UserController userController = new UserController();
	

	public void logIn(LogInUserImformationBean logInUseImf) { 
		
		userController.userLogIn(logInUseImf);
		
	}
	
	
	public boolean isAccountExist(String account) {
		return userController.isAccountExist(account);
		
	}
	
	
}

