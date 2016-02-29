package DouBan;

import java.util.HashMap;
import java.util.Map;

public class VisitedUrlQueue {
	static Map<String, String> map = new HashMap<String, String>();
	/*
	 * name : the name of key
	 * check whether the name exist or not
	 * */
	static boolean isExist(String name) {
		if (map.get(name) == "true") {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * insert the name to map
	 * */
	static void insertValue(String name) {
		map.put(name, "true");
	}
}
