package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class popFrameOfMovie extends JFrame{
	
	public popFrameOfMovie(String path, String name, String rate, String time,
						   String download, String url) {
		this.setSize(new Dimension(610, 730));
		int windowWidth = this.getWidth();                     //获得窗口宽
		int windowHeight = this.getHeight();                   //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
		int screenWidth = screenSize.width;                     //获取屏幕的宽
		int screenHeight = screenSize.height;                   //获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
    	getContentPane().setLayout(null);
    	
    	this.setLayout(null);
    	
    	openTheWorld view = new openTheWorld(path + "//Poster_" + name + ".jpg", 
    										200, 300);
    	view.setBounds(0, 0, 200, 300);
    	view.setVisible(true);
    	this.add(view);
    	
    	openTheWorld screen = new openTheWorld(path + "//Screen_" + name + ".jpg", 
				600, 400);
    	screen.setBounds(0, 300, 600, 400);
    	this.add(screen);
    	
    	JTextArea movieNameTextArea = new JTextArea("影名    ：" + name);
    	Font font = new Font("华文行楷", 0, 17);
    	movieNameTextArea.setOpaque(false);
    	movieNameTextArea.setFont(font);
    	movieNameTextArea.setBounds(220, 20, 300, 30);
    	movieNameTextArea.setForeground(Color.BLACK);
    	movieNameTextArea.setLineWrap(true);
    	movieNameTextArea.setEditable(false);
		this.add(movieNameTextArea);
		
		JTextArea movieRateTextArea = new JTextArea("豆瓣评分 ：" + rate);
    	font = new Font("华文行楷", 0, 17);
    	movieRateTextArea.setOpaque(false);
    	movieRateTextArea.setFont(font);
    	movieRateTextArea.setBounds(220, 50, 300, 30);
    	movieRateTextArea.setForeground(Color.BLACK);
    	movieRateTextArea.setLineWrap(true);
    	movieRateTextArea.setEditable(false);
		this.add(movieRateTextArea);
		
		JTextArea movieTimeTextArea = new JTextArea("发行时间 ：" + time);
    	font = new Font("华文行楷", 0, 17);
    	movieTimeTextArea.setOpaque(false);
    	movieTimeTextArea.setFont(font);
    	movieTimeTextArea.setBounds(220, 80, 300, 50);
    	movieTimeTextArea.setForeground(Color.BLACK);
    	movieTimeTextArea.setLineWrap(true);
    	movieTimeTextArea.setEditable(false);
		this.add(movieTimeTextArea);
		
		JTextArea movieDownloadTextArea = new JTextArea("下载链接 ：" + download);
    	font = new Font("华文行楷", 0, 17);
    	movieDownloadTextArea.setOpaque(false);
    	movieDownloadTextArea.setFont(font);
    	movieDownloadTextArea.setBounds(220, 130, 300, 80);
    	movieDownloadTextArea.setForeground(Color.BLACK);
    	movieDownloadTextArea.setLineWrap(true);
    	movieDownloadTextArea.setEditable(false);
		this.add(movieDownloadTextArea);
		
		JTextArea movieUrlTextArea = new JTextArea("来源链接 ：" + url);
    	font = new Font("华文行楷", 0, 17);
    	movieUrlTextArea.setOpaque(false);
    	movieUrlTextArea.setFont(font);
    	movieUrlTextArea.setBounds(220, 210, 300, 100);
    	movieUrlTextArea.setForeground(Color.BLACK);
    	movieUrlTextArea.setLineWrap(true);
    	movieUrlTextArea.setEditable(false);
		this.add(movieUrlTextArea);
	}
}
