package DouBan;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 过滤器，用于过滤出需要的电影
 * @author terry
 *
 */
public class MovieMatch {

	//private static final Logger Log = Logger.getLogger(MovieFilter.class.getName());
	
	public static boolean isMatch(Movie movie){
		
		String rate = movie.getRate();
		
		if (rate.charAt(0) < '7')
			return false;
		return true;

	}
}
