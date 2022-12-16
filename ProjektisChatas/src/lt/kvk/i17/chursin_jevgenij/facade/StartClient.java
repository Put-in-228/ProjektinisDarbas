package lt.kvk.i17.chursin_jevgenij.facade;

import lt.kvk.i17.chursin_jevgenij.builder.SocketBuilder;
import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
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
	}
	
	void startListening() {
		
	}
}
