package lt.kvk.i17.chursin_jevgenij.facade;

import java.io.IOException;

import lt.kvk.i17.chursin_jevgenij.addthreads.ClientReadThread;
import lt.kvk.i17.chursin_jevgenij.builder.SocketBuilder;
import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
import lt.kvk.i17.chursin_jevgenij.clientread.ClientRead;
import lt.kvk.i17.chursin_jevgenij.gui.init.FrameSetup;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class StartClient {
	Soketas client;
	
	Config params;
	ImportantObjects objects;
	
	void setupValues(String ip, int port) {
		params = Config.getInstance();
		objects = ImportantObjects.getInstance();
		
		SocketBuilder builder = new SocketBuilder(params.getUserName());
		builder.addIp(ip);
		builder.addPort(port);
		client = builder.build();
		
		objects.setSoketas(client);
	}
	
	void getUI() {
		FrameSetup.onJoinServer();
	}
	
	void startListening() {
		ClientReadThread temp = new ClientReadThread(client);
		temp.start();
	}
	
	void stopListening() {
		Soketas temp = ImportantObjects.getInstance().getSoketas();
		try {
			temp.getClientSocket().close();
		} catch (IOException e) {
			System.exit(0);
			e.printStackTrace();
		}
	}
	
	void emptyUI() {
		FrameSetup.onLeaveServer();
	}
	
	void nullValues() {
		ImportantObjects.getInstance().setClientFacade(null);
		ImportantObjects.getInstance().setSoketas(null);
	}
}
