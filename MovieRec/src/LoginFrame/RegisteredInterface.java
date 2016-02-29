package LoginFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ZhiHu.FileReaderWriter;

public class RegisteredInterface extends JDialog {
	private static final long serialVersionUID = 1L;
	private myBackgroundPanel panelMain;
	private JLabel labelUsername;
	private JLabel labelPasswordCofirm;
	private JLabel labelName;
	private JLabel labelSex;
	private JLabel labelNumber;
	private JLabel labelCollege;
	private JLabel labelMajor;
	private JLabel labelPassword;
	private JTextField fieldUsername;
	private JTextField fieldName;
	private JTextField fieldNumber;
	private JTextField fieldCollege;
	private JTextField fieldMajor;
	private JPasswordField fieldPassword;
	private JPasswordField fieldPasswordConfirm;
	private JButton buttonConfirm;
	private JButton buttonCancel;
	private ButtonGroup buttonSex = new ButtonGroup();
	private JRadioButton buttonMale = new JRadioButton("男");
	private JRadioButton buttonFamale = new JRadioButton("女");
	private JComboBox<String> comboBoxCollege = new JComboBox<String>();
	private JComboBox<String> comboBoxMajor = new JComboBox<String>();
	private Vector<String> collegeContent = new Vector<String>();
	private Vector<Vector<String>> majorContent = new Vector<Vector<String>>();

