package com.src.entity;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ButtonEditor extends DefaultCellEditor {
	
	private JPanel panel;
	private JButton delBtn;
	private JButton printBtn;
	private Boolean isPushed;
	
    
//    private JPanel 
  
    public ButtonEditor(JTextField checkBox) {
        super(checkBox);  
        this.setClickCountToStart(1);  
        this.delBtn = new JButton("删除");
        
		this.printBtn = new JButton("打印");
		
		
		this.panel = new JPanel();
		this.panel.add(this.delBtn);
		this.panel.add(this.printBtn);
    }
  
    
    public Component getTableCellEditorComponent(final JTable table, Object value,  
            boolean isSelected,int row, int column) {
    	
    	final String cc = row+","+column+")";
    	
    	this.delBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JOptionPane.showMessageDialog(null, "del"+cc);
			}
		});
    	
    	this.printBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "print"+cc);
			}
		});
        
        isPushed = true;  
        return this.panel;  
    }
  
    public boolean stopCellEditing() {  
        isPushed = false;  
        return super.stopCellEditing();  
    }  
  
    @Override  
    public boolean shouldSelectCell(EventObject anEvent) {  
        System.out.println(1);  
        return super.shouldSelectCell(anEvent);  
    }  
      
      
}
