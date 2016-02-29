package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ZhiHu.FileReaderWriter;

public class thisQuePanel extends JPanel{
	
	private String path;
	private String userName;
	private int which;
	private int love;
	private int type;
	private JButton choose;
	private ImageIcon iconChoose;
	private ImageIcon iconNotChoose;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		System.out.println(type);
		this.type = type;
		if (type == 0)
			this.choose.setIcon(iconNotChoose);
		else
			this.choose.setIcon(iconChoose);
	}
	
	public thisQuePanel(String path, int which, int x, int y, int type, String userName) {
//		System.out.println(path + "   " + type);
		this.setLayout(null);
		this.setOpaque(false);
		this.path = path;
		this.which = which;
		this.type = type;
		this.userName = userName;
		this.setBounds(x, y, 600, 100);
		
		
		choose = new JButton();
		choose.setBounds(0, 0, 25, 25);
		
		iconNotChoose = new ImageIcon("NotChoose.png");
		Image image = iconNotChoose.getImage().getScaledInstance(choose.getWidth(), 
    			choose.getHeight(), iconNotChoose.getImage().SCALE_DEFAULT);
		
		iconChoose = new ImageIcon("Choose.png");
		Image image2 = iconChoose.getImage().getScaledInstance(choose.getWidth(), 
    			choose.getHeight(), iconChoose.getImage().SCALE_DEFAULT);
    	
    	
    	choose.setBorderPainted(false);
    	choose.setContentAreaFilled(false);
    	
    	if (type == 1)
    		choose.setIcon(iconChoose);
    	else
    		choose.setIcon(iconNotChoose);
		this.add(choose);
		
		String titleFi = getStringFromTxt.GetStringFromTxtTwoLine(path + "//" + "name" + String.valueOf(which)+".txt");
		String titleStr = "问题：   " + titleFi;
		Font font = new Font("华文行楷", 0, 20);
		JTextArea title = new JTextArea(titleStr);
		title.setOpaque(false);
		title.setFont(font);
		title.setBounds(50, 0, 600, 20);
		title.setForeground(Color.WHITE);
		title.setLineWrap(true);
		title.setEditable(false);
		this.add(title);
		
		String desStr = getStringFromTxt.GetStringFromTxtTwoLine(path + "//" + "Ans" + String.valueOf(which)+".txt");
		font = new Font("华文行楷", 0, 20);
		JTextArea des = new JTextArea(desStr);
		des.setOpaque(false);
		des.setFont(font);
		des.setBounds(0, 50, 450, 40);
		des.setForeground(Color.WHITE);
		des.setLineWrap(true);
		des.setEditable(false);
		this.add(des);
		
		JButton seeAll = new JButton("查看全部内容");
		seeAll.setBounds(450, 50, 150, 50);
		seeAll.setBorderPainted(false);
		seeAll.setContentAreaFilled(false);
		
		Font f = new Font("华文行楷", Font.BOLD, 17);
		seeAll.setHorizontalAlignment(JButton.RIGHT);
		seeAll.setFont(f);
		seeAll.setForeground(Color.YELLOW);
		this.add(seeAll);
		
		seeAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("litsen");
				popFrameOfZhiHu now = new popFrameOfZhiHu(path + "//" + "name" + String.valueOf(which)+".txt", 
									path + "//" + "Des" + String.valueOf(which)+".txt",
									path + "//" + "Ans" + String.valueOf(which)+".txt");
				
				now.setVisible(true);
			}
		});
		
		
		choose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int type2 = getType();
				if (type2 == 0)
					choose.setIcon(iconChoose);
				else
					choose.setIcon(iconNotChoose);
				String ProblemPath = "D://课程设计//用户信息//" + userName + "//" + "problem.txt";
				if (type2 == 0)
					FileReaderWriter.writeIntoFile(path + "//" + "name" + String.valueOf(which)+".txt" + "1" + "\r\n", ProblemPath, true);
				if (type2 == 1)
					FileReaderWriter.writeIntoFile(path + "//" + "name" + String.valueOf(which)+".txt" + "0" + "\r\n", ProblemPath, true);
				System.out.println(which);
				setType(1 - type2);
			}
		});
	}
}
