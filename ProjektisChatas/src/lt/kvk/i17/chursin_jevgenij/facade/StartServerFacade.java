package lt.kvk.i17.chursin_jevgenij.facade;

public class StartServerFacade {
	private final StartServer ss;
	
	public StartServerFacade(StartServer ss) {
		this.ss = ss;
	}
	
	public void start() {
		ss.openPort();
		ss.setupValues();
		ss.initObjects();
		ss.setupUI();
		ss.startListener();
	}
	
	public void stop() {
		ss.closePort();
		ss.nullObjects();
		ss.nullServer();
		ss.emptyUI();
	}
}
