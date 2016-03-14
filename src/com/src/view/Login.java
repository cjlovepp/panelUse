package com.src.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

///这是一个登录类。设计成一个继承容器的类。
class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	/// WIDTH是指整个顶层框架的宽度。
	/// HEIGHT是指整个顶层框架的长度。
	static final int WIDTH = 300;
	static final int HEIGHT = 150;
	JFrame loginframe;

	/// 此方法用来添加控件到容器中
	/// 按照网格组布局方式排列组件的方法
	/// x指控件位于第几列。
	/// y指控件位于第几行。
	/// w指控件需要占几列。
	/// h指控件需要占几行。
	public void add(Component c, GridBagConstraints constraints, int x, int y, int w, int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c, constraints);
	}

	/// 这是一个构造器方法
	/// loginframe是就是指这个界面的框架
	/// setDefaultCloseOperation这是一个使得窗口上面的关闭控件有效的类库方法
	/// lay是一个网格组布局管理器的对象。
	/// nameinput是用来输入用户名的文本域。
	/// passwordinput是用来输入密码的文本域。
	/// title是用来显示标题的标签。
	/// name是用来显示“姓名”的标签。
	/// password是用来显示“密码”的标签。
	/// ok是一个按钮，使进入系统。
	/// cancel是一个按钮，使退出界面和系统。
	/// ok.addActionListener是一个进入系统动作事件监听方法。
	/// cancel.addActionListener是一个退出系统和界面动作事件的监听方法。
	Login() {
		loginframe = new JFrame("show!!!");
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		loginframe.add(this, BorderLayout.WEST);
		loginframe.setSize(WIDTH, HEIGHT);
		/// 通过下面的代码来设置登陆窗口的位置
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH) / 2;
		int y = (height - HEIGHT) / 2;
		loginframe.setLocation(x, y);

		JButton ok = new JButton("登录");
		JButton cancel = new JButton("放弃");
		JLabel title = new JLabel("登陆窗口xxxxxxxxxxxx");
		JLabel name = new JLabel("  用户名：");
		JLabel password = new JLabel("密 码：");
		final JTextField nameinput = new JTextField(15);
		final JPasswordField passwordinput = new JPasswordField(15);
		/// 设置网格组布局管理器的参数
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.anchor = GridBagConstraints.NORTHEAST;
		constraints.weightx = 4;
		constraints.weighty = 4;
		/// 使用网格组布局添加控件
		GridBagConstraints constraints_title=new GridBagConstraints();
		constraints_title.fill=GridBagConstraints.NONE;
		constraints_title.anchor=GridBagConstraints.EAST;
		constraints_title.weightx=4;
		constraints_title.weighty=4;
		add(title,constraints_title,2,0,2,1);     
		add(name, constraints_title, 1, 1, 2, 1);
		add(password, constraints_title, 1, 2, 2, 1);
		add(nameinput, constraints_title, 3, 1, 2, 1);
		add(passwordinput, constraints_title, 3, 2, 2, 1);
		GridBagConstraints constraints2 = new GridBagConstraints();
		constraints2.fill = GridBagConstraints.NONE;
		constraints2.anchor = GridBagConstraints.CENTER;
		constraints2.anchor = GridBagConstraints.NORTHWEST;
		add(ok, constraints2, 3, 3, 1, 1);
		add(cancel, constraints, 3, 3, 1, 1);
		loginframe.setResizable(false);
		loginframe.setVisible(true);
		/// 当单击“确定”按钮后，会引起动作事件，下面的代码将给出事件处理的结果
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				String nametext = nameinput.getText();
				String passwordtext = new String(passwordinput.getPassword());
				boolean x = (nametext.equals("admin"));
				boolean y = (passwordtext.equals("123456")); // 在此设置密码和用户名
				boolean z = (x && y);
				/// 当密码和用户名都正确的话，将会进入到主菜单界面，如果用户名或者密码不正确的话，那么系统将会将所有输入清空，让用户重新输入
				if (z == true) {
					new mainframe(); //此界面就是后面的主界面
					loginframe.dispose();
				} else if (z == false) {
					JOptionPane.showMessageDialog(null, "用戶名和密码错误！");
					nameinput.setText("");
					passwordinput.setText("");
				}
			}
		});
		/// 当单击“放弃”按钮后，会引起动作事件，下面的代码给出了此事件处理的结果的方式
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				loginframe.dispose();
			}
		});
	}
}