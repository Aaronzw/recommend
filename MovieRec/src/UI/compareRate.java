package UI;

import java.util.Comparator;

public class compareRate implements Comparator<thisMoviePanel>{


	@Override
	public int compare(thisMoviePanel arg0, thisMoviePanel arg1) {
		String time1 = arg0.getRate();
		String time2 = arg1.getRate();
		System.out.println("............................");
		if (time1.compareTo(time2) > 0)
			return 1;
		return 0;
	}
	
}
