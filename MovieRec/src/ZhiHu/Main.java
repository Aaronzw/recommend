package ZhiHu;

import java.util.ArrayList;

public class Main implements Runnable {
	public ArrayList<ZhiHu> newZhiHu;
	
//	public static void main(String[] args) {
//		String address = "http://www.zhihu.com/explore/recommendations";
////		String address = "http://www.zhihu.com/topic/19554298";
//		String getUrlContent = Spider.usingUrlGetMessage(address);
////		System.out.println(getUrlContent);
//		System.out.println("&&&&&&&&&&&&&&&&&");
//		newZhiHu = Spider.RegexString(getUrlContent);
//		System.out.println("##########################");
//		System.out.println(newZhiHu.size());
//		int i = 0;
//		for (ZhiHu zhihu : newZhiHu) {
//			if (zhihu.queTitle != "") {
//				String path = "";
//				path += "D:/课程设计/知乎爬虫_今日推荐/知乎_编辑推荐_Problem" + String.valueOf(i) + "_title" + ".txt";
//				FileReaderWriter.writeIntoFile(zhihu.writeTitle(), path, false);
//				path = "";
//				path += "D:/课程设计/知乎爬虫_今日推荐/知乎_编辑推荐_Problem" + String.valueOf(i) + "_Des" + ".txt";
//				FileReaderWriter.writeIntoFile(zhihu.writeDes(), path, false);
//				path = "";
//				path += "D:/课程设计/知乎爬虫_今日推荐/知乎_编辑推荐_Problem" + String.valueOf(i) + "_Answer" + ".txt";
//				FileReaderWriter.writeIntoFile(zhihu.writeAnswer(), path, false);
////				if (i == 0)
////					FileReaderWriter.writeIntoFile(zhihu.writeString(), path, false);
////				else
////					FileReaderWriter.writeIntoFile(zhihu.writeString(), path, true);
//				i++;
//			}
//		}
//		System.out.println("OK");
//		
//		//System.out.println(newZhiHu);
//	}
	@Override
	public void run() {
		String address = "http://www.zhihu.com/explore/recommendations";
//		String address = "http://www.zhihu.com/topic/19554298";
		String getUrlContent = Spider.usingUrlGetMessage(address);
//		System.out.println(getUrlContent);
		System.out.println("&&&&&&&&&&&&&&&&&");
		newZhiHu = Spider.RegexString(getUrlContent);
		System.out.println("##########################");
		System.out.println(newZhiHu.size());
		int i = 0;
		for (ZhiHu zhihu : newZhiHu) {
			if (zhihu.queTitle != "") {
				String path = "";
				path += "D:/课程设计/知乎爬虫_今日推荐/知乎_编辑推荐_Problem" + String.valueOf(i) + "_title" + ".txt";
				FileReaderWriter.writeIntoFile(zhihu.writeTitle(), path, false);
				path = "";
				path += "D:/课程设计/知乎爬虫_今日推荐/知乎_编辑推荐_Problem" + String.valueOf(i) + "_Des" + ".txt";
				FileReaderWriter.writeIntoFile(zhihu.writeDes(), path, false);
				path = "";
				path += "D:/课程设计/知乎爬虫_今日推荐/知乎_编辑推荐_Problem" + String.valueOf(i) + "_Answer" + ".txt";
				FileReaderWriter.writeIntoFile(zhihu.writeAnswer(), path, false);
//				if (i == 0)
//					FileReaderWriter.writeIntoFile(zhihu.writeString(), path, false);
//				else
//					FileReaderWriter.writeIntoFile(zhihu.writeString(), path, true);
				i++;
			}
		}
		System.out.println("OK");
	}
}