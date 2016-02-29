package UI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class showListOfZhiHu extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel panelmain[] = new JPanel[7];
	private myBackground panel[] = new myBackground[55];
	
	public showListOfZhiHu() {
		this.setOpaque(false);
		panel[0] = new myBackground("Button.png", 288, 200, "GMC" + String.valueOf(0), "Zhi", 0);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 18; j++) {
				if (i == 0) {
					String path = "D://课程设计//知乎爬虫_今日推荐//知乎_编辑推荐_Problem" + String.valueOf(j) + "_title.txt";
					System.out.println(path);
					String title = getStringFromTxt.GetStringFromTxt(path);
					panel[18 * i + j + 1] = new myBackground("Button.png", 
												288, 200, title, "via www.zhihu.com", 0);
					Font f = new Font("仿宋", Font.BOLD, 14);
					panel[18 * i + j + 1].setFont(f);
					panel[18 * i + j + 1].setForeground(Color.PINK);
				} else if (i == 1){
					String path = "D://课程设计//豆瓣爬虫_电影推荐//title" + String.valueOf(j*10) + ".txt";
					System.out.println(path);
					String title = getStringFromTxt.GetStringFromTxt(path);
					panel[18 * i + j + 1] = new myBackground("Button.png", 
												288, 200, title, "via www.douban.com", 1);
					Font f = new Font("仿宋", Font.BOLD, 14);
					panel[18 * i + j + 1].setFont(f);
					panel[18 * i + j + 1].setForeground(Color.WHITE);
				} else if (i == 2) {
					String page = "段子 Page" + String.valueOf(j);
					panel[18 * i + j + 1] = new myBackground("Button.png", 
							288, 200, page, "via www.qiushibaike.com", 1);
					Font f = new Font("仿宋", Font.BOLD, 14);
					panel[18 * i + j + 1].setFont(f);
					panel[18 * i + j + 1].setForeground(Color.lightGray);
				}
			}
		}
		
		for(int i = 0; i < 7; i++){
			panelmain[i] = new JPanel();
		}
		this.setPreferredSize(new Dimension(827, 1200));//8550
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		showAllButton();
		
	}

	public void showAllButton() {
		/*
		 * 显示所有的button
		 * 
		 * */
		
		for (int i = 1; i <= 6; i++)
			panelmain[i].setLayout(new BorderLayout());
		addsmallPanel(0);
		
		for (int i = 1; i <= 6; i++)
			add(panelmain[i]);
		addPanelFunc();
		
	}
	public void addsmallPanel(int s) {
		System.out.println("hahaha");
		int width = 270;
		System.out.println("add ");
		for (int i = 1; i <= 18; i++) {
			int r = (i - 1) / 3 + 1;
			if(i % 3 == 1){
				panel[i+18*s].setPreferredSize(new Dimension(width, 0));
				panelmain[r].add(panel[i+18*s], BorderLayout.WEST);
			}
			else if(i % 3 == 2) {
				panelmain[r].add(panel[i+18*s], BorderLayout.CENTER);
			}
			else {
				panel[i+18*s].setPreferredSize(new Dimension(width, 0));
				panelmain[r].add(panel[i+18*s], BorderLayout.EAST);
			}
			System.out.print(i+18*s + " ");
		}
		for (int i = 1; i <= 6; i++) {
			panelmain[i].validate();
			panelmain[i].repaint();
		}
		System.out.println();
	}
	public void removePanel(int c) {
//		for(int i = 1; i <= 6; i++){
//			for(int j = 1; j < 56; j++){
//				panelmain[i].remove(panel[j]);
//			}
//		}
		System.out.println("remove ");
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 3; j++) {
				int ind = j+(i-1)*3 + c * 18;
				System.out.print(ind +" ");
				panelmain[i].remove(panel[ind]);
			}
			
		}
	}
	private void addPanelFunc(){
		for(int i = 1; i <= 54; i++){
			int k = (i - 1) / 18 + 1;
			int a = (i - 1) % 18 + 1;
			System.out.println(k + " " + a);
			int x = i;
			panel[i].addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					int type = 0;
					if (x >= 1 && x <= 18) type = 1;
					if (x >= 19 && x <= 36) type = 2;
					if (x >= 37 && x <= 54) type = 3;
					int num = a - 1;
					if (type == 2)
						num = num * 10;
					new newFrame(k, a, num, type);//最后一个是panel的高度
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {}
			});
		}
	}

}
