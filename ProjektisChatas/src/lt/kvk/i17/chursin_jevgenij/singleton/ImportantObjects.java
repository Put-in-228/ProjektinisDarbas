package lt.kvk.i17.chursin_jevgenij.singleton;

import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.facade.StartClientFacade;
import lt.kvk.i17.chursin_jevgenij.facade.StartServerFacade;
import lt.kvk.i17.chursin_jevgenij.filter.CriteriaGroup;
import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClients;
import lt.kvk.i17.chursin_jevgenij.observer.ServerSubject;
import lt.kvk.i17.chursin_jevgenij.state.RoomSpace;

public class ImportantObjects {

	private static ImportantObjects instance = null;
	
	private ConnectedClients cc;
	private RoomSpace rs;
	private ServerSubject ss = null;
	private GUIGroup gg;
	private CriteriaGroup cg;
	private Soketas client = null;
	private StartClientFacade facade1 = null;
	private StartServerFacade facade2 = null;
	
	
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
	
	public void setSoketas(Soketas client) {
		this.client = client;
	}
	
	public void setClientFacade(StartClientFacade facade1) {
		this.facade1 = facade1;
	}
	
	public void setServerFacade(StartServerFacade facade2) {
		this.facade2 = facade2;
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
	
	public Soketas getSoketas() {
		return this.client;
	}
	
	public StartClientFacade getClientFacade() {
		return this.facade1;
	}
	
	public StartServerFacade getServerFacade() {
		return this.facade2;
	}
}
