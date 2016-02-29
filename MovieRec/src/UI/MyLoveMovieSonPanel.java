package UI;

import java.awt.Dimension;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import ZhiHu.FileReaderWriter;

public class MyLoveMovieSonPanel extends JPanel{
	private int width;
	private int height;
	private String path;
	private String userName;
	private Vector <MyLoveThisMoviePanel> allPanel;
	private HashMap <String, String> hash;
	private Vector <String> allChoose;
	private int sortByWhat;
	String []outMovie = new String[1000];
	String [] nameByRate = new String[100];
	String [] nameByTime = new String[100];
	
	String [] Rate = new String[100];
	String [] Time = new String[100];

	public MyLoveMovieSonPanel(int width, int height, String path, String userName, int sortByWhat) {
		this.width = width;
		this.height = height;
		this.path = path;
		this.userName = userName;
		this.sortByWhat = sortByWhat;
		this.setBounds(0, 30, width, height);
		this.setLayout(null);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, height));
		
		allPanel = new Vector<MyLoveThisMoviePanel>();
		
		if (!(new File("D://课程设计//用户信息//" + userName).isDirectory())) {
			new File("D://课程设计//用户信息//" + userName).mkdir();
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "download.txt");
			FileReaderWriter.createNewFile("D://课程设计//用户信息//" + userName + "//" + "problem.txt");
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "download.txt", false);
			FileReaderWriter.writeIntoFile("--------------" + "\r\n", "D://课程设计//用户信息//" + userName + "//" + "problem.txt", false);
		}
		
		hash = new HashMap<String, String>();
		
		
		//hash的是具体文件的链接
		allChoose = getStringFromTxt.GetStringFromTxToVector("D://课程设计//用户信息//" + userName + "//" + "download.txt");
		Vector <String> allMoviePath = new Vector<String>();
		for (int i = 1; i < allChoose.size(); i++) {
			String subString = "";
			String okOrNot = "";
			subString = allChoose.get(i).substring(0, allChoose.get(i).length() - 1);
			allMoviePath.add(subString);
			int ok = allChoose.get(i).charAt(allChoose.get(i).length() - 1) - '0';
			if (ok == 1)
				hash.put(subString, "true");
			else
				hash.put(subString, "false");
		}
		Vector <String> allMovie = new Vector<String>();
		
		HashMap <String, String> nameToPath = new HashMap<String, String>();
		for (int i = 0; i < allMoviePath.size(); i++) {
			String thisMoviePath = allMoviePath.get(i);
			if (hash.get(thisMoviePath) == "true") {
				Vector <String> movieInfo = getStringFromTxt.GetStringFromTxToVector(thisMoviePath);
				allMovie.add(movieInfo.get(0));
				hash.put(thisMoviePath, "false");
				//System.out.println("nameToPath" + "   " + movieInfo.get(0) + " " + thisMoviePath.substring(0, 20));
				nameToPath.put(movieInfo.get(0), thisMoviePath.substring(0, 20));
			}
		}
		
		
		
		
		
		
		for (int i = 0; i < allMovie.size() && i < 40; i++) {
			String nameMovie = allMovie.get(i);
			String pathMovie = nameToPath.get(nameMovie);
			System.out.println(pathMovie + "//" + allMovie.get(i) + "_Rate.txt");
			Rate[i] = getStringFromTxt.GetStringFromTxt(pathMovie + "//" + allMovie.get(i) + "_Rate.txt");
			Time[i] = getStringFromTxt.GetStringFromTxt(pathMovie + "//" + allMovie.get(i) + "_Time.txt");
		}
		
		for (int i = 0; i < allMovie.size() && i < 40; i++) {
			outMovie[i] = allMovie.get(i);
//			System.out.println(outMovie[i]);
		}
		
		if (sortByWhat == 1) {

			for (int i = 0; i < allMovie.size() && i < 40; i++) {
				String maxv = Rate[i];
				for (int j = i + 1; j < allMovie.size() && j < 40; j++) {
					String find = Rate[j];
					if (maxv.compareTo(find) < 0) {
						maxv = find;
						String mid = Rate[i];
						Rate[i] = Rate[j];
						Rate[j] = mid;
						mid = outMovie[i];
						outMovie[i] = outMovie[j];
						outMovie[j] = mid;
					}
				}
			}
			System.out.println(allMovie.size());
			System.out.println("Rate===========================");
			for (int i = 0; i < allMovie.size(); i++) {
				System.out.println(Rate[i]);
			}
		} else {
			
			for (int i = 0; i < allMovie.size() && i < 40; i++) {
				String maxv = Time[i];
				for (int j = i + 1; j < allMovie.size() && j < 40; j++) {
					String find = Time[j];
					if (maxv.compareTo(find) < 0) {
						maxv = find;
						String mid = Time[i];
						Time[i] = Time[j];
						Time[j] = mid;
						mid = outMovie[i];
						outMovie[i] = outMovie[j];
						outMovie[j] = mid;
					}
				}
			}
		}
		
		for (int i = 0; i < 40 && i < allMovie.size(); i++) {
			int x = 0, y = 0;
			if ((i & 1) == 0) {
				x = 50; y = 20 + i / 2 * 400;
			} else {
				x = 420; y = 20 + i / 2 * 400;
			}
			
			allPanel.add(new MyLoveThisMoviePanel(nameToPath.get(outMovie[i]), outMovie[i], x, y, 1, userName));
		}
		
		for (int i = 0; i < 40 && i < allPanel.size(); i++) {
			this.add(allPanel.get(i));
			System.out.println(allPanel.get(i).getRate());
		}
	}
	
public void update() {
		
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
		
		hash.clear();
		
		System.out.println("here" + "   " + allChoose.size());
		//hash的是具体文件的链接
		allChoose = getStringFromTxt.GetStringFromTxToVector("D://课程设计//用户信息//" + userName + "//" + "download.txt");
		HashMap <String, String> nameToPath = new HashMap<String, String>();
		for (int i = 1; i < allChoose.size(); i++) {
			String subString = "";
			String okOrNot = "";
			subString = allChoose.get(i).substring(0, allChoose.get(i).length() - 1);
			System.out.println(subString + "address");
			int ok = allChoose.get(i).charAt(allChoose.get(i).length() - 1) - '0';
			outMovie[i - 1] = getStringFromTxt.GetStringFromTxToVector(subString).get(0);
			nameToPath.put(outMovie[i - 1], allChoose.get(i).substring(0, 22));
			if (ok == 1)
				hash.put(subString, "true");
			else
				hash.put(subString, "false");
		}
		
		int ans = 0;
		
		for (int i = 0; i < 40 && i < allChoose.size(); i++) {
			String title = nameToPath.get(outMovie[i]) + outMovie[i] +".txt";
			System.out.println("this" + title + " " + hash.get(title));
			if (hash.get(title) == "true") {
				int x = 0, y = 0;
				if ((i & 1) == 0) {
					x = 50; y = 20 + ans / 2 * 400;
				} else {
					x = 420; y = 20 + ans / 2 * 400;
				}
				if (allPanel.size() < ans) {
					allPanel.add(new MyLoveThisMoviePanel(nameToPath.get(outMovie[i]), outMovie[i], x, y, 1, userName));
				}
				allPanel.get(i).setType(1);
				hash.put(title, "false");
			}
		}
		
		for (int i = 0; i < allPanel.size(); i++) {
			allPanel.get(i).setVisible(true);
			this.add(allPanel.get(i));
		}
	}
}
