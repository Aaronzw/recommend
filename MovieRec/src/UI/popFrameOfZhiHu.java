package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.crypto.spec.DESedeKeySpec;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class popFrameOfZhiHu extends JFrame{
	
	public popFrameOfZhiHu(String titlePath, String desPath, String ansPath) {
		this.setSize(new Dimension(800, 700));
		int windowWidth = this.getWidth();                     //获得窗口宽
		int windowHeight = this.getHeight();                   //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
		int screenWidth = screenSize.width;                     //获取屏幕的宽
		int screenHeight = screenSize.height;                   //获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
    	getContentPane().setLayout(null);
    	this.setLayout(null);
    	
    	String titleStr = getStringFromTxt.GetStringFromTxt(titlePath);
    	String desStr = getStringFromTxt.GetStringFromTxt(desPath);
    	String ansStr = getStringFromTxt.GetStringFromTxt(ansPath);
    	
    	JTextArea titleTextArea = new JTextArea(titleStr);
    	Font font = new Font("华文行楷", 0, 30);
    	titleTextArea.setOpaque(false);
    	titleTextArea.setFont(font);
    	titleTextArea.setBounds(100, 50, 600, 70);
    	titleTextArea.setForeground(Color.YELLOW);
    	titleTextArea.setLineWrap(true);
    	titleTextArea.setEditable(false);
		this.add(titleTextArea);
    	
		if (desStr != "") {
			JScrollPane desTextPane = new JScrollPane();
	    	desTextPane.setBounds(100, 150, 600, 80);
			JTextArea desTextArea = new JTextArea(desStr);
	    	font = new Font("华文行楷", 0, 20);
	    	desTextArea.setOpaque(false);
	    	desTextArea.setFont(font);
	    	desTextArea.setBounds(0, 0, 600, 1000);
	    	desTextArea.setForeground(Color.YELLOW);
	    	desTextArea.setLineWrap(true);
	    	desTextArea.setEditable(false);
	    	desTextPane.setOpaque(false);
	    	desTextPane.getViewport().setOpaque(false);
	    	desTextPane.setViewportView(desTextArea);
	    	desTextPane.setBorder(null);
			this.add(desTextPane);
		}
		
		JScrollPane ansTextPane = new JScrollPane();
		if (desStr != "") 
			ansTextPane.setBounds(100, 250, 600, 400);
		else
			ansTextPane.setBounds(100, 150, 600, 400);
		JTextArea ansTextArea = new JTextArea(ansStr);
    	font = new Font("华文行楷", 0, 20);
    	ansTextArea.setOpaque(false);
    	ansTextArea.setFont(font);
    	ansTextArea.setBounds(0, 0, 600, 1000);
    	ansTextArea.setForeground(Color.YELLOW);
    	ansTextArea.setLineWrap(true);
    	ansTextArea.setEditable(false);
    	ansTextPane.setOpaque(false);
    	ansTextPane.getViewport().setOpaque(false);
    	ansTextPane.setViewportView(ansTextArea);
    	ansTextPane.setBorder(null);
		this.add(ansTextPane);
		
		ImageJpanel imageJpanel = new ImageJpanel("MainPage2.jpg", this.getWidth(), this.getHeight());
		Container c = this.getContentPane();
    	c.setLayout(null);
    	
    	imageJpanel.setBounds(0, 0, this.getWidth(), this.getHeight());
    	c.add(imageJpanel);
	}
}
