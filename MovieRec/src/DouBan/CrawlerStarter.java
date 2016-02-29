package DouBan;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class CrawlerStarter {

	public static void main(String[] args){
		initializeParams();
		initializeQueue();
		for(int i = 1; i <= CrawlerParams.WORKER_NUM; i++){
			new Thread(new CrawlerBfs(i)).start();
		}
	}
	
	/**
	 * 初始化配置文件参数
	 */
	private static void initializeParams(){
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream("conf/crawler.properties"));
			Properties properties = new Properties();
			properties.load(in);
			
			// 从配置文件中读取参数
			CrawlerParams.WORKER_NUM = Integer.parseInt(properties.getProperty("crawler.threadNum"));
			CrawlerParams.DEYLAY_TIME = Integer.parseInt(properties.getProperty("crawler.fetchDelay"));

			in.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 准备初始的爬取链接
	 */
	private static void initializeQueue(){
		for(int i =0;i<2;i++){
			UrlQueue.addElement("http://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=" + i*20 + 1);
		}
	}
}
