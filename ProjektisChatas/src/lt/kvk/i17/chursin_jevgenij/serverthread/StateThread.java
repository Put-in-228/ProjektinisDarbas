package lt.kvk.i17.chursin_jevgenij.serverthread;

import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class StateThread extends Thread {
	public void run() {
		ImportantObjects.getInstance().getStateObject().acceptConnections();
	}
}
