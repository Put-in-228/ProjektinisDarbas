package lt.kvk.i17.chursin_jevgenij.object_pool;

import java.util.LinkedList;
import java.util.List;

import lt.kvk.i17.chursin_jevgenij.observer.ServerSubject;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;
import lt.kvk.i17.chursin_jevgenij.state.RoomSpace;

public class ConnectedClients {
	private static List<ConnectedClientThread> free = new LinkedList<>();
	private static List<ConnectedClientThread> used = new LinkedList<>();
	
	public static ConnectedClientThread getThread() {
		if (free.isEmpty()) {
			ConnectedClientThread thread = new ConnectedClientThread();
			used.add(thread);
			ImportantObjects.getInstance().getObserverObject().registerObserver(thread.getObserverObject());
			ImportantObjects.getInstance().getStateObject().passCurrentSpace(used.size());
			return thread;
		} else {
			ConnectedClientThread temp = free.get(0);
			used.add(temp);
			free.remove(temp);
			ImportantObjects.getInstance().getObserverObject().registerObserver(temp.getObserverObject());
			ImportantObjects.getInstance().getStateObject().passCurrentSpace(used.size());
			return temp;
		}
	}
	
	public static void returnThread(ConnectedClientThread thread) {
		ImportantObjects.getInstance().getObserverObject().unregisterObserver(thread.getObserverObject());
		thread.nullObject();
		free.add(thread);
		used.remove(thread);
		ImportantObjects.getInstance().getStateObject().passCurrentSpace(used.size());
	}
	
	public static ConnectedClientThread findByUsername(String userName) {
		for (ConnectedClientThread v : used) {
			if (userName.equals(v.getUserName())) {
				return v;
			}
		}
		
		return null;
	}
}
