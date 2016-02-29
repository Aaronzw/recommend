package DouBan;

import java.io.IOException;

import ZhiHu.FileReaderWriter;

public class DataStorage {
	/*
	 * write the information of Movie to the txt
	 * */
	
	public void store(Movie data) throws IOException{
//		System.out.println("#############################");
		String content = data.toString();
		String pathTitle = "D:/课程设计/豆瓣爬虫_电影推荐/" + "title" + String.valueOf(Start.number) + ".txt";
		String pathDes = "D:/课程设计/豆瓣爬虫_电影推荐/" + "Des" + String.valueOf(Start.number) + ".txt";
		String pathDate = "D:/课程设计/豆瓣爬虫_电影推荐/" + "Data" + String.valueOf(Start.number) + ".txt";
		String pathPic = "D:/课程设计/豆瓣爬虫_电影推荐/" + "Pic" + String.valueOf(Start.number) + ".txt";
		String pathRate = "D:/课程设计/豆瓣爬虫_电影推荐/" + "Rate" + String.valueOf(Start.number) + ".txt";
		String pathJpg = "D:/课程设计/豆瓣爬虫_电影推荐/" + "Pic" + String.valueOf(Start.number) + ".jpg";
		Start.number++;
		boolean ok = false;
		FileReaderWriter.writeIntoFile(data.getName(), pathTitle, ok);
		FileReaderWriter.writeIntoFile(data.getSummary(), pathDes, ok);
		FileReaderWriter.writeIntoFile(data.getTime(), pathDate, ok);
		FileReaderWriter.writeIntoFile(data.getName(), pathPic, ok);
		FileReaderWriter.writeIntoFile(data.getRate(), pathRate, ok);
		new downloadPhoto(data.getPhoto(), pathJpg);
	}
}
