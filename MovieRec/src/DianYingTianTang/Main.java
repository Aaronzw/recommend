package DianYingTianTang;

import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import UI.getStringFromTxt;

public class Main {
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
		
		Vector <String> nameOfMovieIntxt = getStringFromTxt.GetStringFromTxToVector("D://课程设计//电影天堂//最新电影//AllMovie.txt");
		for (int i = 0; i < nameOfMovieIntxt.size(); i++) {
			nameOfMovie.put(nameOfMovieIntxt.get(i), "true");
		}
		
		Vector <Thread> thread = new Vector<Thread>();
		allMovie = new Vector <Vector <MovieTianTang>>();
		NewMovie []newmovie = new NewMovie[10];
		
		for (int i = 0; i < 10; i++) {
			String url = "http://www.ygdy8.net/html/gndy/dyzz/list_23_" + 
					 String.valueOf(i + 1) + ".html";
			newmovie[i] = new NewMovie(url);
		}

		for (int i = 1; i <= 10; i++){
			thread.addElement(new Thread(newmovie[i - 1]));
			thread.elementAt(i - 1).start();
		}
		// 阻塞进程
		for (int i = 0; i < 10; i++) {
			try {
				thread.elementAt(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Url Ok");
		thread.clear();
		for (int i = 0; i < 10; i++) {
			thread.addElement(new Thread(new downLoadPhoto(allMovie.get(i), "D://课程设计//电影天堂//最新电影")));
			thread.elementAt(i).start();
		}
		
		for (int i = 0; i < 10; i++) {
			thread.elementAt(i).join();
		}
		System.out.println("download Ok");
		
		
		
//		for (int i = 1; i <= 10; i++) {
//			
//			System.out.println("###################" + i);
//			f.addElement(pool.submit(new NewMovie(url)));
//			System.out.println("@@@@@@@@@@@@@@@@@@@" + i);
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			pool.submit(GetMovieByUrl.downLoadAllPic((Vector<MovieTianTang>) f.get(i).get(), "最新电影"));
//		}
		
//		Vector <MovieTianTang> newMovie = NewMovie.newMovie();
//		Vector <MovieTianTang> ChinaMovie = GetMovieByUrl.getMovieByUrl("http://www.ygdy8.net/html/gndy/china/list_4_");
//		Vector <MovieTianTang> OuMeiMovie = GetMovieByUrl.getMovieByUrl("http://www.ygdy8.net/html/gndy/oumei/list_7_");
//		Vector <MovieTianTang> RiHanMovie = GetMovieByUrl.getMovieByUrl("http://www.ygdy8.net/html/gndy/rihan/list_6_");
//		System.out.println("ok");
//		GetMovieByUrl.downLoadAllPic(newMovie, "最新电影");
//		GetMovieByUrl.downLoadAllPic(ChinaMovie, "中国电影");
//		GetMovieByUrl.downLoadAllPic(OuMeiMovie, "欧美电影");
//		GetMovieByUrl.downLoadAllPic(RiHanMovie, "日韩电影");
//		System.out.println("end");
	}
	
	public static void add(Vector <MovieTianTang> q) {
		allMovie.addElement(q);
	}
}
