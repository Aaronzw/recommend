package Recommendations;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

public class recommendations {
	private Vector <Set <String>> user;
	private Vector <Set <String>> rec;
	
	public void setUser(Vector <Set <String>> nowUser) {
		this.user = nowUser;
	}
	
	public Set <String> getRecById(int id) {
		return rec.get(id);
	}
	
	//solves the data, get the recommend
	
	public void solveRec() {
		int n = user.size();
		double [][]d = new double[n][n]; 
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				Set <String> cur = user.get(i);
				cur.retainAll(user.get(j));   // get intersection
				d[i][j] = cur.size() / Math.sqrt(user.get(i).size() * user.get(j).size());
			}
		}
		
		// if d[i][j] >= 0.3, we think i and j is similarity
		
		for (int i = 0; i < n; i++) {
			Set <String> all = user.get(i);
			Vector <Integer> sim = new Vector<Integer>();
			for (int j = i + 1; j < n; j++) {
				if (d[i][j] >= 0.3) {
					all.addAll(user.get(j));
					sim.add(j);
				}
			}
			all.removeAll(user.get(i)); // get difference set
			
			int m = all.size();   // the goods which the user i may like
			java.util.Iterator<String> j = all.iterator();
			Vector <rec_goods> cur_rec = new Vector<rec_goods>();
			while(j.hasNext()) {
				double sum = 0;
				String now = j.next();
				for (int k = 0; k < sim.size(); k++) {
					if (user.get(sim.get(k)).contains(now)) {
						sum += d[i][sim.get(k)]; // i to now ok
					}
				}
				cur_rec.add(new rec_goods(now, sum));
			}
			
			Collections.sort(cur_rec);
			
			Set<String> _i = new HashSet<String>();
			for (int k = 0; k < cur_rec.size() && k < 10; k++) {
				_i.add(cur_rec.get(k).getName());
			}
			
			rec.add(_i);
		}
	}
	
}
