package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

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
import com.wanghuazhong.event.entity.OrderImformation;
import com.wanghuazhong.event.view.button.table.MatchOrderIdTableCellRenderer;

public class Demo extends JButton{

	private JFrame frame = new JFrame();
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JTextField searchTextField = new JTextField(15);
	private JTable table;
	private JButton addButton;
	private JButton cancelButton;
	JToolBar toolBar = new JToolBar();
	
	public Demo() {
		super();
		
		
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
				
				}
				
			
		});
				
		
		//菜单栏第二个按钮的点击事件
	    cancelButton = createToolBarButton("取消","ic_cancel.png");
		toolBar.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
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
//				String searchContent = searchTextField.getText();
//				tableModel.setRowCount(0);//先清空了model的内容，搜索时再放入
//				
//				List<MatchImformation> matchImfoList = getMatchImformation(searchContent);
//				if(Objects.equals(matchImfoList, null)) {
//					return;
//				}
//				addData(matchImfoList);
				}
		});
		
		
		
		
		//构造方法结束
	}
	
	public void showRecordWindows() {
	
		tableModel.setRowCount(0);
		//
		//插入数据部分
		
		searchTextField.setText("");
		
		frame.setLocation(500,200);
		frame.setSize(830,380);
		frame.setVisible(true);
		
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
	
	
	//往Tabel的Model中加入数据
	public void addData(List<OrderImformation> orderImfoList) {
		
	}
	
	//从Tabel的Model中删除数据
	public void deleteData() {
		
	}
	
	//从数据库获取订单信息
	public List<OrderImformation> getOrderImformation(String search){
		return null;
		
	}
	
	
	//从数据库删除信息
	public boolean deleteImformation(OrderIdBean orderIdBean) {
		return false;
		
	}
	
	


}
