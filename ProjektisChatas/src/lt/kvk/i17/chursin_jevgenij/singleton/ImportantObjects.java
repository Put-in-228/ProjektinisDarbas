package lt.kvk.i17.chursin_jevgenij.singleton;

import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClients;
import lt.kvk.i17.chursin_jevgenij.observer.ServerSubject;
import lt.kvk.i17.chursin_jevgenij.state.RoomSpace;

public class ImportantObjects {

	private static ImportantObjects instance = null;
	
	private ConnectedClients cc;
	private RoomSpace rs;
	private ServerSubject ss;
	
	
	public static ImportantObjects getInstance() {
		if (ImportantObjects.instance == null) {
			ImportantObjects.instance = new ImportantObjects();
		}

		return ImportantObjects.instance;
	}

	public void setObjectPool(ConnectedClients cc) {
		this.cc = cc;
	}
	
	public void setStateObject(RoomSpace rs) {
		this.rs = rs;
	}
	
	public void setObserverObject(ServerSubject ss) {
		this.ss = ss;
	}
	
	public ConnectedClients getObjectPool() {
		return this.cc;
	}
	
	public RoomSpace getStateObject() {
		return this.rs;
	}
	
	public ServerSubject getObserverObject() {
		return this.ss;
	}
}
