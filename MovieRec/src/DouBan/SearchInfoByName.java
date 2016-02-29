package DouBan;

import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import UI.getStringFromTxt;
import ZhiHu.FileReaderWriter;
import file.getContentFromUrl;

public class SearchInfoByName implements Runnable{
	
	private String path;
	private String MovieAdd; 

	public SearchInfoByName(String path, String MovieAdd) {
		this.path = path;
		this.MovieAdd = MovieAdd;
	}
	
	public String getPath() {
		return path;
	}
	
	
	public void searchInfoByName(String MovieName, String url) {
		String rate = "", time = "", summary = "";
//		Vector <String> type;
		String content = getContentFromUrl.myGetContentFromUrl(url, "utf-8");
		Document doc = Jsoup.parse(content);
		String writeString = "";
		if(doc.getElementsByAttributeValue("property","v:initialReleaseDate") != null){
			time = doc.getElementsByAttributeValue("property","v:initialReleaseDate").html();
			FileReaderWriter.writeIntoFile(time, path + "//" + MovieName + "_Time" + ".txt", false);
		}
		if(doc.getElementsByAttributeValue("property","v:average").html() != null){
			rate = doc.getElementsByAttributeValue("property","v:average").html();
			FileReaderWriter.writeIntoFile(rate, path + "//" + MovieName + "_Rate" + ".txt", false);
		}
		if(doc.getElementsByAttributeValue("property","v:summary").html() != null){
			summary = doc.getElementsByAttributeValue("property","v:summary").html();
			FileReaderWriter.writeIntoFile(summary, path + "//" + MovieName + "_Summary" + ".txt", false);
		}
		Elements typeMovie = doc.getElementsByAttributeValue("property", "v:genre");
		
//		type = new Vector<String>();
		if (typeMovie != null) {
			for (int i = 0; i < typeMovie.size(); i++) {
//				type.addElement(typeMovie.get(i).text());
				writeString += typeMovie.get(i).text() + " ";
			}
		}
		writeString += "\r\n";
		System.out.println(writeString);
		FileReaderWriter.writeIntoFile(writeString, path + "//" + MovieName + "Type" + ".txt", false);
	}
	
//	public void main (String args[]) {
////		System.out.println(",,,");
////		Vector <String> allMovie = getStringFromTxt.GetStringFromTxToVector("D://课程设计//电影天堂//text//AllMovie.txt");
//		
////		SearchInfoByName now = new SearchInfoByName("D://课程设计//电影天堂//text", name)
//	}

	@Override
	public void run() {
		Vector <String> allMovie = getStringFromTxt.GetStringFromTxToVector(MovieAdd);
		for (int i = 0; i < allMovie.size(); i++) {
//			System.out.println("....");
			String thisName = allMovie.get(i);
			String thisMovieUrl = "http://movie.douban.com/subject_search?search_text=" + thisName + "&cat=1002";
			String totPageContent = getContentFromUrl.myGetContentFromUrl(thisMovieUrl, "utf-8");
			Document nowPage = Jsoup.parse(totPageContent);
			Elements tbody = nowPage.getElementsByTag("tbody");
			System.out.println(thisName);
			if (tbody.size() <= 1) continue;
			Element p12 = tbody.get(1);
			String realUrl = p12.getElementsByTag("a").get(0).attr("href");
			searchInfoByName(thisName, realUrl);
		}
	}
	
}
