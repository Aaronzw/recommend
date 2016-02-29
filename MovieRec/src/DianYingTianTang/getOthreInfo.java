package DianYingTianTang;

import java.util.Vector;

import DouBan.SearchInfoByName;

public class getOthreInfo {

	public static void main(String[] args) throws InterruptedException {
		
//		while (true) {
		Vector <Thread> now = new Vector<Thread>();
//		now.addElement(new Thread(new SearchInfoByName("D://课程设计//电影天堂//最新电影", "D://课程设计//电影天堂//最新电影//AllMovie.txt")));
//		now.addElement(new Thread(new SearchInfoByName("D://课程设计//电影天堂//欧美电影", "D://课程设计//电影天堂//欧美电影//AllMovie.txt")));
		now.addElement(new Thread(new SearchInfoByName("D://课程设计//电影天堂//日韩电影", "D://课程设计//电影天堂//日韩电影//AllMovie.txt")));
//		now.addElement(new Thread(new SearchInfoByName("D://课程设计//电影天堂//中国电影", "D://课程设计//电影天堂//中国电影//AllMovie.txt")));
		
		for (int i = 0; i < now.size(); i++) {
			now.get(i).start();
		}
		
		for (int i = 0; i < now.size(); i++) {
			now.get(i).join();
		}
//		}
	}

}
