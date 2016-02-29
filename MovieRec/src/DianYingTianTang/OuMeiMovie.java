package DianYingTianTang;

import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import UI.getStringFromTxt;

public class OuMeiMovie {
	private static Vector <Vector <MovieTianTang>> allMovie;
	private static HashMap <String, String> nameOfMovie;
	
	static boolean isExist(String name) {
		if (nameOfMovie.get(name) == "true") 
			return true;
		return false;
	}
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		/*
		 * NewMovie download
		 * 
		 * */
		
		nameOfMovie = new HashMap <String, String> ();
		
		Vector <String> nameOfMovieIntxt = getStringFromTxt.GetStringFromTxToVector("D://课程设计//电影天堂//欧美电影//AllMovie.txt");
		for (int i = 0; i < nameOfMovieIntxt.size(); i++) {
			nameOfMovie.put(nameOfMovieIntxt.get(i), "true");
		}
		
		Vector <Thread> thread = new Vector<Thread>();
		allMovie = new Vector <Vector <MovieTianTang>>();
		GetMovieByUrl []newmovie = new GetMovieByUrl[10];
		
		for (int i = 0; i < 10; i++) {
			String url = "http://www.ygdy8.net/html/gndy/oumei/list_7_" + 
					 String.valueOf(i + 1) + ".html";
			newmovie[i] = new GetMovieByUrl(url, 2);
		}

		for (int i = 1; i <= 10; i++){
			thread.addElement(new Thread(newmovie[i - 1]));
			thread.elementAt(i - 1).start();
		}
		// 阻塞进程
		for (int i = 0; i < 10; i++) {
			try {
				thread.elementAt(i).join();
				System.out.println(i + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Url Ok");
		thread.clear();
		System.out.println(allMovie.size());
		for (int i = 0; i < allMovie.size(); i++) {
			System.out.println(allMovie.get(i).size() + " &&&&&&&&&&&&&&&&&&");
			thread.addElement(new Thread(new downLoadPhoto(allMovie.get(i), "D://课程设计//电影天堂//欧美电影")));
			thread.elementAt(i).start();
		}
		
		for (int i = 0; i < 10; i++) {
			thread.elementAt(i).join();
		}
		
		
	}
	
	public static void add(Vector <MovieTianTang> q) {
		allMovie.addElement(q);
	}

}
