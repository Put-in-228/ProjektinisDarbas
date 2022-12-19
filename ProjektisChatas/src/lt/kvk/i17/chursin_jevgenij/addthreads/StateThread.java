package lt.kvk.i17.chursin_jevgenij.addthreads;

import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class StateThread extends Thread {
	public void run() {
		ImportantObjects.getInstance().getStateObject().acceptConnections();
	}
}
