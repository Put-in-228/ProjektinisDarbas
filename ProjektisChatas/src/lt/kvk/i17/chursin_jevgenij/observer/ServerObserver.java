package lt.kvk.i17.chursin_jevgenij.observer;

import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClientThread;

public class ServerObserver {
	private final ConnectedClientThread client;
	
	public ServerObserver(ConnectedClientThread client) {
		this.client = client;
	}
	
	public void update(String msg) {
		client.send(msg);
	}
}
