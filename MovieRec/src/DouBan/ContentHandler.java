package DouBan;

public class ContentHandler {
	public boolean check(UrlAndContent fetchedPage){
		// 如果抓取的页面包含反爬取内容，则将当前URL放入待爬取队列，以便重新爬取
		if(isAntiScratch(fetchedPage)){
			UrlQueue.addFirstElement(fetchedPage.getUrl());
			return false;
		}
		
		return true;
	}
	
	private boolean isStatusValid(int statusCode){
		if(statusCode >= 200 && statusCode < 400){
			return true;
		}
		return false;
	}
	
	private boolean isAntiScratch(UrlAndContent fetchedPage){
		if((!isStatusValid(fetchedPage.getStatusCode())) && fetchedPage.getStatusCode() == 403){
			return true;
		}
		
		// 页面内容包含的反爬取内容
		if(fetchedPage.getContent().contains("<div>禁止访问</div>")){
			return true;
		}
		
		return false;
	}
}
