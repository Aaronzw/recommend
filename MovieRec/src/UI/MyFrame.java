package UI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame implements Runnable {
	public MyFrame() {
	}
	private ImageJpanel imageJpanel;
	private int whichbutton;
	private MainPage mainPage;
	private JFrame jFrameIndex;
	private ZhiHuScroll jScrollPaneSce;
	private ZhiHuScroll jScrollPaneRec;
	private ZhiHuScroll jScrollPaneList;
	private ZhiHuScroll jScrollPaneCom;
	private ZhiHuScroll jScrollPaneTV;
	private ZhiHuScroll jScrollPaneWork;
	private MyLoveProScroll jScrollPaneMyLovePro;
	
	private MovieScroll jScrollPaneChina;
	private MovieScroll jScrollPaneOumei;
	private MovieScroll jScrollPaneRihan;
	private MovieScroll jScrollPaneNew;
	private MyLoveMovieScroll jScrollPaneMyLoveMovie;
	private String userName;
	
	private JButton setInfoFrom;
	
	private JButton add1;
	private JButton add2;
	private JButton add3;
	private JButton add4;
	private JButton recommand;
	
	private int now = 1;
	
	private JButton _time;
	private JTextArea timeArea;
	
	public void setNow(int x) {
		this.now = x;
	}
	
	
	public MyFrame(String userName) {
		this.userName = userName;
	}
    
    
    public void initial() {
    	jFrameIndex = this;
    	imageJpanel = new ImageJpanel("MainPage5.jpg", 995, 700);
    	

    	
 
    	
    	JButton logo = new JButton("Open The World");
    	logo.setBounds(0, 0, 150, 72);
    	ImageIcon icon = new ImageIcon("logo6.jpg");
    	Image imageZhiHu1 = icon.getImage().getScaledInstance(logo.getWidth()+13, 
    			logo.getHeight(), icon.getImage().SCALE_DEFAULT);
    	ImageIcon iconZhiHu1 = new ImageIcon(imageZhiHu1);
//    	logo.setContentAreaFilled(false);
//		logo.setBorderPainted(false);
    	logo.setIcon(iconZhiHu1);
    	logo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				mainPage.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
    	getContentPane().add(logo);

    	JButton exit = new JButton("Exit");
    	exit.setBounds(975, 0, 30, 25);
    	icon = new ImageIcon("exit3.jpg");
    	Image exitImage = icon.getImage().getScaledInstance(exit.getWidth()-5, 
    				      exit.getHeight(), icon.getImage().SCALE_DEFAULT);
    	ImageIcon iconExit = new ImageIcon(exitImage);
    	exit.setIcon(iconExit);
    	
    	exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
    	getContentPane().add(exit);
		
		
    	/*
    	 * 十万个为什么按钮控制区
    	 * */
		JButton lotsOfQue = new JButton("十万个为什么");
		Font f = new Font("华文行楷", Font.BOLD, 20);
		lotsOfQue.setHorizontalAlignment(JButton.LEFT);
		lotsOfQue.setFont(f);
		lotsOfQue.setBounds(0, 70, 200, 72);
		lotsOfQue.setForeground(Color.white);
		lotsOfQue.setContentAreaFilled(false);
		lotsOfQue.setBorderPainted(false);
		jScrollPaneSce.setVisible(false);
		lotsOfQue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jScrollPaneSce.removeAll(userName);
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				mainPage.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				jScrollPaneSce.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
		
		
		getContentPane().add(lotsOfQue);
		this.setVisible(true);
		/*
		 * 电影推荐按钮控制区
		 * */
		JButton MovieRec = new JButton("电影推荐");
		f = new Font("华文行楷", Font.BOLD, 17);
		MovieRec.setHorizontalAlignment(JButton.RIGHT);
		MovieRec.setFont(f);
		MovieRec.setBounds(0, 142, 130, 30);
		MovieRec.setForeground(Color.WHITE);
		MovieRec.setContentAreaFilled(false);
		MovieRec.setBorderPainted(false);
		jScrollPaneRec.setVisible(false);
		getContentPane().add(MovieRec);
		MovieRec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneRec.removeAll(userName);
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				jScrollPaneRec.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();				
			}
		});
		
		/*
		 * 电影台词控制区
		 * */
		JButton MovieList = new JButton("电影台词");
		f = new Font("华文行楷", Font.BOLD, 17);
		MovieList.setHorizontalAlignment(JButton.RIGHT);
		MovieList.setFont(f);
		MovieList.setBounds(0, 172, 130, 30);
		MovieList.setForeground(Color.WHITE);
		MovieList.setContentAreaFilled(false);
		MovieList.setBorderPainted(false);
		jScrollPaneList.setVisible(false);
		getContentPane().add(MovieList);
		
		MovieList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneList.removeAll(userName);
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				jScrollPaneList.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
		
		/*
		 * 电影评论控制区
		 * */
		JButton MovieCom = new JButton("电影评论");
		f = new Font("华文行楷", Font.BOLD, 17);
		MovieCom.setHorizontalAlignment(JButton.RIGHT);
		MovieCom.setFont(f);
		MovieCom.setBounds(0, 202, 130, 30);
		MovieCom.setForeground(Color.WHITE);
		MovieCom.setContentAreaFilled(false);
		MovieCom.setBorderPainted(false);
		getContentPane().add(MovieCom);
		jScrollPaneCom.setVisible(false);
		MovieCom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneCom.removeAll(userName);
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				jScrollPaneCom.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
		
		/*
		 * 电影审查控制区
		 * */
		JButton MovieSce = new JButton("电影审查");
		f = new Font("华文行楷", Font.BOLD, 17);
		MovieSce.setHorizontalAlignment(JButton.RIGHT);
		MovieSce.setFont(f);
		MovieSce.setBounds(0, 232, 130, 30);
		MovieSce.setForeground(Color.WHITE);
		MovieSce.setContentAreaFilled(false);
		MovieSce.setBorderPainted(false);
		jScrollPaneSce.setVisible(false);
		getContentPane().add(MovieSce);
		MovieSce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneSce.removeAll(userName); 
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				jScrollPaneSce.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
		
		/*
		 * 电影频道按钮控制区
		 * */
		JButton MovieTV = new JButton("电影频道");
		f = new Font("华文行楷", Font.BOLD, 17);
		MovieTV.setHorizontalAlignment(JButton.RIGHT);
		MovieTV.setFont(f);
		MovieTV.setBounds(0, 262, 130, 30);
		MovieTV.setForeground(Color.WHITE);
		MovieTV.setContentAreaFilled(false);
		MovieTV.setBorderPainted(false);
		jScrollPaneTV.setVisible(false);
		getContentPane().add(MovieTV);
		MovieTV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneTV.removeAll(userName); 
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				jScrollPaneTV.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
		
		/*
		 * 电影作品按钮控制区
		 * */
		JButton MovieWork = new JButton("电影作品");
		f = new Font("华文行楷", Font.BOLD, 17);
		MovieWork.setHorizontalAlignment(JButton.RIGHT);
		MovieWork.setFont(f);
		MovieWork.setBounds(0, 292, 130, 30);
		MovieWork.setForeground(Color.WHITE);
		MovieWork.setContentAreaFilled(false);
		MovieWork.setBorderPainted(false);
		jScrollPaneWork.setVisible(false);
		getContentPane().add(MovieWork);
		MovieWork.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneWork.removeAll(userName);               //
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				jScrollPaneWork.setVisible(true);
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
		
		JButton downLoad = new JButton("下  载  专  区");
		f = new Font("华文行楷", Font.BOLD, 20);
		downLoad.setHorizontalAlignment(JButton.LEFT);
		downLoad.setFont(f);
		downLoad.setBounds(0, 332, 200, 72);
		downLoad.setForeground(Color.white);
		downLoad.setContentAreaFilled(false);
		downLoad.setBorderPainted(false);
		
		getContentPane().add(downLoad);
		
		downLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneNew.update();
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(true);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				
				repaint();
				
			}
		});
		
		jScrollPaneChina.setVisible(false);
		jScrollPaneRihan.setVisible(false);
		jScrollPaneOumei.setVisible(false);
		jScrollPaneNew.setVisible(false);
		JButton ChinaMovie = new JButton("中国电影");
		f = new Font("华文行楷", Font.BOLD, 17);
		ChinaMovie.setHorizontalAlignment(JButton.RIGHT);
		ChinaMovie.setFont(f);
		ChinaMovie.setBounds(0, 404, 130, 30);
		ChinaMovie.setForeground(Color.WHITE);
		ChinaMovie.setContentAreaFilled(false);
		ChinaMovie.setBorderPainted(false);
		getContentPane().add(ChinaMovie);
		
		ChinaMovie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneChina.update();
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				
				jScrollPaneChina.setVisible(true);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				
				repaint();
			}
		});
		
		JButton RiHanMovie = new JButton("日韩电影");
		f = new Font("华文行楷", Font.BOLD, 17);
		RiHanMovie.setHorizontalAlignment(JButton.RIGHT);
		RiHanMovie.setFont(f);
		RiHanMovie.setBounds(0, 432, 130, 30);
		RiHanMovie.setForeground(Color.WHITE);
		RiHanMovie.setContentAreaFilled(false);
		RiHanMovie.setBorderPainted(false);
		getContentPane().add(RiHanMovie);
		
		RiHanMovie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneRihan.update();
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(true);
				jScrollPaneMyLoveMovie.setVisible(false);
				
				repaint();
			}
		});
		
		JButton OuMeiMovie = new JButton("欧美电影");
		f = new Font("华文行楷", Font.BOLD, 17);
		OuMeiMovie.setHorizontalAlignment(JButton.RIGHT);
		OuMeiMovie.setFont(f);
		OuMeiMovie.setBounds(0, 462, 130, 30);
		OuMeiMovie.setForeground(Color.WHITE);
		OuMeiMovie.setContentAreaFilled(false);
		OuMeiMovie.setBorderPainted(false);
		getContentPane().add(OuMeiMovie);
		
		OuMeiMovie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneOumei.update();
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(true);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				
				repaint();
			}
		});
		
		JButton NewMovie = new JButton("最新电影");
		f = new Font("华文行楷", Font.BOLD, 17);
		NewMovie.setHorizontalAlignment(JButton.RIGHT);
		NewMovie.setFont(f);
		NewMovie.setBounds(0, 492, 130, 30);
		NewMovie.setForeground(Color.WHITE);
		NewMovie.setContentAreaFilled(false);
		NewMovie.setBorderPainted(false);
		getContentPane().add(NewMovie);
		
		NewMovie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneNew.update();
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
				
				jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(true);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				
				repaint();
			}
		});
		
		JButton MyLove = new JButton("我  的  收  藏");
		f = new Font("华文行楷", Font.BOLD, 20);
		MyLove.setHorizontalAlignment(JButton.LEFT);
		MyLove.setFont(f);
		MyLove.setBounds(0, 532, 200, 72);
		MyLove.setForeground(Color.white);
		MyLove.setContentAreaFilled(false);
		MyLove.setBorderPainted(false);
		getContentPane().add(MyLove);
		
		JButton que = new JButton("十万个为什么");
		f = new Font("华文行楷", Font.BOLD, 17);
		que.setHorizontalAlignment(JButton.RIGHT);
		que.setFont(f);
		que.setBounds(0, 604, 150, 30);
		que.setForeground(Color.WHITE);
		que.setContentAreaFilled(false);
		que.setBorderPainted(false);
		jScrollPaneMyLovePro.setVisible(false);
		getContentPane().add(que);
		que.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneMyLovePro.removeAll(userName);
				
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
		    	jScrollPaneMyLovePro.setVisible(true);
		    	
		    	jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
		    	repaint();
			}
		});
		
		JButton down = new JButton("下 载 专 区");
		f = new Font("华文行楷", Font.BOLD, 17);
		down.setHorizontalAlignment(JButton.RIGHT);
		down.setFont(f);
		down.setBounds(0, 634, 130, 30);
		down.setForeground(Color.WHITE);
		down.setContentAreaFilled(false);
		down.setBorderPainted(false);
		getContentPane().add(down);
		
		jScrollPaneMyLoveMovie.setVisible(false);
		down.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jScrollPaneMyLoveMovie.update(userName);
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
		    	jScrollPaneMyLovePro.setVisible(false);
		    	
		    	jScrollPaneChina.setVisible(false);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(true);
				repaint();
			}
		});
		
		recommand = new JButton("个 性 化 推 荐");
		recommand.setBounds(0, 650, 200, 72);
		f = new Font("华文行楷", Font.BOLD, 20);
		recommand.setHorizontalAlignment(JButton.LEFT);
		recommand.setFont(f);
		recommand.setForeground(Color.white);
		recommand.setContentAreaFilled(false);
		recommand.setBorderPainted(false);
		this.add(recommand);
		recommand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jScrollPaneMyLoveMovie.update(userName);
				jScrollPaneSce.setVisible(false);
				jScrollPaneRec.setVisible(false);
				jScrollPaneList.setVisible(false);
				jScrollPaneCom.setVisible(false);
				jScrollPaneTV.setVisible(false);
				jScrollPaneWork.setVisible(false);
				jScrollPaneMyLovePro.setVisible(false);
				mainPage.setVisible(false);
		    	jScrollPaneMyLovePro.setVisible(false);
		    	
		    	jScrollPaneChina.setVisible(true);
				jScrollPaneOumei.setVisible(false);
				jScrollPaneNew.setVisible(false);
				jScrollPaneRihan.setVisible(false);
				jScrollPaneMyLoveMovie.setVisible(false);
				repaint();
			}
		});
		
		
		/*
		 * 自定义拖动
		 * */
		MouseEventListener mouseListener = new MouseEventListener(this);
	    this.addMouseListener(mouseListener);
	    this.addMouseMotionListener(mouseListener);
		
		/*
		 * 背景设置
		 * 
		 * 
		 * */
    	this.setTitle("Open The World");
