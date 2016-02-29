package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import ZhiHu.FileReaderWriter;

public class MyLoveThisMoviePanel extends JPanel{

	private String path; // 路径到文件夹
	private int type;
	private String userName;
	
	private String movieName;
	private String movieRate;
	private String downLoadPath;
	private String openPath;
	private String movieType;
	private String movieTime;
	
	private JButton choose;
	private ImageIcon iconChoose;
	private ImageIcon iconNotChoose;
	private String screenImage;
	
	public String getMovieTime() {
		return movieTime;
	}
	
	public String getRate() {
		return movieRate;
	}
	
	public String getName() {
		return movieName;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		System.out.println(type);
		this.type = type;
		if (type == 0)
			this.choose.setIcon(iconNotChoose);
		else
			this.choose.setIcon(iconChoose);
	}
	
	public MyLoveThisMoviePanel(String path, String name, int x, int y, int type, String userName) {
		this.setLayout(null);
		this.setOpaque(false);
		this.path = path;
		this.type = type;
		this.userName = userName;
		this.setBounds(x, y, 350, 300);
		
		choose = new JButton();
		choose.setBounds(220, 30, 25, 25);
		choose.setBorderPainted(false);
    	choose.setContentAreaFilled(false);
    	
    	screenImage = path + "//" + name + ".jpg";
//		System.out.println("MyLove" + " " + screenImage);
		iconNotChoose = new ImageIcon("NotChoose.png");
		Image image = iconNotChoose.getImage().getScaledInstance(choose.getWidth(), 
    			choose.getHeight(), iconNotChoose.getImage().SCALE_DEFAULT);
		
		iconChoose = new ImageIcon("Choose.png");
		Image image2 = iconChoose.getImage().getScaledInstance(choose.getWidth(), 
    			choose.getHeight(), iconChoose.getImage().SCALE_DEFAULT);
		
		if (type == 1)
    		choose.setIcon(iconChoose);
    	else
    		choose.setIcon(iconNotChoose);
		this.add(choose);
		
		Vector <String> info = getStringFromTxt.GetStringFromTxToVector(path + "//" + name + ".txt");
		
		movieName = info.get(0);
		downLoadPath = info.get(1);
		openPath = info.get(2);
		movieRate = getStringFromTxt.GetStringFromTxt(path + "//" + name + "_Rate.txt");
		movieType = getStringFromTxt.GetStringFromTxt(path + "//" + name + "_Type.txt");
		movieTime = getStringFromTxt.GetStringFromTxt(path + "//" + name + "_Time.txt");
		
//		System.out.println("backGround    " + path + "//Poster_" + movieName +".jpg");
		openTheWorld scrPanel = new openTheWorld(path + "//Poster_" + movieName +".jpg", 200, 300);
		scrPanel.setBounds(0, 0, 200, 300);
		scrPanel.setVisible(true);
		scrPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				popFrameOfMovie movie = new popFrameOfMovie(path, movieName, movieRate, movieTime, 
						downLoadPath, openPath);
				movie.setVisible(true);
			}
		});
		this.add(scrPanel);
		
		
		JTextArea movieNameTextArea = new JTextArea(movieName);
    	Font font = new Font("华文行楷", 0, 17);
    	movieNameTextArea.setOpaque(false);
    	movieNameTextArea.setFont(font);
    	movieNameTextArea.setBounds(220, 100, 100, 50);
    	movieNameTextArea.setForeground(Color.YELLOW);
    	movieNameTextArea.setLineWrap(true);
    	movieNameTextArea.setEditable(false);
		this.add(movieNameTextArea);
		
		JTextArea movieRateTextArea = new JTextArea(movieRate + "分");
    	font = new Font("华文行楷", 0, 17);
    	movieRateTextArea.setOpaque(false);
    	movieRateTextArea.setFont(font);
    	movieRateTextArea.setBounds(220, 170, 100, 50);
    	movieRateTextArea.setForeground(Color.YELLOW);
    	movieRateTextArea.setLineWrap(true);
    	movieRateTextArea.setEditable(false);
		this.add(movieRateTextArea);
		
		JTextArea movieTimeTextArea = new JTextArea(movieTime);
    	font = new Font("华文行楷", 0, 17);
    	movieTimeTextArea.setOpaque(false);
    	movieTimeTextArea.setFont(font);
    	movieTimeTextArea.setBounds(220, 240, 100, 100);
    	movieTimeTextArea.setForeground(Color.YELLOW);
    	movieTimeTextArea.setLineWrap(true);
    	movieTimeTextArea.setEditable(false);
		this.add(movieTimeTextArea);
		
		choose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int type2 = getType();
				if (type2 == 0)
					choose.setIcon(iconChoose);
				else
					choose.setIcon(iconNotChoose);
				String ProblemPath = "D://课程设计//用户信息//" + userName + "//" + "download.txt";
				if (type2 == 0)
					FileReaderWriter.writeIntoFile(path + "//" + getName() + ".txt" + "1" + "\r\n", ProblemPath, true);
				if (type2 == 1)
					FileReaderWriter.writeIntoFile(path + "//" + getName() + ".txt" + "0" + "\r\n", ProblemPath, true);
//				System.out.println(which);
				setType(1 - type2);
			}
		});
	}
	
	
	
}
