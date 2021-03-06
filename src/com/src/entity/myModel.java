package com.src.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.dom4j.Element;

import com.src.service.DataService;

public class myModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DataService dataService = new DataService();

	private static final Vector<String> columnName = new Vector<String>();
	
	static{
		columnName.add("ID");
		columnName.add("厂家信息");
		columnName.add("创建日期");
		columnName.add("操作");
	}
	
	private Vector<List<String>> dataTable;

	@Override
	public int getColumnCount() {
		return columnName.size();
	}

	@Override
	public int getRowCount() {
		return dataTable.size();
	}

	@Override
	public String getValueAt(int row, int colum) {
		List<String> tempLine = this.dataTable.get(row);
		return tempLine.get(colum);
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.dataTable.get(rowIndex).set(columnIndex, aValue.toString());
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnName.get(column);
	}
	
	public myModel() {
		
		dataTable = queryData(null);
	}
	
	public myModel(String id) {
		
		dataTable = queryData(id);
	}
	
	public Vector<List<String>> queryData(String id){
		Vector<List<String>> data = new Vector<List<String>>();
		List<Element> list = dataService.findViewById(id);
		for(int i=0; i<list.size();i++){
			List<String> tempStr = new ArrayList<String>();
			tempStr.add(list.get(i).attributeValue("id"));
			tempStr.add(list.get(i).attributeValue("info"));
			tempStr.add(list.get(i).attributeValue("date"));
			tempStr.add(list.get(i).attributeValue(""));
			
			data.add(tempStr);
		}
		
		return data;
	}
	
	@Override
	public void fireTableCellUpdated(int row, int column) {
		// TODO Auto-generated method stub
		super.fireTableCellUpdated(row, column);
	}
	
	@Override
	public void fireTableDataChanged() {
		// TODO Auto-generated method stub
		super.fireTableDataChanged();
	}

}
