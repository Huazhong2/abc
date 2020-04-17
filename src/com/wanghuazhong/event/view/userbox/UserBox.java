package com.wanghuazhong.event.view.userbox;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.wanghuazhong.event.controller.UserController;
import com.wanghuazhong.event.view.operatewindows.WindowsCompoment;

public class UserBox extends JComboBox<String>{

	
	public UserBox() {
		super();
		// TODO 自动生成的构造函数存根
		
		this.addItem("请选择用户模式");
		this.addItem("普通用户模式");
		this.addItem("管理员模式");
		
		JComboBox<String> isThis = this;
		isThis.setSelectedIndex(0);
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int index = isThis.getSelectedIndex();
				CardLayout layout = (CardLayout) WindowsCompoment.cards.getLayout();
				if(index==1) {
					layout.show(WindowsCompoment.cards, "commonUserArea");
				}
				else if(index==2) {
					if(getIsAdmin()!=0) {
						layout.show(WindowsCompoment.cards, "adminArea");
					}
					else {
						layout.show(WindowsCompoment.cards,"blank");
						WindowsCompoment.userBox.setSelectedIndex(0);
						JOptionPane.showMessageDialog(WindowsCompoment.operaPane, "您不是管理员");
					}
				}
				else {
					layout.show(WindowsCompoment.cards, "blank");
				}
			}
		});
		
		
		
	}
	
	static UserController controller = new UserController();
	
	public int getIsAdmin() {
		
		return controller.getIsAdmin();
	}
	

	
}
