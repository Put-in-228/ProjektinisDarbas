package lt.kvk.i17.chursin_jevgenij.facade;

import java.io.IOException;

import com.dosse.upnp.UPnP;

import lt.kvk.i17.chursin_jevgenij.builder.SocketBuilder;
import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
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
		UPnP.openPortTCP(params.getPort());
	}
	
	void setupValues() {
		params = Config.getInstance();
		
		SocketBuilder builder = new SocketBuilder(params.getUserName());
		builder.addAmount(params.getAmount());
		builder.addPort(params.getPort());
		server = builder.build();
	}
	
	void initObjects() {
		objects = ImportantObjects.getInstance();
		
		objects.setObjectPool(new ConnectedClients());
		objects.setObserverObject(new ServerSubject());
		objects.setStateObject(new RoomSpace(server));
	}
	
	void startListener() {
		objects.getStateObject().acceptConnections();
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
