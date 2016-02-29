package UI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class myBackgroundPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private String imgPath;
	private int width;
	private int height;
	
	public myBackgroundPanel(String imgPath, int width, int height){
		this.imgPath = imgPath;
		this.width = width;
		this.height = height;
	}
	public void paintComponent(Graphics g){
		ImageIcon icon = new ImageIcon(imgPath);
		g.drawImage(icon.getImage(), 0, 0, width, height, icon.getImageObserver());
	}
}