//    	this.setSize(1000,600);
    	this.setResizable(false);
    	//this.setUndecorated(false);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the page
    	this.setLocationRelativeTo(this);					  
    	Container c = this.getContentPane();
    	c.setLayout(null);
    	
    	imageJpanel.setBounds(0, 0, this.getWidth(), this.getHeight());
    	c.add(imageJpanel);
	    this.setVisible(true);
    }
    

	@Override
	public void run() {
		whichbutton = 0;
//    	setSize(new Dimension(1000, 628));
		setSize(new Dimension(995, 700));
//		setSize(new Dimension(995, 800));
		this.setUndecorated(true);
		int windowWidth = this.getWidth();                     //获得窗口宽
		int windowHeight = this.getHeight();                   //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
		int screenWidth = screenSize.width;                     //获取屏幕的宽
		int screenHeight = screenSize.height;                   //获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
    	getContentPane().setLayout(null);
    	
    	/*
		 * 设置MainPage
		 * */
		mainPage = new MainPage(845, 700);
		mainPage.setBounds(150, 0, 845, 670);
		getContentPane().add(mainPage);
		
		jScrollPaneSce = new ZhiHuScroll("D://课程设计//知乎爬虫//电影审查.txt", userName);
    	getContentPane().add(jScrollPaneSce);
    	
    	jScrollPaneRec = new ZhiHuScroll("D://课程设计//知乎爬虫//电影推荐.txt", userName);
    	getContentPane().add(jScrollPaneRec);
    	
    	jScrollPaneList = new ZhiHuScroll("D://课程设计//知乎爬虫//电影台词.txt", userName);
    	getContentPane().add(jScrollPaneList);
    	
    	jScrollPaneCom = new ZhiHuScroll("D://课程设计//知乎爬虫//电影评论.txt", userName);
    	getContentPane().add(jScrollPaneCom);
    	
    	jScrollPaneTV = new ZhiHuScroll("D://课程设计//知乎爬虫//电影频道.txt", userName);
    	getContentPane().add(jScrollPaneTV);
    	
    	jScrollPaneWork = new ZhiHuScroll("D://课程设计//知乎爬虫//电影作品.txt", userName);
    	getContentPane().add(jScrollPaneWork);
    	
    	jScrollPaneMyLovePro = new MyLoveProScroll("D://课程设计//用户信息//admin", userName);
    	getContentPane().add(jScrollPaneMyLovePro); 
    	
    	jScrollPaneChina = new MovieScroll("D://课程设计//电影天堂//中国电影", userName);
    	getContentPane().add(jScrollPaneChina);
    	
    	jScrollPaneRihan = new MovieScroll("D://课程设计//电影天堂//日韩电影", userName);
    	getContentPane().add(jScrollPaneRihan);
    	
    	jScrollPaneOumei = new MovieScroll("D://课程设计//电影天堂//欧美电影", userName);
    	getContentPane().add(jScrollPaneOumei);
    	
    	jScrollPaneNew = new MovieScroll("D://课程设计//电影天堂//最新电影", userName);
    	getContentPane().add(jScrollPaneNew);
    	
    	jScrollPaneMyLoveMovie = new MyLoveMovieScroll("D://课程设计//用户信息//admin", userName);
    	getContentPane().add(jScrollPaneMyLoveMovie);
    	initial();
	}
    
}
