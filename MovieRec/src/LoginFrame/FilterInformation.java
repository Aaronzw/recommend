package LoginFrame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterInformation {
	//学号是否合法
	public static boolean FilterNumber(String Number){
		return true;
	}
	//用户名是否合法, 3-10个字符 
	public static int FilterUsername(String Username){
		Pattern pattern = Pattern.compile("[\\w]+");
		Matcher match = pattern.matcher(Username);
		if (Username.length() == 0)
			return 0;//空串
		if (!match.matches())
			return 2;//字符不合法
		if (Username.length() < 3)
			return 3;//长度太短
		if (Username.length() > 10)
			return 4;//太长
		return 1;
	}
	
	//密码是否合法  所有键盘可用字符
	public static int FilterPassword(String Password, String confirmPassword){
		Pattern pattern = Pattern.compile("[\\w~!@#\\$%\\^&\\*()-=\\+<>,\\.\\?]+");
		Matcher match = pattern.matcher(Password);
		if (Password.length() == 0)
			return 0;//密码空串
		if (confirmPassword.length() == 0)
			return 5;//确认密码空串
		if (!confirmPassword.equals(Password))
			return 6;//不一致
		if (!match.matches())
			return 2;//字符不合法
		if (confirmPassword.length() < 3)
			return 3;//太短
		if (confirmPassword.length() > 10)
			return 4;//太长
		return 1;
	}
	//名字是否合法 字必须2-4
	public static boolean FilterName(String Name){
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]{2,4}");
		Matcher match = pattern.matcher(Name);
		return match.matches();
	}
	//名是否合法  中文英文下划线
	public static boolean FilterCommunityName(String Name){
		Pattern pattern = Pattern.compile("[\\w\u4e00-\u9fa5]{2,10}");
		Matcher match = pattern.matcher(Name);
		return match.matches();
	}
}
