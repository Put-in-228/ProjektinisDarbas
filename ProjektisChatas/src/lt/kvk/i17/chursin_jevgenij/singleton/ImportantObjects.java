package lt.kvk.i17.chursin_jevgenij.singleton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.filter.CriteriaGroup;
import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClients;
import lt.kvk.i17.chursin_jevgenij.observer.ServerSubject;
import lt.kvk.i17.chursin_jevgenij.state.RoomSpace;

public class ImportantObjects {

	private static ImportantObjects instance = null;
	
	private ConnectedClients cc;
	private RoomSpace rs;
	private ServerSubject ss;
	private GUIGroup gg;
	private CriteriaGroup cg;
	
	
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
	
	public void setGUIGroup(GUIGroup gg) {
		this.gg = gg;
	}
	
	public void setCriteriaGroup(CriteriaGroup cg) {
		this.cg = cg;
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
	
	public GUIGroup getGUIGroup() {
		return this.gg;
	}
	
	public CriteriaGroup getCriteriaGroup() {
		return this.cg;
	}
}
