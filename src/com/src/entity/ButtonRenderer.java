package com.src.entity;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer implements TableCellRenderer {
	
	private JPanel panel;
	private JButton delBtn;
	private JButton printBtn;

	public ButtonRenderer() {
		this.delBtn = new JButton("删除");
		this.printBtn = new JButton("打印");
		this.panel = new JPanel();
		this.panel.add(this.delBtn);
		this.panel.add(this.printBtn);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		
		return this.panel;
	}

}
