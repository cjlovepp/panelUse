package com.src.entity;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ButtonEditor extends DefaultCellEditor {
	
    protected JButton button; 
    private String label;
    private boolean isPushed;
    
//    private JPanel 
  
    public ButtonEditor(JTextField checkBox) {
        super(checkBox);  
        this.setClickCountToStart(1);  
        button = new JButton();  
        button.setOpaque(true);  
        button.addActionListener(new ActionListener() {  
  
            public void actionPerformed(ActionEvent e) {  
                fireEditingStopped();  
            }  
        });  
  
    }  
  
    
    public Component getTableCellEditorComponent(final JTable table, Object value,  
            boolean isSelected,int row, int column) {
        if (isSelected) {  
            button.setForeground(table.getSelectionForeground());  
            button.setBackground(table.getSelectionBackground());  
        } else {  
            button.setForeground(table.getForeground());  
            button.setBackground(table.getBackground());  
        }  
        label = (value == null) ? "" : value.toString();  
        button.setText(label);  
        button.addActionListener(new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                System.out.println(table.getSelectedRow()) ;  
                System.out.println(table.getSelectedColumn()) ;  
            }  
        });  
        isPushed = true;  
        return button;  
    }  
  
    public Object getCellEditorValue() {
        if (isPushed) {  
            //   
            //   
           // JOptionPane.showMessageDialog(button, label + ": Ouch!");  
            // System.out.println(label + ": Ouch!");  
        }  
        isPushed = false;  
        return new String(label);  
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
