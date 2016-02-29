package UI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainPage extends JPanel {
	private JPanel thisIndex;
	private int width;
	private int height;
	private int pos;
	
	private JButton left;
	private JButton right;
	openTheWorld mainPage1Mid;
	openTheWorld mainPage1Left;
	openTheWorld mainPage1Right;
	
	openTheWorld mainPage2Mid;
	openTheWorld mainPage2Left;
	openTheWorld mainPage2Right;
	
	openTheWorld mainPage3Mid;
	openTheWorld mainPage3Left;
	openTheWorld mainPage3Right;
	
	openTheWorld mainPage4Mid;
	openTheWorld mainPage4Left;
	openTheWorld mainPage4Right;
	
	openTheWorld mainPage5Mid;
	openTheWorld mainPage5Left;
	openTheWorld mainPage5Right;
	
	public int getPos() {
		return pos;
	}
	
	public void setPos(int x) {
		this.pos = x;
	}

	public MainPage(int width, int height) {
		thisIndex = this;
		this.pos = 1;
		this.setOpaque(false);
		this.width = width;
		this.height = height + 20;
		this.setBounds(0, 0, width, height);
		setLayout(null);
		
		left = new JButton();
		right = new JButton();
		left.setBounds(330, 640, 40, 30);
		right.setBounds(450, 640, 40, 30);
		
		
		ImageIcon icon = new ImageIcon("left.png");
    	Image imageZhiHu1 = icon.getImage().getScaledInstance(40, 
    			30, icon.getImage().SCALE_DEFAULT);
    	ImageIcon iconZhiHu1 = new ImageIcon(imageZhiHu1);
    	
    	left.setIcon(iconZhiHu1);
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pos = (pos - 1 + 5) % 5;
				Remove();
				Select(pos);
				repaint();
			}
		});
		this.add(left);
		
		icon = new ImageIcon("right.png");
    	imageZhiHu1 = icon.getImage().getScaledInstance(40, 
    			30, icon.getImage().SCALE_DEFAULT);
    	iconZhiHu1 = new ImageIcon(imageZhiHu1);
    	
    	right.setIcon(iconZhiHu1);
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pos = (pos + 1) % 5;
				Remove();
				Select(pos);
				repaint();
			}
		});
		this.add(right);
		
		

		mainPage1Mid = new openTheWorld("text1.jpg", 300, 570);
		mainPage1Mid.setBounds(250, 70, 450, 570);
		mainPage1Left = new openTheWorld("text1.jpg", 300, 370);
		
		mainPage1Left.setBounds(50, 150, 450, 370);
		mainPage1Right = new openTheWorld("text1.jpg", 300, 370);
		mainPage1Right.setBounds(450, 150, 450, 370);

		mainPage2Mid = new openTheWorld("text2.jpg", 300, 570);
		mainPage2Mid.setBounds(250, 70, 450, 570);
		mainPage2Left = new openTheWorld("text2.jpg", 300, 370);
		mainPage2Left.setBounds(50, 150, 450, 370);
		mainPage2Right = new openTheWorld("text2.jpg", 300, 370);
		mainPage2Right.setBounds(450, 150, 450, 370);

		mainPage3Mid = new openTheWorld("text3.jpg", 300, 570);
		mainPage3Mid.setBounds(250, 70, 450, 570);
		mainPage3Left = new openTheWorld("text3.jpg", 300, 370);
		mainPage3Left.setBounds(50, 150, 450, 370);
		mainPage3Right = new openTheWorld("text3.jpg", 300, 370);
		mainPage3Right.setBounds(450, 150, 450, 370);

		mainPage4Mid = new openTheWorld("text4.jpg", 300, 570);
		mainPage4Mid.setBounds(250, 70, 450, 570);
		mainPage4Left = new openTheWorld("text4.jpg", 300, 370);
		mainPage4Left.setBounds(50, 150, 450, 370);
		mainPage4Right = new openTheWorld("text4.jpg", 300, 370);
		mainPage4Right.setBounds(450, 150, 450, 370);

		mainPage5Mid = new openTheWorld("text5.jpg", 300, 570);
		mainPage5Mid.setBounds(250, 70, 450, 570);
		mainPage5Left = new openTheWorld("text5.jpg", 300, 370);
		mainPage5Left.setBounds(50, 150, 450, 370);
		mainPage5Right = new openTheWorld("text5.jpg", 300, 370);
		mainPage5Right.setBounds(450, 150, 450, 370);
		
		Select1();
	}
	

	
	public void Select(int i) {
		if (i == 0) Select1();
		if (i == 1) Select2();
		if (i == 2) Select3();
		if (i == 3) Select4();
		if (i == 4) Select5();
	}

	public void Select1() {
		add(mainPage1Mid);
		add(mainPage5Left);
		add(mainPage2Right);
	}
	
	public void Select2() {
		add(mainPage2Mid);
		add(mainPage1Left);
		add(mainPage3Right);
	}
	
	public void Select3() {
		add(mainPage3Mid);
		add(mainPage2Left);
		add(mainPage4Right);
	}
	
	public void Select4() {
		add(mainPage4Mid);
		add(mainPage3Left);
		add(mainPage5Right);
	}
	
	public void Select5() {
		add(mainPage5Mid);
		add(mainPage4Left);
		add(mainPage1Right);
	}
	
	public void Remove() {
//		if (i == 1) {
			remove(mainPage1Mid);
			remove(mainPage5Left);
			remove(mainPage2Right);
//		}
//		if (i == 2) {
			remove(mainPage2Mid);
			remove(mainPage1Left);
			remove(mainPage3Right);
//		}
//		if (i == 3) {
			remove(mainPage3Mid);
			remove(mainPage2Left);
			remove(mainPage4Right);
//		}
//		if (i == 4) {
			remove(mainPage4Mid);
			remove(mainPage3Left);
			remove(mainPage5Right);
//		}
//		if (i == 5) {
			remove(mainPage5Mid);
			remove(mainPage4Left);
			remove(mainPage1Right);
//		}
	}
	
	public void RemoveAll() {
		System.out.println("remove ");
		remove(mainPage1Mid);
		remove(mainPage5Left);
		remove(mainPage2Right);

		remove(mainPage2Mid);
		remove(mainPage1Left);
		remove(mainPage3Right);

		remove(mainPage3Mid);
		remove(mainPage2Left);
		remove(mainPage4Right);

		remove(mainPage4Mid);
		remove(mainPage3Left);
		remove(mainPage5Right);

		remove(mainPage5Mid);
		remove(mainPage4Left);
		remove(mainPage1Right);
		
		repaint();
	}
	
	public void addAll() {
		System.out.println("add ");
		add(mainPage1Mid);
		add(mainPage5Left);
		add(mainPage2Right);

		add(mainPage2Mid);
		add(mainPage1Left);
		add(mainPage3Right);

		add(mainPage3Mid);
		add(mainPage2Left);
		add(mainPage4Right);

		add(mainPage4Mid);
		add(mainPage3Left);
		add(mainPage5Right);

		add(mainPage5Mid);
		add(mainPage4Left);
		add(mainPage1Right);
		
		
		validate();
		repaint();
	}


}