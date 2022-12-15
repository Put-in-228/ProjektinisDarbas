package lt.kvk.i17.chursin_jevgenij.observer;

import java.util.LinkedList;
import java.util.List;

public class ServerSubject {
	private List<ServerObserver> observers;
	private String lastMessage;
	
	public ServerSubject() {
		observers = new LinkedList<>();
	}
	
	public void registerObserver(ServerObserver o) {
		observers.add(o);
	}
	
	public void unregisterObserver(ServerObserver o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (ServerObserver o : observers) {
			o.update(lastMessage);
		}
	}
	
	public void setMessage(String msg) {
		this.lastMessage = msg;
		notifyObservers();
	}
}
