package lt.kvk.i17.chursin_jevgenij.addthreads;

import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClientThread;

public class ConnectedClientOneTime extends Thread {
	ConnectedClientThread thread;
	
	public ConnectedClientOneTime (ConnectedClientThread thread) {
		this.thread = thread;
	}
	
	public void run() {
		thread.run();
	}
}
