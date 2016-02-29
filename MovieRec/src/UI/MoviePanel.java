package UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import ZhiHu.FileReaderWriter;

public class MoviePanel extends JPanel{
	
	private int width;
	private int height;
	private String path;
	private String userName;
	private Vector <thisMoviePanel> allPanel;
	private HashMap <String, String> hash;
	private Vector <String> allChoose;
	private MovieSonPanel byTimePanel;
	private MovieSonPanel byRatePanel;

	public MoviePanel(int width, int height, String path, String userName) {
		this.width = width;
		this.height = height;
		this.path = path;
		this.userName = userName;
		this.setLayout(null);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, height));
		
		byTimePanel = new MovieSonPanel(width, height, path, userName, 2);
		byRatePanel = new MovieSonPanel(width, height, path, userName, 1);
		this.add(byRatePanel);
		this.add(byTimePanel);
		byTimePanel.setVisible(true);
		byRatePanel.setVisible(false);
		
		JButton sortByTime = new JButton("时间");
		sortByTime.setBounds(250, 0, 70, 20);
		sortByTime.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				byRatePanel.setVisible(false);
				byTimePanel.setVisible(true);
			}
		});
		
		JButton sortByRate = new JButton("评分");
		sortByRate.setBounds(350, 0, 70, 20);
		sortByRate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("listen");
				byRatePanel.setVisible(true);
				byTimePanel.setVisible(false);
			}
		});
		
		this.add(sortByTime);
		this.add(sortByRate);
	}
	
	public void update() {
		this.remove(byTimePanel);
		this.remove(byRatePanel);
		
		byTimePanel.update();
		byRatePanel.update();
		byTimePanel.validate();
		byRatePanel.validate();
		byRatePanel.repaint();
		byRatePanel.repaint();
		
		this.add(byRatePanel);
		this.add(byTimePanel);
	}

}
