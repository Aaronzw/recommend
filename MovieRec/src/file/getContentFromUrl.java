package file;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class getContentFromUrl {
	public static String myGetContentFromUrl(String url, String charSet){
		String content = null;
		HttpParams params = new BasicHttpParams();
		HttpClient client = new DefaultHttpClient(params);
		int statusCode = 500;
		
		// 创建Get请求，并设置Header
		// 模拟浏览器登陆
		HttpGet getHttp = new HttpGet(url);	
		getHttp.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:16.0) Gecko/20100101 Firefox/16.0");
		HttpResponse response;
		//Log.info("request url:" + url);
		try{
			// 获得信息载体
			response = client.execute(getHttp);
			statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();	
			
			if(entity != null){
				content = EntityUtils.toString(entity, charSet);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return content;
		
	}
}
