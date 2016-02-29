package UI;

import java.awt.Dimension;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import ZhiHu.FileReaderWriter;

public class MyLoveProPanel extends JPanel{
	private int width;
	private int height;
	private String path;
	private JButton text1;
	private Vector <String> allChoose;
	private HashMap <String, String> hash;
	
	public MyLoveProPanel(int width, int height, String path, String userName) {
		this.setLayout(null);
		this.setOpaque(false);
		this.width = width;
		this.height = height;
		this.path = path;
		this.setPreferredSize(new Dimension(width, height));
		
		Vector <thisQuePanel> allPanel = new Vector<thisQuePanel>();
		allPanel.clear();
		
		if (!(new File("D://课程设计//用户信息//" + userName).isDirectory())) {
			new File("D://课程设计//用户信息//" + userName).mkdir();
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "download.txt");
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "problem.txt");
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "download.txt", false);
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "problem.txt", false);
		}
		
		hash = new HashMap<String, String>();
		allChoose = new Vector<String>();
		allChoose.clear();
		hash.clear();
		
		allChoose = getStringFromTxt.GetStringFromTxToVector("D://课程设计//用户信息//" + userName + "//" + "problem.txt");
		System.out.println("------------------------------");
		for (int i = 1; i < allChoose.size(); i++) {
			String subString = "";
			String okOrNot = "";
			subString = allChoose.get(i).substring(0, allChoose.get(i).length() - 1);
			int ok = allChoose.get(i).charAt(allChoose.get(i).length() - 1) - '0';
			System.out.println(subString + " " + ok);
			if (ok == 1)
				hash.put(subString, "true");
			else
				hash.put(subString, "false");
		}
		System.out.println("--------------------------------");
		int ans = 1;
		HashMap<String, String> hasOut = new HashMap<String, String>();
		for (int i = 1; i < allChoose.size(); i++) {
			int len = allChoose.get(i).length();
			if (len <= 12)
				continue;
			int which = 0;
			which = allChoose.get(i).charAt(len - 6) - '0';
			if (len == 37) // 1位数
				which = (allChoose.get(i).charAt(len - 7) - '0') * 10 + which;
			
			String nowPath = allChoose.get(i).substring(0, 24);
			String proPath = allChoose.get(i).substring(0, len - 1);
			String ok = hash.get(proPath);
//			System.out.println(proPath + " " + ok);
			if (ok == "true" && hasOut.get(proPath) != "true") {
				allPanel.add(new thisQuePanel(nowPath, which, 50, 50 + 150 * (ans - 1), 1, userName));
				System.out.println(50 + 150 * (ans - 1));
				ans ++;
				hasOut.put(proPath, "true");
			}
		}
		System.out.println(allPanel.size());
		for (int i = 0; i < allPanel.size(); i++) {
			this.add(allPanel.get(i));
		}
		
	}
	
	public String getHash(String user) {
		return hash.get(user);
	}
}
