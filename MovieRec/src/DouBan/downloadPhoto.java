package DouBan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class downloadPhoto {
	
	public downloadPhoto(String urlString, String filename) throws IOException {
	    URL url = new URL(urlString);
	    URLConnection con = url.openConnection();
	    InputStream is = con.getInputStream();
	    byte[] bs = new byte[1024];
	    int len;
	    OutputStream os = new FileOutputStream(filename);
	    os.flush();
	    while ((len = is.read(bs)) != -1) {
	      os.write(bs, 0, len);
	    }
	    os.close();
	    is.close();
	}

	public static void downloadPhoto(String fileUrl, String savePath) throws IOException {
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
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		DataInputStream in = new DataInputStream(connection.getInputStream());
		/* 此处也可用BufferedInputStream与BufferedOutputStream  需要保存的路径*/
		DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
		byte[] buffer = new byte[4096];
		int count = 0;
		while ((count = in.read(buffer)) > 0)/* 将输入流以字节的形式读取并写入buffer中 */
		{
			out.write(buffer, 0, count);
		}
		out.close();/* 后面三行为关闭输入输出流以及网络资源的固定格式 */
		in.close();
		connection.disconnect();
	}
}