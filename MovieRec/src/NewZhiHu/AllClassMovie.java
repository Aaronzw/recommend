package NewZhiHu;

import java.util.Vector;

public class AllClassMovie {

	public static void main(String[] args) throws InterruptedException {
		newZhiHu MovieRecommand = new newZhiHu("http://www.zhihu.com/topic/19556784/top-answers?page=", "电影推荐、");
		newZhiHu MovieLine = new newZhiHu("http://www.zhihu.com/topic/19635312/top-answers?page=", "电影台词");
		newZhiHu MovieComment = new newZhiHu("http://www.zhihu.com/topic/19575422/top-answers?page=", "电影评论");
		newZhiHu MovieCheck = new newZhiHu("http://www.zhihu.com/topic/19657513/top-answers?page=", "电影审查");
		newZhiHu MovieScene = new newZhiHu("http://www.zhihu.com/topic/19813769/top-answers?page=", "电影场景");
		newZhiHu MovieChannel = new newZhiHu("http://www.zhihu.com/topic/19816647/top-answers?page=", "电影频道");
		newZhiHu MovieWork = new newZhiHu("http://www.zhihu.com/topic/20019234/top-answers?page=", "电影作品");
		
		Vector <Thread> all = new Vector<Thread>();
		all.addElement(new Thread(MovieRecommand));
		all.addElement(new Thread(MovieLine));
		all.addElement(new Thread(MovieComment));
		all.addElement(new Thread(MovieCheck));
		all.addElement(new Thread(MovieScene));
		all.addElement(new Thread(MovieChannel));
		all.addElement(new Thread(MovieWork));
		for (int i = 0; i < all.size(); i++) {
			all.get(i).start();
		}
		
		for (int i = 0; i < all.size(); i++) {
			all.get(i).join();
		}
		
	}

}
