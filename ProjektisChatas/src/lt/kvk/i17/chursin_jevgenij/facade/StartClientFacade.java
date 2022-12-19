package lt.kvk.i17.chursin_jevgenij.facade;

public class StartClientFacade {
	private final String ip;
	private final int port;
	private final StartClient instance;
	
	public StartClientFacade(String ip, int port, StartClient instance) {
		this.ip = ip;
		this.port = port;
		this.instance = instance;
	}

	public void start() {
		instance.setupValues(ip, port);
		instance.getUI();
		instance.startListening();
	}
	
	public void stop() {
		
	}
}
