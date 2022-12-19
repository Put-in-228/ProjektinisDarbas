package lt.kvk.i17.chursin_jevgenij.addthreads;

import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
import lt.kvk.i17.chursin_jevgenij.clientread.ClientRead;

public class ClientReadThread extends Thread {
	Soketas client;
	
	public ClientReadThread(Soketas client) {
		this.client = client;
	}
	
	public void run() {
		ClientRead.read(client.getInput());
	}
}
