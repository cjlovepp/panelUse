package com.src.view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
public class mainframe  
{
	static final int WIDTH=600;
    static final int HEIGHT=400;
    
    JFrame f;
    JTabbedPane jTabbedPane;
    
    public mainframe(){
      f=new JFrame("系統主界面");
  	  
      JTabbedPane tabbedPane = new JTabbedPane();
      //ImageIcon icon = createImageIcon("images/middle.gif");
      
      //主页签控件初始化
      JPanel mainPanel = new JPanel();
      BorderLayout bord = new BorderLayout();
      mainPanel.setLayout(bord);
      JToolBar toolBar = new JToolBar();
      JTextField idInput = new JTextField(15);
      JButton queryBtn = new JButton("查询");
      JButton addBtn = new JButton("添加");
      toolBar.add(idInput);
      toolBar.add(queryBtn);
      toolBar.add(addBtn);
      mainPanel.add(BorderLayout.NORTH, toolBar);
      
      
      JPanel userPanel = new JPanel();
      
      
      tabbedPane.addTab("主页签", mainPanel);
      tabbedPane.addTab("用户管理", userPanel);
  	  
  	  f.setContentPane(tabbedPane);
  	  f.setVisible(true);
  	  f.setSize(WIDTH,HEIGHT);
    };
}


