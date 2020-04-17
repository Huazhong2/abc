package com.wanghuazhong.event.view.button;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wanghuazhong.event.bean.AlterPersonImformationBean;
import com.wanghuazhong.event.controller.UserController;
import com.wanghuazhong.event.view.operatewindows.WindowsCompoment;
import com.wanghuazhong.event.view.signwindow.SignInCompoment;

public class PersonImformation extends JButton{

	private JTextField fieldName = new JTextField(15);
	private JComboBox<String> boxSex = new JComboBox<>();
	private AlterPersonImformationBean personImformation = new AlterPersonImformationBean();
	private JCheckBox password = new JCheckBox("是");
	JTextField fieldPassword =new JTextField(15);
	JDialog dialog= new JDialog(WindowsCompoment.operaPane, "个人信息",  true);
	
	
	public PersonImformation() {
		super();
		// TODO 自动生成的构造函数存根
		
		
		this.setText("个人信息");
		this.setFont(new Font("微软雅黑",0,14));
		this.setToolTipText("点击查看个人信息");
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				showRecordWindow();
				
			}
		
		});
				
		//构建出窗口布局
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		dialog.setContentPane(panel);		
		//控件
		JLabel blankLabel = new JLabel("    ");
		JLabel labelName = new JLabel("姓名:");
		JLabel labelSex= new JLabel("性别");
		JLabel labelPassword= new JLabel("密码:");
		JLabel labelEnterRule1=new JLabel("提示:各个输入应不超过15位 ");
		JButton button = new JButton("确定");	
		
		password.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(password.isSelected()) {
					fieldPassword.setEnabled(true);
				}
				else {
					fieldPassword.setEnabled(false);
				}
			}
		});
		
		button.addActionListener(e->{
			
			personImformation.setSex((String)boxSex.getSelectedItem());
			personImformation.setName(fieldName.getText());
			if(password.isSelected())
			personImformation.setPassword(fieldPassword.getText());
			else personImformation.setPassword(null);
								
			if(checkImformation(personImformation)) {
					showEnterWarMessage();
			}

			else {
				System.out.println("aaa");	
				alterImformation(personImformation);
				System.out.println("aaa");
			}
		});
			
		
		//加入控件
		
		boxSex.addItem("请选择");
		boxSex.addItem("男");
		boxSex.addItem("女");
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelSex);
		panel.add(boxSex);
		panel.add(blankLabel);
		panel.add(password);
		panel.add(labelPassword);
		panel.add(fieldPassword);
		panel.add(labelEnterRule1);	
		panel.add(button);
		button.addActionListener( (e)->{
			dialog.setVisible(false);
		});
		//控件的设置
	}
	

	public void showRecordWindow() {

		setPersonImformation();
		password.setSelected(false);
		fieldPassword.setEnabled(false);
		dialog.setResizable(false);
		dialog.setSize(360,220);
		dialog.setLocation(600, 300);
		dialog.setVisible(true); // 这和JFrame.setVisible()
		
		
		// 对话框被关闭后，取得用户的输入，并返回
		
		
		
	}
	
	public void showEnterWarMessage() {
		JOptionPane.showMessageDialog(SignInCompoment.getSignInWindows(), "您的输入不规范\n请重新输入");
	}

	
	public boolean checkImformation(AlterPersonImformationBean alterPersonImformationBean) {
		
		String [] content = new String[3];
		content[0]=alterPersonImformationBean.getName();
		content[1]=alterPersonImformationBean.getPassword();
		content[2]=alterPersonImformationBean.getSex();
	
		for(int i=0;i<Array.getLength(content);i++) {
			if(Objects.equals(content[i], null))
				continue;
			if(Objects.equals(content[i], "")||Objects.equals(content[i], "请选择")||content[i].length()>15) {
				return true;
			}
	}
		return false;
		
	}
	
	
	static UserController controller = new UserController();
	
	
	public void alterImformation(AlterPersonImformationBean alterPersonImformationBean) {
		
		 controller.alterImformation(alterPersonImformationBean);
		
	}
	
	public AlterPersonImformationBean getPersonImformation() {
		
		return controller.getPersonImformation();
		
	}
	
	
	public void setPersonImformation() {
		
		AlterPersonImformationBean imformation = getPersonImformation();
		fieldName.setText(imformation.getName());
		boxSex.setSelectedItem(imformation.getSex());
		
	}
	
}
