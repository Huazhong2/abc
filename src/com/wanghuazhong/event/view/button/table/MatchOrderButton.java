package com.wanghuazhong.event.view.button.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.wanghuazhong.event.controller.MatchOrderController;
import com.wanghuazhong.event.entity.MatchImformation;
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.service.Impl.LogInAndSignInService;
import com.wanghuazhong.event.view.operatewindows.WindowsCompoment;

public class MatchOrderButton extends JButton {
	
	private JDialog dialog = new JDialog(WindowsCompoment.operaPane, "查询",  true);;
	
	private JTextField searchTextField;
	
	private JTable table = null;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JButton reserveButton=createToolBarButton("预定","ic_reserve.png");
	private JButton cancelButton;
	JToolBar toolBar = new JToolBar();
	
	private int bill=0;
	public MatchOrderButton() {
		
		
		
		super();
		// TODO 自动生成的构造函数存根
		//按钮设置
		this.setText("查询赛事");
		this.setFont(new Font("微软雅黑",0,14));
		this.setToolTipText("点击查询赛事");
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//调用查询窗口 

				showRecordWindows();
				
			}
			
		});
		
		
		
		//初始化组件
		
		panel.setLayout(new BorderLayout());
		dialog.setContentPane(panel);
		
		panel.add(toolBar,BorderLayout.PAGE_START);
		toolBar.setFloatable(false);
		
		
		initialTable();

		
		//给它添加预定按钮
		
		toolBar.add(reserveButton);
		reserveButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				List<OrderImformation> orderImfo = getOrderImformation();
				if(Objects.equals(orderImfo,null)) return ;
				int buttonSelection = JOptionPane.showConfirmDialog(dialog, "总花费为"+bill+"元,"+"是否预订您选中的赛事?","确认",JOptionPane.YES_NO_OPTION);
				if(buttonSelection==0) {
					if(addOrder(orderImfo,bill)) {
					JOptionPane.showMessageDialog(dialog,"预定成功");
					}
					else {
						JOptionPane.showMessageDialog(dialog, "你的余额不足");
					}
				}
				
			}
			
		});
				
		//改为查看评论用
		//给它添加取消预定的按钮
	    cancelButton = createToolBarButton("取消","ic_cancel.png");
		toolBar.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
		});
		//加一段间隔
		toolBar.addSeparator(new Dimension(50,10));
		
		//加个提示标签
		JLabel search = new JLabel("查询:");
		toolBar.add(search);
		
		//设置输入框
		searchTextField = new JTextField();
		toolBar.add(searchTextField);
		searchTextField.setMaximumSize(new Dimension(120,30));
		
		
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
		

	}
	
	//构造方法结束
	
	
	
		public void showRecordWindows() {
			
			tableModel.setRowCount(0);
			List<MatchImformation> matchImfoList = getMatchImformation("");
			if(Objects.equals(matchImfoList, null)) {
				searchTextField.setText("");
				
				dialog.setLocation(500,200);
				dialog.setSize(500,300);
				dialog.setVisible(true);
				
				return;
			}
			addData(matchImfoList);
			searchTextField.setText("");
			
			dialog.setLocation(500,200);
			dialog.setSize(830,380);
			dialog.setVisible(true);
			
			System.out.println("sssss");
		}
		
			
		
		
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
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
		
			
		}

		//向model添加数据
		public void addData(List<MatchImformation> matchList) {
			
			for(int i=matchList.size()-1;i>=0;i--) {
				Vector<Object> rowData = new Vector<Object>();
				rowData.add(matchList.get(i).getId());
				rowData.add(matchList.get(i).getName());
				rowData.add(matchList.get(i).getTeamName1());
				rowData.add(matchList.get(i).getTeamName2());
				rowData.add(matchList.get(i).getTime());
				rowData.add(matchList.get(i).getTicketPrice());
				tableModel.addRow(rowData);
				
			}
			
			
		}
		//获得添加订单的数据
		public List<OrderImformation> getOrderImformation() {
			
			
			int[] rows = table.getSelectedRows();
			if(rows.length==0) return null;
			List<OrderImformation> orderImfoList = new ArrayList<OrderImformation>();
			for(int i = rows.length-1;i>=0;i--) {
				MatchImformation matchImfo = getRowImformation(rows[i]);
				OrderImformation orderImfo = new OrderImformation();
				orderImfo.setOrderTypeId(matchImfo.getId());
				orderImfo.setOrderType("赛事");
				orderImfo.setOrderName(matchImfo.getName());
				orderImfo.setUserAccount(LogInAndSignInService.getAccount());
				orderImfo.setPrice((int) matchImfo.getTicketPrice());
				bill= bill+(int)matchImfo.getTicketPrice();
				System.out.println("获取订单    "+bill+"    get"+(int)matchImfo.getTicketPrice());
				//status有默认值
				orderImfoList.add(orderImfo);
			}
			
			return orderImfoList;
		}
		
		//从model获取单行数据
		public MatchImformation getRowImformation(int row) {
			MatchImformation matchImfo = new MatchImformation();
			
			matchImfo.setId((int) tableModel.getValueAt(row,0));
			matchImfo.setName((String) tableModel.getValueAt(row, 1));
			matchImfo.setTeamName1((String) tableModel.getValueAt(row, 2));
			matchImfo.setTeamName2((String) tableModel.getValueAt(row, 3));
			matchImfo.setTime((String) tableModel.getValueAt(row, 4));
			matchImfo.setTicketPrice((int) tableModel.getValueAt(row, 5));
			
			return matchImfo;
			
		}
		
		
		
		
		
		
		static MatchOrderController controller = new MatchOrderController();
		
		//用到数据库
		//向数据库添加order
		public boolean addOrder(List<OrderImformation> orderImfoList,int bill) {
			if(!minusBalance(bill)) {
				//show
				return false;
			}
			else {
				controller.addOrder(orderImfoList);
				return true;
			}
			
			
		}
		
		//从数据库获取信息
		public List<MatchImformation> getMatchImformation(String searchContent) {
			
			return controller.getMatchImformation(searchContent);
			
		}
		//用到数据库
		public boolean minusBalance(int bill) {
			
			return controller.minusBalance(bill);
			
		}
		

		
		
}
