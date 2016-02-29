package Recommendations;

public class rec_goods implements Comparable<rec_goods> {
	private String name;
	private double score;
	
	public rec_goods(String _name, double score) {
		this.name = _name;
		this.score = score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getScore() {
		return this.score;
	}
	
	@Override
	public int compareTo(rec_goods o) {
		if (this.score > o.score)
			return 1;
		return 0;
	}
}
