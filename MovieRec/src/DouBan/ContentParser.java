package DouBan;

import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class ContentParser {
	
	public Movie parse(UrlAndContent fetchedPage){
		String name = null;
		String time = null;
		String country = null;
		String rate = null;
		String summary = null;
		String photo = null;
		
		Document doc = Jsoup.parse(fetchedPage.getContent());
		if(doc.getElementsByAttributeValue("property","v:itemreviewed") != null){
			name = doc.getElementsByAttributeValue("property","v:itemreviewed").html();
		}
		if(doc.getElementsByAttributeValue("property","v:initialReleaseDate") != null){
			time = doc.getElementsByAttributeValue("property","v:initialReleaseDate").html();
		}
		if(doc.getElementsByAttributeValue("property","v:average").html() != null){
			rate = doc.getElementsByAttributeValue("property","v:average").html();
		}
		if(doc.getElementsByAttributeValue("property","v:summary").html() != null){
			summary = doc.getElementsByAttributeValue("property","v:summary").html();
		}
		if(doc.getElementsByAttributeValue("rel","v:image").attr("src") != null){
			photo = doc.getElementsByAttributeValue("rel","v:image").attr("src");
		}
		// 将URL放入已爬取队列
		VisitedUrlQueue.insertValue(fetchedPage.getUrl());
		
		Elements bfs = doc.getElementsByClass("recommendations-bd");
		
		Element curEle = bfs.get(0);
		
		Elements d1 = curEle.getElementsByTag("a");
//		System.out.println(fetchedPage.getUrl() + "###################");
//		System.out.println(d1.size());
		for (int i = 0; i < d1.size(); i++) {
			Element curD1 = d1.get(i);
			String url = curD1.attr("href");
			System.out.println(url);
			if (!VisitedUrlQueue.isExist(url)) {
				UrlQueue.addElement(url);
			}
		}
		
		//String _name, String _time, String _country, String _rate, String _summary, String _photo
		return new Movie(name, time, country, rate, summary, photo); 
	}
	
	
	/**
	 * 使用阿里的json工具类，解析json对象
	 * @param fetchedPage
	 */
	public void parseJson(UrlAndContent fetchedPage){
//		System.out.println(fetchedPage.getUrl());
		JSONObject obj = JSON.parseObject(fetchedPage.getContent());
		Object subjects = obj.get("subjects");
		List<Object> list = JSON.parseArray(subjects.toString());
		for (Object object : list){
			Map movieMap = JSON.parseObject(object.toString(),Map.class);
			
			//过滤数据
			String name = movieMap.get("title").toString();
			String url = movieMap.get("url").toString();
			String rate = movieMap.get("rate").toString();
			Movie movie = new Movie(name, rate);
			
			//把过滤后合适的数据，放入url放入队列
			if (MovieMatch.isMatch(movie) && !VisitedUrlQueue.isExist(url)){
				UrlQueue.addElement(url);
//				System.out.println(url);
			}
		}
		
		// 将URL放入已爬取队列
		VisitedUrlQueue.insertValue(fetchedPage.getUrl());
	}
}
