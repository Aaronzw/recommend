package DouBan;

import java.util.Vector;

public class Start implements Runnable {
	
	public static int number = 0; // the number of movie
	
	public static void main(String[] args){
		
		// 初始化爬取队列
		initializeQueue();
		
		Vector <Thread> thread = new Vector<Thread>();
		
		long startTime = System.currentTimeMillis();
		// 创建worker线程并启动
		for (int i = 1; i <= CrawlerParams.WORKER_NUM; i++){
			System.out.println(i + " " + CrawlerParams.WORKER_NUM);
			System.out.println(".....Sta");
			thread.addElement(new Thread(new CrawlerBfs(i)));
			thread.elementAt(i - 1).start();
			System.out.println(".....end");
		}
		System.out.println(".....");
		// 阻塞进程
		for (int i = 0; i < CrawlerParams.WORKER_NUM; i++) {
			try {
				thread.elementAt(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime=System.currentTimeMillis(); 
		System.out.println(endTime - startTime);
		System.out.println("END");
	}
	
	
	/**
	 * 准备初始的爬取链接
	 */
	private static void initializeQueue() {
		for(int i = 0; i < 10; i++) {
			UrlQueue.addElement("http://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=" + i*20 + 1);
		}
	}


	@Override
	public void run() {
		// 初始化爬取队列
		initializeQueue();
		
		Vector <Thread> thread = new Vector<Thread>();
		
		long startTime = System.currentTimeMillis();
		// 创建worker线程并启动
		for (int i = 1; i <= CrawlerParams.WORKER_NUM; i++){
			thread.addElement(new Thread(new CrawlerBfs(i)));
			thread.elementAt(i - 1).start();
		}
		// 阻塞进程
		for (int i = 0; i < CrawlerParams.WORKER_NUM; i++) {
			try {
				thread.elementAt(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime=System.currentTimeMillis(); 
		System.out.println(endTime - startTime);
		System.out.println("END");		
	}
}
