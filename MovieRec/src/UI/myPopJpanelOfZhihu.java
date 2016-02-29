package UI;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class myPopJpanelOfZhihu extends JPanel {
	
	private String title;
	private String des;
	private String answer;
	private int width;
	private int height;

	public myPopJpanelOfZhihu(String _title, String _des, String _answer, int height) {
		this.width = 800;
		this.height = height;
		this.title = _title;
		this.des = _des;
		this.answer = _answer;
	}
	// width : 160
	public void paintComponent(Graphics g){
		ImageIcon icon = new ImageIcon("日志.jpg");
		g.drawImage(icon.getImage(), 0, 0, width, height, icon.getImageObserver());
//		g.drawString(title, 80, 30);
		g.drawString("问题：", 110, 30);
		if (title.length() > 30) {
			int num1 = title.length() / 2;
			int num2 = title.length();
			String title1 = title.substring(0, num1);
			String title2 = title.substring(num1, num2);
			
			g.drawString(title1, 160, 30);
			g.drawString(title2, 160, 50);
		} else {
			g.drawString(title, 160, 30);
		}
		//27字一行
		g.drawString("问题描述：", 70, 90);
		int _begin = 90;
		for (int i = 0; i < des.length(); i += 27) {
			g.drawString(des.substring(i, min(des.length(), i + 27)), 160, _begin);
			_begin += 25;
		}
		
		if (des.length() == 0) {
			g.drawString("无", 160, _begin);
			_begin += 25;
		}
		
		
		_begin += 25;
		g.drawString("最佳回答：", 70, _begin);
		
//		for (int i = 0; i < answer.length(); i += 27) {
//			g.drawString(answer.substring(i, min(answer.length(), i + 27)), 160, _begin);
//			_begin += 25;
//		}
		
		String out = "";
		int numH = 0, numE = 0;
		for (int i = 0; i < answer.length(); i ++) {
			
			out += answer.charAt(i);
			if (isAlp(answer.charAt(i))) {
				numE ++;
			} else {
				numH ++;
			}
			if ((numE / 2 + numH)  >= 27) {
				
				g.drawString(out, 180, _begin);
				_begin += 25;
				numE = 0; numH = 0;
				out = "";
			}
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
