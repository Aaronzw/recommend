package LoginFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Thread.myThread;
import UI.MouseEventListener;

public class LoginInterface extends JFrame{
	private static final long serialVersionUID = 1L;
	private myBackgroundPanel panelMain;
	private JButton buttonConfirm;
	private JButton buttonCancel;
	private JButton buttonRegistered;
	private JLabel labelUsername;
	private JLabel labelPassword;
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;
	private String userName;
	private myThread thisThread;
	private static LoginInterface loginInterface = new LoginInterface();
	
	public static LoginInterface getLoginInterface(){
		return loginInterface;
	}
	
	public String getUserName() {
		return userName;
	}
	
	private LoginInterface(){
//		super("Open The World");
		this.setUndecorated(true);
		BuildPanel();
		this.add(panelMain);
		this.setSize(450, 260);
		ImageIcon icon = new ImageIcon("login.png");
    	Image imageZhiHu1 = icon.getImage().getScaledInstance(this.getWidth() + 10, 
    						this.getHeight(), icon.getImage().SCALE_DEFAULT);
//    	ImageIcon iconZhiHu1 = new ImageIcon(imageZhiHu1);
    	this.setIconImage(imageZhiHu1);
    	
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		this.setResizable(false);
		this.setLocation(screenSize.width / 3, screenSize.height / 3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		MouseEventListener mouseListener = new MouseEventListener(this);
	    this.addMouseListener(mouseListener);
	    this.addMouseMotionListener(mouseListener);
	}
	
	private void BuildPanel(){
		panelMain = new myBackgroundPanel("login.png", 540, 275);  // add a background
		panelMain.setLayout(new GridBagLayout());
		addLabel();
		addField();
		addButton();
	}
	
	private void addLabel(){
		labelUsername = new JLabel("用户名");
		labelPassword = new JLabel("密  码");
		labelUsername.setFont(new Font("宋体", Font.BOLD, 19));
		labelPassword.setFont(new Font("宋体", Font.BOLD, 19));
		
		panelMain.add(labelUsername, new myGridBagLayout(0, 0).set_Fill(myGridBagLayout.NONE).
				set_Anchor(myGridBagLayout.EAST).setInset(2, 0, 0, 20));
		panelMain.add(labelPassword, new myGridBagLayout(0, 1).set_Fill(myGridBagLayout.NONE).
				set_Anchor(myGridBagLayout.EAST).setInset(7, 0, 0, 20));
	}
	
	private void addField(){
		fieldUsername = new JTextField(12);
		fieldPassword = new JPasswordField(12);
		fieldUsername.setFont(new Font("宋体", Font.BOLD, 20));
		fieldPassword.setFont(new Font("宋体", Font.BOLD, 20));
		fieldPassword.setEchoChar('*');
		
		panelMain.add(fieldUsername, new myGridBagLayout(1, 0, 2, 1).set_Fill(myGridBagLayout.NONE).
				set_Anchor(myGridBagLayout.WEST).setInset(2, 0, 0, 10));
		panelMain.add(fieldPassword, new myGridBagLayout(1, 1, 2, 1).set_Fill(myGridBagLayout.NONE).
				set_Anchor(myGridBagLayout.WEST).setInset(7, 0, 0, 10));
	}
	
	private void addButton(){
		
		buttonConfirm = new JButton("确定");
		buttonCancel = new JButton("取消");
		buttonRegistered = new JButton("注册");
		buttonConfirm.setFont(new Font("宋体", Font.BOLD, 15));
		buttonCancel.setFont(new Font("宋体", Font.BOLD, 15));
		buttonRegistered.setFont(new Font("宋体", Font.BOLD, 15));
		buttonConfirm.setContentAreaFilled(false);
		buttonCancel.setContentAreaFilled(false);
		buttonRegistered.setContentAreaFilled(false);
		buttonConfirm.setBorderPainted(false);
		buttonCancel.setBorderPainted(false);
		buttonRegistered.setBorderPainted(false);
		
		panelMain.add(buttonConfirm, new myGridBagLayout(1, 2).set_Fill(myGridBagLayout.NONE).
				set_Anchor(myGridBagLayout.CENTER).setInset(7, 5, 10, 20));
		panelMain.add(buttonCancel, new myGridBagLayout(2, 2).set_Fill(myGridBagLayout.NONE).
				set_Anchor(myGridBagLayout.EAST).setInset(7, 5, 10, 10));
		panelMain.add(buttonRegistered, new myGridBagLayout(0, 2).set_Fill(myGridBagLayout.NONE).
				set_Anchor(myGridBagLayout.SOUTHWEST).setInset(7, 5, 10, 30));
		addButtonFunction();
	}
	
	private void addButtonFunction(){
		
		buttonRegistered.setOpaque(false);
		buttonRegistered.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new RegisteredInterface();
			}
		});
		
		
		buttonConfirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int ok = 0;
				String inputName = fieldUsername.getText(); 
				String inputPassword = String.valueOf(fieldPassword.getPassword());
				Vector <Vector <String>> user = RegisteredInterface.getUserInfoFromTxt("D://课程设计//用户注册信息//用户信息.txt");
				System.out.println(inputName.length() + " " + inputPassword.length());
				System.out.println(inputName + " "  + inputPassword);
				
				for (int i = 0; i < user.size(); i++) {
					Vector <String> now = user.get(i);
					String nameNow = now.elementAt(0);
					String passNow = now.elementAt(1);
					System.out.println(nameNow.length() + " " + passNow.length());
					System.out.println(nameNow + " " + passNow);
					if (nameNow.equals(inputName) && passNow.equals(inputPassword)) {
						ok = 1;
						dispose();
						userName = inputName;
						System.out.println("-----" + userName + "-------");
						thisThread = new myThread(userName);
						break;
					}
				}
				
				if (ok == 0) {
					JOptionPane.showMessageDialog(null, "账户名/密码 错误");
				}
			}
		});
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main (String str[]) {
		getLoginInterface();
	}
}
