package com.wanghuazhong.event.view.button.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.wanghuazhong.event.bean.MatchIdBean;
import com.wanghuazhong.event.controller.AdminMatchController;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.entity.OrderImformation;

public class AdminMatchButton extends JButton{

	private JFrame frame = new JFrame("赛事管理");
	private JTextField searchTextField;
	private JTable table = null;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JButton addButton;
	private JButton cancelButton;
	JToolBar toolBar = new JToolBar();
	
	public AdminMatchButton() {
		
		super();
		// TODO 自动生成的构造函数存根
		//按钮设置
		this.setText("赛事管理");
		this.setFont(new Font("微软雅黑",0,14));
		this.setToolTipText("对用户的订单进行管理");
		//按钮点击事件
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//调用查询窗口 

				showRecordWindows();
				
			}
			
		});	
		
		//面板初始化
		panel.setLayout(new BorderLayout());
		frame.setContentPane(panel);
		//添加菜单栏
		panel.add(toolBar,BorderLayout.PAGE_START);
		toolBar.setFloatable(false);
		//初始化表格
		initialTable();
		
		//给菜单栏添加第一个按钮
		addButton=createToolBarButton("添加","ic_reserve.png");
		toolBar.add(addButton);
		//菜单栏第一个按钮的点击事件
		addButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				showAddDataWindow();
				}
				
			
		});
				
		
		//菜单栏第二个按钮的点击事件
	    cancelButton = createToolBarButton("取消","ic_cancel.png");
		toolBar.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				deleteData();
			}
			
		});
		//在菜单栏添加间隔
		toolBar.addSeparator(new Dimension(50,10));
		//在菜单栏添加查询标签
		JLabel search = new JLabel("查询:");
		toolBar.add(search);
		//设置查询框
		searchTextField = new JTextField();
		toolBar.add(searchTextField);
		searchTextField.setMaximumSize(new Dimension(120,30));
		//查询框回车监听器
		searchTextField.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String searchContent = searchTextField.getText();
				tableModel.setRowCount(0);//先清空了model的内容，搜索时再放入
				
				List<MatchImformation> matchImfoList = getMatchImformation(searchContent);
				if(Objects.equals(matchImfoList, null)) {
					return;
				}
				addData(matchImfoList);
				}
		});
		
		
		
		
		}//构造方法结束
		
		//展示赛事管理窗口
		public void showRecordWindows() {
	
			tableModel.setRowCount(0);
			List<MatchImformation> matchImfoList = getMatchImformation("");
			
			if(!Objects.equals(matchImfoList, null)) {
				addData(matchImfoList);
			}
			
			searchTextField.setText("");;
			
			frame.setLocation(500,200);
			frame.setSize(830,380);
			frame.setVisible(true);
			
			System.out.println("sssss");
		
	}
		
		//创建个性化的功能按钮
		//包含按钮的名称以及按钮图片的名称
		public JButton createToolBarButton(String text,String icon) {
			String path = "/iconimage/"+icon;
			URL imageUrl = getClass().getResource(path);
			JButton button = new JButton();
			button.setText(text);
			button.setToolTipText("别犹豫了，赶紧点击"+text);
			button.setIcon(new ImageIcon(imageUrl));
			button.setFocusPainted(false);
			return button;

		}
		
		
		//初始化表格
		public void initialTable() {
			//创建表格，放入model
			
			table = new JTable(tableModel) {
				@Override
				public boolean isCellEditable(int row,int column) {//设置不可编辑
					return false;
					
				}
			};
			
			JScrollPane scrollPane = new JScrollPane(table);
			panel.add(scrollPane,BorderLayout.CENTER);
			
			//作用
			table.setFillsViewportHeight(true);
			table.setRowSelectionAllowed(true);//可以被正行选择
			table.setRowHeight(30);//行高
			//添加列
			tableModel.addColumn("Id");
			tableModel.addColumn("赛名");
			tableModel.addColumn("战队1");
			tableModel.addColumn("战队2");
			tableModel.addColumn("时间");
			tableModel.addColumn("票价");
			//设置列设置器
			table.getColumnModel().getColumn(0).setCellRenderer(new MatchOrderIdTableCellRenderer());
			//设置列宽
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			
			
		}
		
		
		//点击菜单栏赛事添加按钮的功能界面
		public void showAddDataWindow() {
		
			JDialog dialog = new JDialog(frame,"添加赛事",true);
			JPanel panel = new JPanel();
			dialog.setContentPane(panel);
			panel.setLayout(new FlowLayout());
			
			//添加组件
			JLabel nameLabel = new JLabel("赛名");
			JLabel team1NameLabel = new JLabel("战队1名字");
			JLabel team2NameLabel = new JLabel("战队2名字");
			JLabel timeLabel = new JLabel("时间");
			JLabel priceLabel = new JLabel("价格");
			JLabel tip1 = new JLabel("提示:所有输入不应超过15位");
			JLabel tip2 = new JLabel("价格应为整数，且不超过100000");//

			JTextField nameField = new JTextField(15);
			JTextField team1NameField = new JTextField(15);
			JTextField team2NameField = new JTextField(15);
			JTextField timeField = new JTextField(15);
			JTextField priceField = new JTextField(15);
			
			JButton button = new JButton("确定");
			
			panel.add(nameLabel);
			panel.add(nameField);
			panel.add(team1NameLabel);
			panel.add(team1NameField);
			panel.add(team2NameLabel);
			panel.add(team2NameField);
			panel.add(timeLabel);
			panel.add(timeField);
			panel.add(priceLabel);
			panel.add(priceField);
			panel.add(tip1);
			panel.add(tip2);
			
			panel.add(button);
			
			
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根					
					MatchImformation matchImfo =new MatchImformation();
					matchImfo.setName(nameField.getText());
					matchImfo.setTeamName1(team1NameField.getText());
					matchImfo.setTeamName2(team2NameField.getText());
					matchImfo.setTime(timeField.getText());
					//检测价格是否为纯数字
					char[] num = priceField.getText().toCharArray();
					for(char digit:num) {
						if(!Character.isDigit(digit)) {
							JOptionPane.showMessageDialog(dialog, "请在价格栏输入整数");
							return;
						}
					}
					//
					int ticketPrice = Integer.parseInt(priceField.getText());
					matchImfo.setTicketPrice(ticketPrice);		
					if(!checkEnter(matchImfo)) {
						JOptionPane.showMessageDialog(dialog, "输入不规范");
					}
					else {
						//添加数据到model和添加数据到后台
						addSingleData(matchImfo);
						addMatchImformation(matchImfo);
						nameField.setText("");
						team1NameField.setText("");
						team2NameField.setText("");
						timeField.setText("");
						priceField.setText("");
						dialog.setVisible(false);
					}
				}
				
			});
			
			
			
			
			// 显示对话框 ( setVisible()方法会阻塞，直到对话框关闭 )
			dialog.setResizable(false);
			dialog.setSize(210,356);
			dialog.setLocation(600, 300);
			dialog.setVisible(true); // 这和JFrame.setVisible()
			
			
		}
		

		
		
	
		//添加数据到model
		public void addData(List<MatchImformation> matchList) {
			
			for(int i=matchList.size()-1;i>=0;i--) {
				addSingleData(matchList.get(i));
			}
		}
		
		//添加单条数据到model
		public void addSingleData(MatchImformation matchImfo) {
			
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(matchImfo.getId());
			rowData.add(matchImfo.getName());
			rowData.add(matchImfo.getTeamName1());
			rowData.add(matchImfo.getTeamName2());
			rowData.add(matchImfo.getTime());
			rowData.add(matchImfo.getTicketPrice());
			tableModel.addRow(rowData);
			
		}
		
		
		//从面板删除和从数据库删除
		public void deleteData() {
			int rows[] = table.getSelectedRows();
			if (rows.length==0)  return;
			MatchIdBean idList = new MatchIdBean(rows.length);
			int []id = idList.getId();
			
			for(int i =rows.length-1;i>=0;i--) {
				
				id[i]=(int) tableModel.getValueAt(rows[i], 0);
				tableModel.removeRow(rows[i]);
			}
			
			//然后从数据库删除
			
			deleteFromDataBase(idList);
		}
		
		
		
		static AdminMatchController controller = new AdminMatchController();
		
		//从数据中搜索
		//用到数据库
		public List<MatchImformation> getMatchImformation(String search) {
			
			return controller.getMatchImformation(search);
			
		}
		//添加单条记录到数据库
		//添加单条记录,用到数据库
		public boolean addMatchImformation(MatchImformation matchImfo){
			
			return controller.addMatchImformation(matchImfo);
		}
		
		
		//检查输入
		//检查输入是否合理
		public boolean checkEnter(MatchImformation matchImfo) {
			return controller.checkEnter(matchImfo);
			
		}
		//从数据库删除
		
		
		//从数据库删除
		public boolean deleteFromDataBase(MatchIdBean matchIdBean) {
			return controller.deleteFromDataBase(matchIdBean);
			
		}
		
		
}
