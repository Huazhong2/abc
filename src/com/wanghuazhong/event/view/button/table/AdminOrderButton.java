package com.wanghuazhong.event.view.button.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.wanghuazhong.event.bean.OrderIdBean;
import com.wanghuazhong.event.controller.OrderController;
import com.wanghuazhong.event.entity.OrderImformation;

public class AdminOrderButton extends JButton{

	private JFrame frame = new JFrame();
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JTextField searchTextField = new JTextField(15);
	private JTable table;
	private JButton addButton;
	private JButton cancelButton;
	private JToolBar toolBar = new JToolBar();
	private OrderIdBean orderIdBean;
	
	public AdminOrderButton() {
		super();
		
		this.setText("订单详情");
		this.setFont(new Font("微软雅黑",0,14));
		this.setToolTipText("点击查看");
		
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
		addButton=createToolBarButton("受理","ic_reserve.png");
		toolBar.add(addButton);
		//菜单栏第一个按钮的点击事件
		addButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
				orderIdBean = getIdList();
				if(Objects.equals(orderIdBean,null)) {
					return;
				}
				else {
					setOrderStatus(orderIdBean,true);
					dealReturnBalance(orderIdBean);
				}
				}
		});
				
		
		//菜单栏第二个按钮的点击事件
	    cancelButton = createToolBarButton("驳回","ic_cancel.png");
		toolBar.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				orderIdBean = getIdList();
				if(Objects.equals(orderIdBean,null)) {
					return;
				}
				else {
					setOrderStatus(orderIdBean,false);
					dealReturnBalance(orderIdBean);
				}
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
				
				List<OrderImformation> orderImfoList = getOrderImformation(searchContent);
				if(Objects.equals(orderImfoList, null)) {
					return;
				}
				addData(orderImfoList);
				}
		});
			
		//构造方法结束
	}
	
	public void showRecordWindows() {
	
		tableModel.setRowCount(0);
		List<OrderImformation> orderImfoList = getOrderImformation("");
		if(!Objects.equals(orderImfoList, null)) {
			addData(orderImfoList);
		}
		
		searchTextField.setText("");
		
		frame.setLocation(500,200);
		frame.setSize(830,380);
		frame.setVisible(true);
		
		
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
		tableModel.addColumn("订单Id");
		tableModel.addColumn("订单类型");
		tableModel.addColumn("订单名");
		tableModel.addColumn("用户账号");
		tableModel.addColumn("类型Id");
		tableModel.addColumn("订购时间");
		tableModel.addColumn("票价");
		tableModel.addColumn("状态");
		
		//设置列设置器
		table.getColumnModel().getColumn(0).setCellRenderer(new MatchOrderIdTableCellRenderer());
		//设置列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		
	}
	
	
	//往JTabel的Model中加入数据
	public void addData(List<OrderImformation> orderImfoList) {
		
		
		for(int i=orderImfoList.size()-1;i>=0;i--) {
			Vector<Object> addRow = new Vector<Object>();
			
			OrderImformation orderImfo = orderImfoList.get(i);
			if(!orderImfo.getStatus().equals("待受理")) {
				continue;
			}
			addRow.add(orderImfo.getOrderId());
			addRow.add(orderImfo.getOrderType());
			addRow.add(orderImfo.getOrderName());
			addRow.add(orderImfo.getUserAccount());
			addRow.add(orderImfo.getOrderTypeId());
			addRow.add(orderImfo.getOrderTime());
			addRow.add(orderImfo.getPrice());
			addRow.add(orderImfo.getStatus());
			tableModel.addRow(addRow);
		}
	}
	
	public OrderIdBean getIdList() {
		
		int []rows = table.getSelectedRows();
		if(Objects.equals(rows, null)) {
			return null;
		}
		
		orderIdBean = new OrderIdBean(rows.length);
		int[] idList = orderIdBean.getIdList();
		//删除的同时记录下id
		for(int i=rows.length-1;i>=0;i--) {
			idList[i] = (int) tableModel.getValueAt(rows[i], 0);
			tableModel.removeRow(rows[i]);
		}
		
		return orderIdBean;
	}
	
	
	static OrderController controller = new OrderController();
	
	//从数据库获取订单信息
	public List<OrderImformation> getOrderImformation(String search){
		
		return controller.getOrderImformation(search);
		
	}
	
	
	//设置订单受理信息
	public void setOrderStatus(OrderIdBean orderIdBean,boolean status) {
		controller.setOrderStatus(orderIdBean, status);
	}

	public void dealReturnBalance(OrderIdBean orderIdBean) {
		controller.dealReturnBalance(orderIdBean);
	}
	
}
