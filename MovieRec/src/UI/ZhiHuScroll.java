package UI;

import javax.swing.JScrollPane;

public class ZhiHuScroll extends JScrollPane{
	
	public String path;
	public ZhiHuPanel listOfZhiHu;
	
	public ZhiHuScroll(String path, String userName) {
		this.path = path;
		listOfZhiHu = new ZhiHuPanel(750, 4000, path, userName);
		
		this.setViewportView(listOfZhiHu);

		this.setBounds(180, 72, 800, 630);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
	}
	
	public void removeAll(String userName) {
		
		listOfZhiHu.update();
		listOfZhiHu.validate();
		listOfZhiHu.repaint();
		this.setViewportView(listOfZhiHu);
	}
}
