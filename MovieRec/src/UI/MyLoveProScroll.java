package UI;

import javax.swing.JScrollPane;

public class MyLoveProScroll extends JScrollPane{
	private String path;
	MyLoveProPanel listOfZhiHu;
	
	
	public MyLoveProScroll(String path, String userName) {
		this.path = path;
		listOfZhiHu = new MyLoveProPanel(750, 4000, path, userName);
		
		this.setViewportView(listOfZhiHu);

		this.setBounds(180, 72, 800, 630);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
	}
	
	public void removeAll(String userName) {
		this.remove(listOfZhiHu);
		listOfZhiHu = new MyLoveProPanel(750, 4000, path, userName);
		this.setViewportView(listOfZhiHu);
	}
}
