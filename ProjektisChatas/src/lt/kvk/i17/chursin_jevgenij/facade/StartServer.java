package lt.kvk.i17.chursin_jevgenij.facade;

import java.io.IOException;

import com.dosse.upnp.UPnP;

import lt.kvk.i17.chursin_jevgenij.addthreads.StateThread;
import lt.kvk.i17.chursin_jevgenij.builder.SocketBuilder;
import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
import lt.kvk.i17.chursin_jevgenij.filter.CriteriaGroup;
import lt.kvk.i17.chursin_jevgenij.gui.init.FrameSetup;
import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClients;
import lt.kvk.i17.chursin_jevgenij.observer.ServerSubject;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;
import lt.kvk.i17.chursin_jevgenij.state.RoomSpace;

public class StartServer {
	Soketas server;
	
	Config params;
	ImportantObjects objects;
	
	void openPort() {
		params = Config.getInstance();
		
		UPnP.openPortTCP(params.getPort());
	}
	
	void setupValues() {
		SocketBuilder builder = new SocketBuilder(params.getUserName());
		builder.addAmount(params.getAmount());
		builder.addPort(params.getPort());
		server = builder.build();
	}
	
	void initObjects() {
		objects = ImportantObjects.getInstance();
		System.out.println("SETUPOBJECTSVAR");
		
		
		objects.setObjectPool(new ConnectedClients());
		System.out.println("SETUPOBJECTPOOl");
		objects.setObserverObject(new ServerSubject());
		System.out.println("SETUPOBSERVER");
		objects.setStateObject(new RoomSpace(server));
		System.out.println("SETUPSTATE");
		objects.setCriteriaGroup(new CriteriaGroup());
		
		FrameSetup.onHostServer();
		System.out.println("SETUPUI");
	}
	
	void startListener() {
		StateThread temp = new StateThread();
		temp.start();
		System.out.println("STARTLISTENING");
	}
	
	void closePort() {
		UPnP.closePortTCP(params.getPort());
	}
	
	void nullServer() {
		try {
			server.getServerSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		server = null;
	}
}
