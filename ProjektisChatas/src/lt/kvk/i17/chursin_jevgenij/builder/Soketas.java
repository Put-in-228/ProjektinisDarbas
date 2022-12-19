package lt.kvk.i17.chursin_jevgenij.builder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Soketas {
	private final String userName;
	private ServerSocket sConn;
	private Socket cConn;
	private DataInputStream in;
	private DataOutputStream out;
	
	Soketas(String userName) {
		this.userName = userName;
	}
	
	public void setClient(Socket cConn) {
		this.cConn = cConn;
		
		try {
			this.in = new DataInputStream(cConn.getInputStream());
			this.out = new DataOutputStream(cConn.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setServer(ServerSocket sConn) {
		this.sConn = sConn;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public ServerSocket getServerSocket() {
		return sConn;
	}
	
	public Socket getClientSocket() {
		return cConn;
	}
	
	public DataInputStream getInput() {
		return in;
	}
	
	public DataOutputStream getOutput() {
		return out;
	}
}
