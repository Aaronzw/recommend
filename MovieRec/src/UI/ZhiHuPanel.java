package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import ZhiHu.FileReaderWriter;

public class ZhiHuPanel extends JPanel{
	
	private int width;
	private int height;
	private String path;
	private JButton text1;
	private String userName;
	private Vector <String> allChoose;
	private HashMap <String, String> hash;
	private Vector <thisQuePanel> allPanel;
	
	public ZhiHuPanel(int width, int height, String path, String userName) {
		this.userName = userName;
		this.setLayout(null);
		this.setOpaque(false);
		this.width = width;
		this.height = height;
		this.path = path;
		this.setPreferredSize(new Dimension(width, height));
		
		allPanel = new Vector<thisQuePanel>();
		
		if (!(new File("D://课程设计//用户信息//" + userName).isDirectory())) {
			new File("D://课程设计//用户信息//" + userName).mkdir();
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "download.txt");
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "problem.txt");
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "download.txt", false);
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "problem.txt", false);
		}
		
		hash = new HashMap<String, String>();
		
		allChoose = getStringFromTxt.GetStringFromTxToVector("D://课程设计//用户信息//" + userName + "//" + "problem.txt");
		for (int i = 1; i < allChoose.size(); i++) {
			String subString = "";
			String okOrNot = "";
			subString = allChoose.get(i).substring(0, allChoose.get(i).length() - 1);
			int ok = allChoose.get(i).charAt(allChoose.get(i).length() - 1) - '0';
			if (ok == 1)
				hash.put(subString, "true");
			else
				hash.put(subString, "false");
		}
		
		for (int i = 0; i < 25; i++) {
			String title = path + "//" + "name" + String.valueOf(i + 1)+".txt";
			if (hash.get(title) == "true")
				allPanel.add(new thisQuePanel(path, i + 1, 50, 50 + 150 * i, 1, userName));
			else
				allPanel.add(new thisQuePanel(path, i + 1, 50, 50 + 150 * i, 0, userName));
			
		}
		
		for (int i = 0; i < 25; i++) {
			this.add(allPanel.get(i));
		}
		
	}
	
	public void update() {
//		allPanel = new Vector<thisQuePanel>();
//		for (int i = 0; i < allPanel.size(); i++) {
//			this.remove(allPanel.get(i));
//		}
		if (!(new File("D://课程设计//用户信息//" + userName).isDirectory())) {
			new File("D://课程设计//用户信息//" + userName).mkdir();
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "download.txt");
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "problem.txt");
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "download.txt", false);
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "problem.txt", false);
		}
		
		hash = new HashMap<String, String>();
		
		allChoose = getStringFromTxt.GetStringFromTxToVector("D://课程设计//用户信息//" + userName + "//" + "problem.txt");
		for (int i = 1; i < allChoose.size(); i++) {
			String subString = "";
			String okOrNot = "";
			subString = allChoose.get(i).substring(0, allChoose.get(i).length() - 1);
			int ok = allChoose.get(i).charAt(allChoose.get(i).length() - 1) - '0';
			if (ok == 1)
				hash.put(subString, "true");
			else
				hash.put(subString, "false");
		}
		
		for (int i = 0; i < 25; i++) {
			String title = path + "//" + "name" + String.valueOf(i + 1)+".txt";
			if (hash.get(title) == "true")
				allPanel.get(i).setType(1);
			else
				allPanel.get(i).setType(0);
		}
		
		for (int i = 0; i < allPanel.size(); i++) {
			this.add(allPanel.get(i));
		}
	}
	
	public String getHash(String user) {
		return hash.get(user);
	}

}
