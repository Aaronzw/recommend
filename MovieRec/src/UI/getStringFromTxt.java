package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class getStringFromTxt {
	
	static public String GetStringFromTxt(String filePath) {
		String content = "";
		try {
            String encoding = "utf-8";
            File file = new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	content += lineTxt;
                }
                read.close();
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
	
	static public String GetStringFromTxtTwoLine(String filePath) {
		String content = "";
		try {
            String encoding = "utf-8";
            File file = new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int num = 0;
                while((lineTxt = bufferedReader.readLine()) != null){
                	content += lineTxt;
                	num ++;
                	if (num >= 2) break;
                }
                read.close();
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
	
	public static Vector <String> GetStringFromTxToVector(String filePath) {
		Vector <String> content = new Vector<String>();
		try {
            String encoding = "utf-8";
            File file = new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	content.addElement(lineTxt);
                }
                read.close();
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
}
