package ZhiHu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.Document;

import org.jsoup.Jsoup;

public class ZhiHu {
	
	public String queTitle;
	public String addressUrl; 
	public String queDescription;
	public ArrayList<String> answer;
	
	
	public ZhiHu(String Url) {
//		System.out.println(Url);
		queTitle = "";
		addressUrl = "";
		queDescription = "";
		answer = new ArrayList<String>();
		
		if (getQuestionUrl(Url)) {
			System.out.println(Url);
			
			
			String content = Spider.usingUrlGetMessage(addressUrl);
			//System.out.println(addressUrl);
			Pattern expressionTitle = Pattern.compile("zh-question-title.+?<h2.+?>.+?>(.+?)</h2>");
			Matcher matcherTitle = expressionTitle.matcher(content);
			
			if (matcherTitle.find()) {
				queTitle = matcherTitle.group(1);
			}
			
			Pattern expressionDes = Pattern.compile("zh-question-detail.+?<div.+?>(.*?)</div>");
			Matcher matcherDes = expressionDes.matcher(content);
			
			if (matcherDes.find()) {
				queDescription = matcherDes.group(1);
			}
			
			Pattern expressionAnswer = Pattern.compile("zm-editable-content clearfix\">(.+?)</div>");
			//Pattern expressionAnswer = Pattern.compile("/answer/content.+?<div.+?>(.*?)</div>");
			Matcher matcherAnswer = expressionAnswer.matcher(content);
			
			if (matcherAnswer.find()) {
				answer.add(matcherAnswer.group(1));
			}
		}
	}
	
	public  String toString() {
		return "Question : " + queTitle + "\n" + 
				"Description : " + queDescription + "\n" + 
				"Url : " + addressUrl + "\n" +
				"Answer : " + answer + "\n"; 
	}

	public String writeString() {
		String result = "";
		result += "Question: \r\n\n" + queTitle + "\r\n\n\r\n";
		result += "Description: \r\n\n" + queDescription + "\r\n\n\r\n\n";
		result += "Url: \r\n\n" + addressUrl + "\r\n\n\r\n\n";
		result += "Answer: \r\n\n" + answer + "\r\n\n\r\n\n";
		result += "\r\n\n\n";
		result = result.replaceAll("<br>", "\r\n");
		result = result.replaceAll("</br>", "\r\n");
		result = result.replaceAll("</a>", "\r\n");
		result = result.replaceAll("<a>", "\r\n");
		result = result.replaceAll("</b>", "");
		result = result.replaceAll("<b>", "");
		result = result.replaceAll("<.*?>", "");
		result = result.replaceAll("谢邀", "");
		//System.out.println(result);
		return result;
	}
	
	public String writeTitle() {
		return eraseHtml(queTitle);
	}
	
	public String writeDes() {
		return eraseHtml(queDescription);
	}
	
	public String writeAnswer() {
		String result = "";
		result += answer;
		return eraseHtml(result);
	}
	
	public String eraseHtml(String s) {
		s = s.replace("<p>", "");
		s = s.replace("</p>", "\r\n");
		s = s.replace("<br>", "\r\n");
		s = s.replace("b", "");
		s = s.replace("/b", "");
		s = s.replaceAll("<.*?>", "");
		return s;
	}
	
	public boolean getQuestionUrl(String Url) {
		//Pattern exPattern = Pattern.compile("question/(.*?)/");
		//Matcher matcher = exPattern.matcher(Url);
		//System.out.println(Url);
//		if (matcher.find()) {
//			addressUrl = "http://www.zhihu.com/question/" + matcher.group(1); 
//			return true;
//		} else {
//			return false;
//		}
		
		addressUrl = "http://www.zhihu.com" + Url;
		return true;
	}
}
