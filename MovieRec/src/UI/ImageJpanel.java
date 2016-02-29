package UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private String path;
	private int width;
	private int height;
	
	public ImageJpanel(String path, int width, int height) {
		//bk.jpg是指背景图片的名称，现在我使用的是相对路径即当前路径
		this.path = path;
		this.width = width;
		this.height = height;
	} 
	 
	//绘制背景图片 我们需要覆盖paintComponent(Graphics g)方法(重载)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon(path);
    	Image imageZhiHu1 = icon.getImage().getScaledInstance(width, 
    						height, icon.getImage().SCALE_DEFAULT);
    	ImageIcon iconZhiHu1 = new ImageIcon(imageZhiHu1);
		//四个参数分别代表 图片 绘制的开始点横坐标 纵坐标 绘制到哪儿 
		g.drawImage(imageZhiHu1, 0, 0, this);
		//也可以使用更多的参数 来进一步控制绘制的 图片大小
	}
}
