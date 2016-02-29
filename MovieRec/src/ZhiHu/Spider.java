package ZhiHu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {
	public static String usingUrlGetMessage(String Url) {
		System.out.println(".................");
		BufferedReader reader = null;
		String out = "";
		try {
			//System.out.println(Url);
			URL realUrl = new URL(Url);
			URLConnection connection = realUrl.openConnection();
			connection.connect();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line = "";
			while ((line = reader.readLine()) != null) {
				out += line;
			}
		} catch(Exception e) {
			System.out.println("Error...." + e);
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return out;
	}
	
	public static ArrayList<ZhiHu> RegexString(String targetString) {
		
		String expressionUrl = "question_link.+?href=\"(.+?)\"";  //get every questions Url
		Pattern patternUrl = Pattern.compile(expressionUrl);
		Matcher matcherUrl = patternUrl.matcher(targetString);
		
		ArrayList<ZhiHu> result = new ArrayList<ZhiHu>();
		int num = 0;
		while (matcherUrl.find()) {
			num ++;
			ZhiHu newZhiHu = new ZhiHu(matcherUrl.group(1));
			result.add(newZhiHu);
		}
		return result;
	}
}
