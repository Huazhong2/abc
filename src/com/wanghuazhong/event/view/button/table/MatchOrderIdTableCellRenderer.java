package com.wanghuazhong.event.view.button.table;

import java.awt.Component;
import java.util.Objects;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MatchOrderIdTableCellRenderer extends JCheckBox implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		// TODO 自动生成的方法存根
		this.setSelected(isSelected);
		if(!Objects.equals(value,null))
			this.setText(value.toString());
		
		//设置选中的背景
		if(isSelected) {
			this.setBackground(table.getSelectionBackground());
			this.setForeground(table.getSelectionForeground());
		}
		else {
			this.setBackground(table.getBackground());
			this.setForeground(table.getForeground());
		}
		return this;
	}

	
}
