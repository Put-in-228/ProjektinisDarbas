package lt.kvk.i17.chursin_jevgenij.addthreads;

import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class StateThread extends Thread {
	public void run() {
		while (ImportantObjects.getInstance().getStateObject() != null) {
			ImportantObjects.getInstance().getStateObject().acceptConnections();
		}
	}
}
