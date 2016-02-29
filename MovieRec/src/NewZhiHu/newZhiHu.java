package NewZhiHu;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import DouBan.GetContentFromUrl;
import ZhiHu.FileReaderWriter;
import ZhiHu.ZhiHu;
import file.getContentFromUrl;

public class newZhiHu implements Runnable{
	
	private String mainPageUrl;
	private String address; 
	
	
	public newZhiHu(String mainPageUrl, String type) {
		this.mainPageUrl = mainPageUrl;
		this.address = type;
	}

	public void getInfo() {
		int sum = 0;
		for (int j = 1; j <= 10; j++) {
			System.out.println(mainPageUrl + String.valueOf(j));
			String PageContent = getContentFromUrl.myGetContentFromUrl(mainPageUrl + String.valueOf(j), "utf-8");
			Document proUrl = Jsoup.parse(PageContent);
			Elements allProUrl = proUrl.getElementsByClass("zm-item-rich-text");
			for (int i = 0; i < allProUrl.size(); i++) {
				sum++;
				String nowUrl = allProUrl.get(i).attr("data-entry-url");
				ZhiHu thisZhiHu = new ZhiHu(nowUrl);
				String queName = thisZhiHu.writeTitle();
				String queDes = thisZhiHu.writeDes();
				String queAns = thisZhiHu.writeAnswer();
				String nowPath = "D://课程设计//知乎爬虫//" + address + "//name" + String.valueOf(sum)  + ".txt";
				File now = new File(nowPath);
				if (now.exists()) {
//					System.out.println("okok");
					continue;
				}
				FileReaderWriter.writeIntoFile(queName, "D://课程设计//知乎爬虫//" + address + "//name_" + queName + ".txt", false);
				FileReaderWriter.writeIntoFile(queDes, "D://课程设计//知乎爬虫//" + address + "//des_" + queName  + ".txt", false);
				FileReaderWriter.writeIntoFile(queAns, "D://课程设计//知乎爬虫//" + address + "//Ans_" + queName  + ".txt", false);
				FileReaderWriter.writeIntoFile(queName + "\r\n", "D://课程设计//知乎爬虫//" + address + "//AllMovie.txt", true);
//				System.out.println(address + ".txt");
//				System.out.println("Title : " + queName);
//				System.out.println("Des : " + queDes);
//				System.out.println(new ZhiHu(nowUrl).toString() + address);
			}
		}
	}

	@Override
	public void run() {
		getInfo();
	}

}
