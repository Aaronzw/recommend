package UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class myPopJpanelOfDouban extends JPanel {

	/**
	 * Create the panel.
	 */
	private String title;
	private String rate;	
	private String data;
	private String des;
	
	private int width;
	private int height;
	private int num;

	public myPopJpanelOfDouban(String _title, String _des, String _data, String _rate,
								int _width, int _height, int _num) {
		this.title = _title;
		this.rate = _rate;
		this.data = _data;
		this.des = _des;
		this.width = _width;
		this.height = _height;
		this.num = _num;
	}
	// width : 160
	public void paintComponent(Graphics g){
//		setLocation(getLocationOnScreen());
		ImageIcon icon = new ImageIcon("日志.jpg");
		g.drawImage(icon.getImage(), 0, 0, width, height, icon.getImageObserver());
		
    	ImageIcon icon1 = new ImageIcon("D://课程设计//豆瓣爬虫_电影推荐//Pic" + String.valueOf(num) + ".jpg");
		g.drawImage(icon1.getImage(), 0, 0, 150, 200, icon1.getImageObserver());
    	
		
		g.drawString("名字：", 190, 50);
		g.drawString(title, 240, 50);
		
		g.drawString("时间：", 190, 110);
		g.drawString(data, 240, 110);
		
		g.drawString("评分：", 190, 170);
		g.drawString(rate, 240, 170);
		
		g.drawString("电影简述：", 70, 280);
		int _begin = 280;
		String out = "";
		int numH = 0, numE = 0;
		for (int i = 0; i < des.length(); i ++) {
			
			out += des.charAt(i);
			if (isAlp(des.charAt(i))) {
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
		}
		
		if (des.length() == 0) {
			g.drawString("无", 160, _begin);
			_begin += 25;
		}
		
		
	}
	
	private boolean isAlp(char s) {
		if(s >= 'a' && s <= 'z')
			return true;
		if (s >= 'A' && s <= 'Z')
			return true;
		return false;
	}
	
	private int min(int x, int y) {
		if (x > y)
			return y;
		return x;
	}

}
