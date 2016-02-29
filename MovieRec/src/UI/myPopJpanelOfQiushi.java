package UI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class myPopJpanelOfQiushi extends JPanel {
	String [] des = new String[30];
	int width;
	int height;
	int num;
	public myPopJpanelOfQiushi(String []Des, int _width, int _height, int _num) {
		des = Des;
		width = _width;
		height = _height;
		num = _num;
	}
	public void paintComponent(Graphics g){
		ImageIcon icon = new ImageIcon("日志.jpg");
		g.drawImage(icon.getImage(), 0, 0, width, height, icon.getImageObserver());
		int _begin = 30;
		for (int j = 0; j < 18; j++) {
			g.drawString(String.valueOf(j) + " :", 130, _begin);
			String out = "";
			int numH = 0, numE = 0;
			for (int i = 0; i < des[j].length(); i ++) {
				
				out += des[j].charAt(i);
				if (isAlp(des[j].charAt(i))) {
					numE ++;
				} else {
					numH ++;
				}
	//			System.out.println(numE + " " + numH);
				if ((numE / 2 + numH)  >= 25) {
					
					g.drawString(out, 180, _begin);
					_begin += 25;
					numE = 0; numH = 0;
					out = "";
				}
			}
			
			if (out != "") {
				g.drawString(out, 180, _begin);
				_begin += 25;
			}
			
			if (des[j].length() == 0) {
				g.drawString("无", 160, _begin);
				_begin += 25;
			}
			_begin += 50;
		}
	}
	
	private boolean isAlp(char s) {
		if(s >= 'a' && s <= 'z')
			return true;
		if (s >= 'A' && s <= 'Z')
			return true;
		return false;
	}
	
}
