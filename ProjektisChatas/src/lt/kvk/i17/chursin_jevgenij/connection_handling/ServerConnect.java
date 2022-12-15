package lt.kvk.i17.chursin_jevgenij.connection_handling;

import java.io.IOException;
import java.net.Socket;

public class ServerConnect {
	public static Socket connStart(String ip, int port) {
		Socket conn = null;
		int check = 0;
		while (check < 3) {
			System.out.println("Trying to connect to the server!");
			
			try {
				conn = new Socket(ip, port);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (conn != null) {
				return conn;
			}
		}
		
		return null;
	}
}
