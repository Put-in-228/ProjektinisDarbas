package lt.kvk.i17.chursin_jevgenij.connection_handling;

import java.io.IOException;
import java.net.ServerSocket;

public class StartServer {
	public static ServerSocket connStart(int port, int amount) {
		ServerSocket conn = null;
		while (true) {
			System.out.println("Trying to start the server!");
			
			try {
				conn = new ServerSocket(port, amount);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (conn != null) {
				System.out.println("STARTED THE SERVER!");
				return conn;
			}
		}
	}
}
