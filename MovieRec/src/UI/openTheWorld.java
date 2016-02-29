package UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class openTheWorld extends JPanel{
	private String path;
	private int width;
	private int height;
	public openTheWorld(String path, int width, int height) {
		this.path = path;
		this.width = width;
		this.height = height;
	}
	
	public void paintComponent(Graphics g){
		ImageIcon icon = new ImageIcon(path);
		g.drawImage(icon.getImage(), 0, 0, width, height, icon.getImageObserver());
	}
}
