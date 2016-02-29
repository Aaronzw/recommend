package UI;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class myBackground extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private String imgPath;
	private int width;
	private int height; 
	private String title;
	private String From;
	private int Type;
	
	public myBackground(String imgPath, int width, int height, String _title, String _From, int _type){
		this.imgPath = imgPath;
		this.width = width;
		this.height = height;
		this.title = _title;
		this.From = _From;
		Type = _type;
	}
	
	/*
	 * titleX
	 * 		这一行标题的开始位置
	 * lenTitle
	 * 		这一行标题的长度
	 * 
	 * 返回这一行应该的起始位置使得标题显示在中间
	 * */
	
	public int returnX(int titleX, int lenTitle, int type) {
		int odd = 0;
		int up = 7, down = 8;
		if (type == 2) {
			up = 3; down = 4;
		}
		while (lenTitle >= 1) {
			if ((odd & 1) == 1)
				titleX -= up;
			else
				titleX -= down;
			odd++;
			lenTitle --;
		}
		return titleX;
	}
	
	public void paintComponent(Graphics g){
//		ImageIcon icon = new ImageIcon(imgPath);
//		g.drawImage(icon.getImage(), 0, 0, width, height, icon.getImageObserver());
		if (Type == 0) {
			int h = title.length() / 16;
			if (title.length() % 16 != 0)
				h++;
			int num1 = title.length() / h;
			int num2 = title.length() * 2 / h;
			int num3 = title.length();
			
			int titleX = 140, titleY = 80; //1个
			if (h == 1) {
				g.drawString(title, returnX(titleX, title.length(), 1), titleY - 8);
			} else if (h == 2) {
				String one = title.substring(0, num1);
				String two = title.substring(num1, num2);
				
				int lenOne = one.length();
				int lenTwo = two.length();
				int oneX = 140, oneY = 60;
				int twoX = 140, twoY = 80;
				
				g.drawString(one, returnX(oneX, lenOne, 1), oneY);
				g.drawString(two, returnX(twoX, lenTwo, 1), twoY);
			} else if (h == 3) {
				String one = title.substring(0, num1);
				String two = title.substring(num1, num2);
				String thr = title.substring(num2, num3);
				int lenOne = one.length();
				int lenTwo = two.length();
				int lenThr = thr.length();
				int oneX = 140, oneY = 60;
				int twoX = 140, twoY = 80;
				int thrX = 140, thrY = 100;
				
				g.drawString(one, returnX(oneX, lenOne, 1), oneY);
				g.drawString(two, returnX(twoX, lenTwo, 1), twoY);
				g.drawString(thr, returnX(thrX, lenThr, 1), thrY);
			}
			
	    	g.drawString(From, 60, 170);
		} else if (Type == 1) {
			int titleX = 140, titleY = 80; //1个
			int num1 = title.length();
			int ok = 0;
			for (int i = 0; i < title.length(); i++) {
				if (title.charAt(i) == ' ') {
					num1 = i;
					ok = 1;
					break;
				}
			}
			if (ok == 1) {
				String title1 = title.substring(0, num1);
				String title2 = title.substring(num1 + 1, title.length());
				g.drawString(title1, returnX(titleX, title1.length(), 1), titleY - 15);
				int type = 1;
				for (int i = 0; i < title2.length(); i++) {
					if (isAlph(title2.charAt(i))) {
						type = 2;
					}
				}
				System.out.println(type);
				g.drawString(title2, returnX(titleX, title2.length(), type), titleY);
			} else {
				g.drawString(title, returnX(titleX, title.length(), 1), titleY - 8);
			}
			
			g.drawString(From, 60, 170);
		} else if (Type == 2) {
			
		}
	}
	
	boolean isAlph(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return true;
		if (ch >= 'A' && ch <= 'Z')
			return true;
		return false;
	}
}