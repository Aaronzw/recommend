package DouBan;

public class Movie {
	private String name = null;		//name of movie
	private String time = null;		//data of movie
	private String country = null;	//country of movie
	private String rate = null;		//rate of movie
	private String summary = null;	//summary of movie
	private String photo = null;	//picture of movie
	private String id = null;		//id of movie
	
	/*
	 * DianYingTianTang 
	 * */
	private String urlOpenOfTiantang = null;
	private String Poster = null;
	private String screen = null;
	private String downLoadUrl = null;
	
	public Movie() {
		
	}
	
	public Movie(String _name, String _time, String _country, 
				 String _rate, String _summary, String _photo) {
		this.name = _name;
		this.time = _time;
		this.country = _country;
		this.rate = _rate;
		this.summary = _summary;
		this.photo = _photo;
	}
	
	public Movie(String _name, String _time, String _country, 
			 String _rate, String _summary, String _photo, String _id) {
		this.name = _name;
		this.time = _time;
		this.country = _country;
		this.rate = _rate;
		this.summary = _summary;
		this.photo = _photo;
		this.id = _id;
	}
		
	public Movie(String name, String _rate) {
		super();
		this.name = name;
		this.rate = _rate;
		//System.out.println(_rate + "---------------------------");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setUrlOfTiantang(String url) {
		this.urlOpenOfTiantang = url;
	}
	public String getUrlOfTiantang() {
		return urlOpenOfTiantang;
	}
	public String getCountry() {
		return country;
	}
	public void setCountroy(String country) {
		this.country = country;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return name + "\r\n" + time + "\r\n" + country
				+ "\r\n" + rate + "\r\n" + summary + "\r\n"
				+ photo + "\r\n";
	}
}