	public RegisteredInterface() {
		setTitle("注册");
		setModal(true);
		addJComboBoxContent();
		BuildPanel();
		this.add(panelMain);
		this.setSize(280, 500);
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		this.setResizable(false);
		this.setLocation(screenSize.width / 2, screenSize.height / 4);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	private void addJComboBoxContent(){
		getComponent.setComboBox(comboBoxCollege, comboBoxMajor, collegeContent, majorContent);
		addJComboBoxFunc();
	}
	private void addJComboBoxFunc(){
		
		comboBoxCollege.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index = comboBoxCollege.getSelectedIndex();
				panelMain.remove(comboBoxMajor);
				comboBoxMajor = new JComboBox<String>(majorContent.get(index));
				comboBoxMajor.setPreferredSize(new Dimension(135, 30));
				panelMain.add(comboBoxMajor, new myGridBagLayout(1, 7, 2, 1).set_Fill(myGridBagLayout.NONE)
						.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
				panelMain.validate();
				panelMain.repaint();
			}
		});
	}
	
	private void BuildPanel() {
		
		panelMain = new myBackgroundPanel("RigistPage.jpg", 280, 450);
		panelMain.setLayout(new GridBagLayout());
		addLabel();
		addField();
		addButton();
	}

	private void addLabel() {
		labelUsername = new JLabel("用户名");
		labelPassword = new JLabel("密 码");
		labelPasswordCofirm = new JLabel("确认密码");
		labelName = new JLabel("姓名");
		labelSex = new JLabel("性别");
		labelNumber = new JLabel("学号");
		labelCollege = new JLabel("学院");
		labelMajor = new JLabel("专业");
		
		labelUsername.setFont(new Font("宋体", Font.BOLD, 15));
		labelPassword.setFont(new Font("宋体", Font.BOLD, 15));
		labelPasswordCofirm.setFont(new Font("宋体", Font.BOLD, 15));
		labelName.setFont(new Font("宋体", Font.BOLD, 15));
		labelSex.setFont(new Font("宋体", Font.BOLD, 15));
		labelNumber.setFont(new Font("宋体", Font.BOLD, 15));
		labelCollege.setFont(new Font("宋体", Font.BOLD, 15));
		labelMajor.setFont(new Font("宋体", Font.BOLD, 15));

		panelMain.add(labelUsername, new myGridBagLayout(0, 0).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
		panelMain.add(labelPassword, new myGridBagLayout(0, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
		panelMain.add(labelPasswordCofirm, new myGridBagLayout(0, 2).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
		panelMain.add(labelName, new myGridBagLayout(0, 3).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
		panelMain.add(labelSex, new myGridBagLayout(0, 4).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
		panelMain.add(labelNumber, new myGridBagLayout(0, 5).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
		panelMain.add(labelCollege, new myGridBagLayout(0, 6).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
		panelMain.add(labelMajor, new myGridBagLayout(0, 7).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 0, 10, 10));
	}

	private void addField() {
		
		fieldUsername = new JTextField(12);
		fieldUsername.setFont(new Font("宋体", Font.BOLD, 15));
		fieldPassword = new JPasswordField(12);
		fieldPassword.setEchoChar('*');
		fieldPassword.setFont(new Font("宋体", Font.BOLD, 15));
		fieldPasswordConfirm = new JPasswordField(12);
		fieldPasswordConfirm.setEchoChar('*');
		fieldPasswordConfirm.setFont(new Font("宋体", Font.BOLD, 15));
		fieldName = new JTextField(12);
		fieldName.setFont(new Font("宋体", Font.BOLD, 15));
		fieldNumber = new JTextField(12);
		fieldNumber.setFont(new Font("宋体", Font.BOLD, 15));
		fieldCollege = new JTextField(12);
		fieldCollege.setFont(new Font("宋体", Font.BOLD, 15));
		fieldMajor = new JTextField(12);
		fieldMajor.setFont(new Font("宋体", Font.BOLD, 15));

		panelMain.add(fieldUsername, new myGridBagLayout(1, 0, 2, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
		panelMain.add(fieldPassword, new myGridBagLayout(1, 1, 2, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
		panelMain.add(fieldPasswordConfirm, new myGridBagLayout(1, 2, 2, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
		panelMain.add(fieldName, new myGridBagLayout(1, 3, 2, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
		panelMain.add(fieldNumber, new myGridBagLayout(1, 5, 2, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
		panelMain.add(comboBoxCollege, new myGridBagLayout(1, 6, 2, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
		panelMain.add(comboBoxMajor, new myGridBagLayout(1, 7, 2, 1).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));

		fieldUsername.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					fieldPassword.requestFocus();
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
		fieldPassword.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					fieldPasswordConfirm.requestFocus();
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
		fieldPasswordConfirm.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					fieldName.requestFocus();
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		fieldName.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buttonMale.requestFocus();
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
	}

	private void addButton() {
		buttonConfirm = new JButton("确认");
		buttonCancel = new JButton("取消");
		buttonConfirm.setFont(new Font("宋体", Font.BOLD, 13));
		buttonCancel.setFont(new Font("宋体", Font.BOLD, 13));
		getComponent.setButtonGroup(buttonSex, buttonMale, buttonFamale);

		panelMain.add(buttonConfirm, new myGridBagLayout(0, 8).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(20, 10, 10, 0));
		panelMain.add(buttonCancel, new myGridBagLayout(2, 8).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(20, 10, 10, 10));
		panelMain.add(buttonMale, new myGridBagLayout(1, 4).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 0));
		panelMain.add(buttonFamale, new myGridBagLayout(2, 4).set_Fill(myGridBagLayout.NONE)
				.set_Anchor(myGridBagLayout.CENTER).setInset(10, 10, 10, 10));
		
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getUsername = fieldUsername.getText();
				String getPassword = String.valueOf(fieldPassword.getPassword());
				String getPasswordConfirm = String.valueOf(fieldPasswordConfirm.getPassword());
				String getName = fieldName.getText();
				String getNumber = fieldNumber.getText();
				String getCollege = String.valueOf(comboBoxCollege.getSelectedItem());
				String getMajor = String.valueOf(comboBoxMajor.getSelectedItem());
				String getSex;
				if(buttonMale.isSelected()) getSex = "男";
				else getSex = "女";
				if(getUsername.equals("admin")){
					JOptionPane.showMessageDialog(null, "该用户名不可使用！");
					return;
				}
				int Status;//用来保存状态
				
				Vector <String> newUser = new Vector<String>();
				newUser.addElement(getUsername); newUser.addElement(getPassword);
				newUser.addElement(getName);     newUser.addElement(getNumber);
				newUser.addElement(getCollege);  newUser.addElement(getMajor);
				newUser.addElement(getSex);
				
				Status = FilterInformation.FilterUsername(getUsername);
				switch (Status) {
					case 0:
						JOptionPane.showMessageDialog(null, "请输入用户名！");
						break;
					case 1:
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "用户名字符只包含字母数字下划线！");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "用户名太短！");
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "用户名太长！");
						break;
					default:
						JOptionPane.showMessageDialog(null, "未知错误！");
						break;
				}
				if(Status != 1) return;
				
				Status = FilterInformation.FilterPassword(getPassword, getPasswordConfirm);

				switch (Status) {
					case 0:
						JOptionPane.showMessageDialog(null, "请输入密码！");
						break;
					case 1:
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "密码中含有非法字字符！");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "密码太短！");
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "密码太长！");
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "请输入确认密码！");
						break;
					case 6:
						JOptionPane.showMessageDialog(null, "两次输入密码不一致！");
						break;
					default:
						JOptionPane.showMessageDialog(null, "未知错误！");
						break;
				}
				if(Status != 1) return;
				
				if(!FilterInformation.FilterNumber(getNumber)){
					JOptionPane.showMessageDialog(null, "学号格式不正确！");
					return;
				}
				if(!FilterInformation.FilterName(getName)){
					JOptionPane.showMessageDialog(null, "名字格式不正确！");
					return;
				}
				
				Vector <Vector<String>> q = getUserInfoFromTxt("D://课程设计//用户注册信息//用户信息.txt");
	            
	            //用户名 密码 性别 姓名 学号 学院 专业 
				
//	            System.out.println(q.size());
	            for (int i = 0; i < q.size(); i++) {
	            	Vector <String> now = new Vector<String>();
	            	now = q.get(i);
	            	String _user = now.get(0);
	            	String _number = now.get(4);
	            	if (_user == getUsername) {
	            		JOptionPane.showMessageDialog(null, "用户名已存在！");
						return;
	            	}
	            	if (_number == getNumber) {
	            		JOptionPane.showMessageDialog(null, "该学号已存在！");
						return;
	            	}
	            }
				
	            //D://课程设计//用户注册信息//用户信息.txt
	            FileReaderWriter.writeIntoFileVector(newUser, "D://课程设计//用户注册信息//用户信息.txt", true);
				dispose();
				JOptionPane.showMessageDialog(null, "注册成功！");
			}
		});
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public static Vector <Vector <String>> getUserInfoFromTxt(String path) {
		Vector <Vector<String>> q = new Vector <Vector<String>>();
		
		String encoding = "utf-8";
        File file = new File(path);
        if (file.isFile() && file.exists()) { //判断文件是否存在
            InputStreamReader read = null;
			try {
				read = new InputStreamReader(
						new FileInputStream(file), encoding);
			} catch (UnsupportedEncodingException | FileNotFoundException e1) {
				e1.printStackTrace();
			}//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            try {
				while((lineTxt = bufferedReader.readLine()) != null){
					Vector <String> now = new Vector<String>();
					String word = "";
					for (int j = 0; j < lineTxt.length(); j++) {
						if (lineTxt.charAt(j) == ' ') {
							now.addElement(word);
							word = "";
						} else {
							word += lineTxt.charAt(j);
						}
					}
					if (word != "") now.addElement(word);
					q.addElement(now);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            try {
				read.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
		return q;
	}
}
