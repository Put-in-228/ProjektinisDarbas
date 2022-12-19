package lt.kvk.i17.chursin_jevgenij.observer;

import java.util.LinkedList;
import java.util.List;

import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

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
		ImportantObjects.getInstance().getGUIGroup().get("OUTPUTTEXT").getTextArea().append(msg + "\n");
		this.lastMessage = msg;
		notifyObservers();
	}
}
