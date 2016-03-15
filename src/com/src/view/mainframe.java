package com.src.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.src.entity.User;
import com.src.service.DataService;

public class mainframe {
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	static final String[] COLUMN_NAME = { "ID", "厂家信息", "创建日期", "操作" };
	String[][] rowData = { { "张三", "男", "计算机系", "100 米 ,200 米" }, { "李四", "男", "化学系", "100 米，铅球" }, };
	String[] menuTab = {"主页签","用户管理"};

	JFrame f;
	JTabbedPane jTabbedPane;

	JTable jTable = new JTable(new DefaultTableModel(rowData, COLUMN_NAME));
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JTextField nameinput = new JTextField(15);
	JTextField passwordinput = new JTextField(15);
	JButton jButton = new JButton("修改并保存");
	
	DataService dataService = new DataService();

	public mainframe() {
		f = new JFrame("系統主界面");

		// ImageIcon icon = createImageIcon("images/middle.gif");

		// 主页签控件初始化
		JPanel mainPanel = new JPanel();
		BorderLayout bord = new BorderLayout();
		mainPanel.setLayout(bord);
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		JLabel jLabel = new JLabel("ID:");
		JTextField idInput = new JTextField(15);
		JButton queryBtn = new JButton("查询");
		JButton addBtn = new JButton("添加");
		toolBar.add(jLabel);
		toolBar.add(idInput);
		toolBar.add(queryBtn);
		toolBar.add(addBtn);
		mainPanel.add(BorderLayout.NORTH, toolBar);
		mainPanel.add(BorderLayout.CENTER, jTable);

		// 用户管理面板
		JPanel userPanel = new JPanel();
		GridBagLayout lay = new GridBagLayout();
		userPanel.setLayout(lay);
		JLabel name = new JLabel("用户名：");
		JLabel password = new JLabel("密 码：");
		
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets= new Insets(9, 3, 9, 3);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		userPanel.add(name,constraints);
		
		constraints.gridx = 2;
		constraints.gridwidth = 2;
		userPanel.add(nameinput,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		userPanel.add(password,constraints);
		
		constraints.gridx = 2;
		constraints.gridwidth = 2;
		userPanel.add(passwordinput,constraints);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		userPanel.add(jButton,constraints);
		
		tabbedPane.addTab(menuTab[0], mainPanel);
		tabbedPane.addTab(menuTab[1], userPanel);
		
		//添加页签切换侦听事件
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				initPanel();
			}
		});
		
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User user = new User(nameinput.getText(), passwordinput.getText());
				if(dataService.updateUser(user)){
					JOptionPane.showMessageDialog(null, "修改成功");
				}else{
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			}
		});

		f.setContentPane(tabbedPane);
		f.setVisible(true);
		f.setSize(WIDTH, HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	};
	
	public void initPanel(){
		//当激活用户管理面板时
		if(tabbedPane.getSelectedIndex() == 1){
			User user = dataService.initUserPanel();
			 nameinput.setText(user.getName());
			 passwordinput.setText(user.getPassword());
		}
	}
	
}
