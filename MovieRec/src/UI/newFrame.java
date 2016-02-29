package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class newFrame{
	private static JFrame frame = new JFrame();
	private JScrollPane scrollPane;
	private String str[] = {"", "知乎推荐", "新闻推荐", "我的收藏"};
	
	
	newFrame(int j, int i, int num, int type){
		if (type == 1) {
			String path_title = "D://课程设计//知乎爬虫_今日推荐//" + "知乎_编辑推荐_Problem" + String.valueOf(num) + "_title.txt";
			String title = getStringFromTxt.GetStringFromTxt(path_title);
			
			String path_Des = "D://课程设计//知乎爬虫_今日推荐//" + "知乎_编辑推荐_Problem" + String.valueOf(num) + "_Des.txt";
			String Des = getStringFromTxt.GetStringFromTxt(path_Des);
			
			String path_Ans = "D://课程设计//知乎爬虫_今日推荐//" + "知乎_编辑推荐_Problem" + String.valueOf(num) + "_Answer.txt";
			String Ans = getStringFromTxt.GetStringFromTxt(path_Ans);
			int panelSizeY = (getH(title) + getH(Des) + getH(Ans)) * 30;
			
			frame = new JFrame();
			frame.setResizable(false);	
			frame.setSize(800, 800);
			JPanel panelMain = new myPopJpanelOfZhihu(title, Des, Ans, panelSizeY);
			panelMain.setPreferredSize(new Dimension(0, panelSizeY));
			panelMain.setForeground(Color.WHITE);
			Font font = new Font("楷体", Font.BOLD, 18);
			panelMain.setFont(font);
			
			scrollPane = new JScrollPane(panelMain);
			frame.add(scrollPane);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else if (type == 2) {
			String path_title = "D://课程设计//豆瓣爬虫_电影推荐//title" + String.valueOf(num) + ".txt";
			String title = getStringFromTxt.GetStringFromTxt(path_title);
			
			String path_Des = "D://课程设计//豆瓣爬虫_电影推荐//Des" + String.valueOf(num) + ".txt";
			String Des = getStringFromTxt.GetStringFromTxt(path_Des);
			
			String path_Data = "D://课程设计//豆瓣爬虫_电影推荐//Data" + String.valueOf(num) + ".txt";
			String Data = getStringFromTxt.GetStringFromTxt(path_Data);
			
			String path_Rate = "D://课程设计//豆瓣爬虫_电影推荐//Rate" + String.valueOf(num) + ".txt";
			String Rate = getStringFromTxt.GetStringFromTxt(path_Rate);
			
			int panelSizeY = max((getH(path_title) + getH(path_Des) + getH(path_Data) + getH(path_Rate)) * 30 + 500, 800);
			
			frame = new JFrame();
			frame.setResizable(false);
			frame.setSize(800, 800);
			JPanel panelMain = new myPopJpanelOfDouban(title, Des, Data, Rate, 800, panelSizeY, num);
			panelMain.setPreferredSize(new Dimension(0, panelSizeY));
			panelMain.setForeground(Color.WHITE);
			Font font = new Font("楷体", Font.BOLD, 18);
			panelMain.setFont(font);
			
			scrollPane = new JScrollPane(panelMain);
			frame.add(scrollPane);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else if (type == 3) {
			String [] path_Des = new String[30];
			String [] Des = new String[30];
			for (int k = 0; k < 20; k++) {
				path_Des[k] = (String) ("D://课程设计//糗事爬虫_今日推荐//糗事百科" + String.valueOf(num * 18 + k) + ".txt");
				Des[k] = getStringFromTxt.GetStringFromTxt(path_Des[k]);
			}
			
			int panelSizeY = 800;
			int sum = 1000;
			for (int k = 0; k < 20; k++) {
				sum += getH(Des[k]) * 30 + 10;
			}
			panelSizeY = max(panelSizeY, sum);
			
			frame = new JFrame();
			frame.setResizable(false);	
			frame.setSize(800, 800);
			JPanel panelMain = new myPopJpanelOfQiushi(Des, 800, panelSizeY, num);
//			JPanel panelMain = new myPopJpanelOfDouban(title, Des, Data, Rate, 800, panelSizeY, num);
			panelMain.setPreferredSize(new Dimension(0, panelSizeY));
			panelMain.setForeground(Color.WHITE);
			Font font = new Font("楷体", Font.BOLD, 18);
			panelMain.setFont(font);
			
			scrollPane = new JScrollPane(panelMain);
			frame.add(scrollPane);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	private int max(int i, int j) {
		if (i > j)
			return i;
		return j;
	}

	int getH(String s) {
		int len = s.length();
		return len / 27;
	}
}
