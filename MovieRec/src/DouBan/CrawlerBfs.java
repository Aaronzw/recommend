package DouBan;

import java.io.IOException;

public class CrawlerBfs implements Runnable{
//		private static final Logger Log = Logger.getLogger(CrawlerBfs.class.getName());
		
		private GetContentFromUrl fetcher;  
		private ContentHandler handler;
		private ContentParser parser;
		private DataStorage store;
		private int threadIndex;
		
		public CrawlerBfs(int threadIndex){
			this.threadIndex = threadIndex;
			this.fetcher = new GetContentFromUrl();
			this.handler = new ContentHandler();
			this.parser = new ContentParser();
			this.store = new DataStorage();
		}
		
		public void run() {
			while(!UrlQueue.isEmpty()){
				String url = UrlQueue.outElement();
				UrlAndContent fetchedPage = fetcher.getContentFromUrl(url);
				
				if(!handler.check(fetchedPage)){
					continue;
				}
				
				if(fetchedPage.getType() == CrawlerParams.FETCHEDPAGETYPE_JSON){
					parser.parseJson(fetchedPage);
				}else if(fetchedPage.getType() == CrawlerParams.FETCHEDPAGETYPE_HTML){
					Movie targetData = parser.parse(fetchedPage);
					try {
						store.store(targetData);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if (Start.number >= 1000)
					break;
			}
			
			fetcher.close();
		}
}
