package Thread;

import java.util.Vector;

import DianYingTianTang.NewMovie;
import UI.MyFrame;
import UI.openTheWorld;

public class myThread extends Thread{
	
	private String userName;
	
//	public void main (String args[]) {
////		new openTheWorld();
//		new myThread(userName);
////		new myR
////		LoginInterface.getLoginInterface();
////		System.out.println("...");
//	}
	
	public myThread(String username) {
		System.out.println(username);
		this.userName = username;
		Vector <Thread> now = new Vector<Thread>();
		now.add(new Thread(new MyFrame(userName)));
		now.get(0).start();
	}
//	
////	public void run() {
////		Vector <Thread> now = new Vector<Thread>();
////		for (int i = 0; i < 10; i++) {
////			now.add(new Thread(new NewMovie("")));
////		}
////	}
////	
//	public void run() {
//		
////		new MyFrame();
//		
//		Vector <Thread> now = new Vector<Thread>();
//		now.add(new Thread(new MyFrame(userName)));
//		now.get(0).start();
////		now.add(new Thread(new Main()));
////		now.add(new Thread(new doQiushi()));
////		now.add(new Thread(new Start()));
////		for (int i = 0; i < 4; i++) {
////			now.get(i).start();
////		}
//	}
}
