package DianYingTianTang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Vector;

import ZhiHu.FileReaderWriter;

public class downLoadPhoto implements Runnable {


	private Vector<MovieTianTang> UrlSet;
	private String savePath;
	
	public downLoadPhoto(Vector<MovieTianTang> a, String b) {
		UrlSet = new Vector<MovieTianTang>();
		this.UrlSet = a;
		this.savePath = b;
	}
	
	public boolean downloadPhoto(String fileUrl, String nowPath) throws IOException {
		File now = new File(nowPath);
//		if (now.exists()) {
//			System.out.println("okok");
//			return false;
//		}
//		URL url = new URL(urlString);
//	    URLConnection con = url.openConnection();
//	    InputStream is = con.getInputStream();
//	    byte[] bs = new byte[1024];
//	    int len;
//	    OutputStream os = new FileOutputStream(filename);
//	    while ((len = is.read(bs)) != -1) {
//	      os.write(bs, 0, len);
//	    }
//	    os.close();
//	    is.close();
		URL url = new URL(fileUrl);
//		Properties prop = System.getProperties(); 
//		System.getProperties().put("proxySet","true"); 
//		prop.setProperty("http.proxyHost","172.17.0.2"); 
//		prop.setProperty("http.proxyPort","8080");
		
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(2000);
		connection.setReadTimeout(2000);
		connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		
		DataInputStream in = new DataInputStream(connection.getInputStream());
		/* 此处也可用BufferedInputStream与BufferedOutputStream  需要保存的路径*/
		DataOutputStream out = new DataOutputStream(new FileOutputStream(nowPath));
		byte[] buffer = new byte[4096];
		int count = 0;
		while ((count = in.read(buffer)) > 0)/* 将输入流以字节的形式读取并写入buffer中 */
		{
			out.write(buffer, 0, count);
		}
		out.close();/* 后面三行为关闭输入输出流以及网络资源的固定格式 */
		in.close();
		connection.disconnect();
		now = new File(nowPath);
		if (now.exists()) {
			System.out.println("okok");
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < UrlSet.size(); i++) {
				String name = UrlSet.get(i).getName();
				System.out.println("Download" + " " + name);
				boolean fir = downloadPhoto(UrlSet.get(i).getPoster(), savePath + "/Poster_" + name + ".jpg");
				boolean se = downloadPhoto(UrlSet.get(i).getScreen(), savePath + "/Screen_" + name + ".jpg");
				if (fir) {
					String content = name + "\r\n" + UrlSet.get(i).getDownLoadUrl() + "\r\n" + 
									 UrlSet.get(i).getUrlOpen() + "\r\n";
					FileReaderWriter.writeIntoFile(name + "\r\n", savePath + "//" + "AllMovie" + ".txt", true);
					FileReaderWriter.writeIntoFile(content, savePath + "//" + name + ".txt", true);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
