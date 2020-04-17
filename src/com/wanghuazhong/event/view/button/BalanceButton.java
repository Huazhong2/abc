package com.wanghuazhong.event.view.button;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wanghuazhong.event.controller.OrderController;
import com.wanghuazhong.event.controller.UserController;
import com.wanghuazhong.event.view.signwindow.SignInCompoment;

public class BalanceButton extends JButton{

	
	private int balance=0;
	
	public BalanceButton() {
		super();
		// TODO 自动生成的构造函数存根
		
		
		this.setText("用户余额");
		this.setFont(new Font("微软雅黑",0,14));
		
	
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				showRecordWindows();
			}
			
		});
	}
	
	public void showRecordWindows() {
		
	JDialog dialog = new JDialog(SignInCompoment.getSignInWindows(), "用户注册",  true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		dialog.setContentPane(panel);
		
		
		JLabel balanceLabel = new JLabel("你的余额:");
		JLabel leftedBalanceLabel  =new JLabel(getBalance()+"");
		JLabel blankLabel = new JLabel("       ");
		JLabel rechargeLabel = new JLabel("充值金额:");
		JLabel tip1= new JLabel("提示:输入的大小");
		JLabel tip2 = new JLabel("应不超过10000       ");
		
		JTextField rechargeField = new JTextField(15);
		
		JButton rechargeButton = new JButton("充值");
		
		panel.add(blankLabel);
		panel.add(balanceLabel);
		panel.add(leftedBalanceLabel);
		panel.add(rechargeLabel);
		panel.add(rechargeField);
		panel.add(tip1);
		panel.add(tip2);
		panel.add(rechargeButton);

		
		rechargeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				//
				if(rechargeField.getText().equals("")) {
					JOptionPane.showMessageDialog(dialog, "输入不能为空");
					return ;
				}
				char[] num = rechargeField.getText().toCharArray();
				for(char digit:num) {
					if(!Character.isDigit(digit)) {
						JOptionPane.showMessageDialog(dialog, "请在充值栏输入整数");
						return;
					}
				}
					int rechargeNumber = Integer.parseInt(rechargeField.getText());
					if(rechargeNumber>100000) {
						JOptionPane.showMessageDialog(dialog, "您的输入超过限制");
						return;
					}
					
					
				setRecharge(rechargeNumber);
				
				JOptionPane.showMessageDialog(dialog, "您的订单已提交！");
				rechargeField.setText("");
				dialog.setVisible(false);
				}
			
		});
		

		
		
		dialog.setSize(180,238);
		dialog.setResizable(false);
		dialog.setLocation(600, 300);
		dialog.setVisible(true); // 这和JFrame.setVisible()

		
		
	}
	
	static OrderController orderController = new OrderController();
	static UserController userController = new UserController();
	
	
	
	public void setRecharge(int rechargeNumber) {
		
		orderController.setRecharge(rechargeNumber);
		
	}
	
	
	public int getBalance() {
		
		return userController.getBalance();
			
	}
	

	
}



