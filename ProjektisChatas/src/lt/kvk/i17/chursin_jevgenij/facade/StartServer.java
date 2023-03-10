package lt.kvk.i17.chursin_jevgenij.facade;

import java.io.IOException;

import com.dosse.upnp.UPnP;

import lt.kvk.i17.chursin_jevgenij.addthreads.StateThread;
import lt.kvk.i17.chursin_jevgenij.builder.SocketBuilder;
import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
import lt.kvk.i17.chursin_jevgenij.command.CommandGroup;
import lt.kvk.i17.chursin_jevgenij.command.DisconnectClient;
import lt.kvk.i17.chursin_jevgenij.command.MuteClient;
import lt.kvk.i17.chursin_jevgenij.command.UnmuteClient;
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
		
		objects.setObjectPool(new ConnectedClients());
		
		objects.setObserverObject(new ServerSubject());
		
		objects.setStateObject(new RoomSpace(server));
		
		objects.setCriteriaGroup(new CriteriaGroup());
		
		objects.setCommandGroup(new CommandGroup());
		
		CommandGroup temp = objects.getCommands();
		
		temp.addCommand("/kick", new DisconnectClient());
		temp.addCommand("/mute", new MuteClient());
		temp.addCommand("/unmute", new UnmuteClient());
	}
	
	void setupUI() {
		FrameSetup.onHostServer();
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
	
	void emptyUI() {
		FrameSetup.onStopHost();
	}
	
	void nullObjects() {
		ImportantObjects.getInstance().setServerFacade(null);
		ImportantObjects.getInstance().setCommandGroup(null);
		ImportantObjects.getInstance().setCriteriaGroup(null);
		ImportantObjects.getInstance().setObjectPool(null);
		ImportantObjects.getInstance().setObserverObject(null);
		ImportantObjects.getInstance().setStateObject(null);
	}
}
