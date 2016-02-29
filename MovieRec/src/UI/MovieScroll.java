package UI;

import javax.swing.JScrollPane;

public class MovieScroll extends JScrollPane{
	
	public String path;
	public MoviePanel listOfMovie;
	
	public MovieScroll(String path, String userName) {
		this.path = path;
		listOfMovie = new MoviePanel(750, 8000, path, userName);
		
		this.setViewportView(listOfMovie);

		this.setBounds(180, 72, 800, 630);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
	}
	
	public void update() {
		listOfMovie.update();
		listOfMovie.validate();
		listOfMovie.repaint();
		this.setViewportView(listOfMovie);
	}
}
