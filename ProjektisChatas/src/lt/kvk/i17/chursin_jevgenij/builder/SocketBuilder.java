package lt.kvk.i17.chursin_jevgenij.builder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.dosse.upnp.UPnP;

import lt.kvk.i17.chursin_jevgenij.connection_handling.ServerConnect;
import lt.kvk.i17.chursin_jevgenij.connection_handling.StartServer;

public class SocketBuilder {
	private int port;
	private String ip = null;
	private int amount;
	private ServerSocket sConn = null;
	private Socket cConn = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	
	private Soketas socketObject;
	
	public SocketBuilder(String userName) {
		socketObject = new Soketas(userName);
	}
	
	public void addPort(int port) {
		this.port = port;
	}
	
	public void addIp(String ip) {
		this.ip = ip;
	}
	
	public void addAmount(int amount) {
		this.amount = amount;
	}
	
	public Soketas build() {
		if (ip == null) {
			sConn = StartServer.connStart(port, amount);
			
			if (sConn != null) {
				socketObject.setServer(sConn);
				return socketObject;
			}
		} else {
			cConn = ServerConnect.connStart(ip, port);
			
			if (cConn != null) {
				socketObject.setClient(cConn);
				return socketObject;
			}
		}
		
		return null;
	}
}
