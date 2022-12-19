package lt.kvk.i17.chursin_jevgenij.object_pool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import lt.kvk.i17.chursin_jevgenij.communication.CommunicationMethodsIn;
import lt.kvk.i17.chursin_jevgenij.communication.CommunicationMethodsOut;
import lt.kvk.i17.chursin_jevgenij.observer.ServerObserver;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class ConnectedClientThread extends Thread {
	private Socket conn = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	private String userName;
	private boolean muted = false;
	
	private boolean status = true;
	
	private ServerObserver observerObject;
	
	ConnectedClientThread() {
		observerObject = new ServerObserver(this);
	}
	
	public void run() {
		while (status == true) {
			String msg = read();
			if (msg == null) {
				break;
			}
			if (muted == false) {
				msg = String.join(" ", ImportantObjects.getInstance().getCriteriaGroup().runThroughFilter(msg.split(" ")));
				msg = userName + ": " + msg;
				ImportantObjects.getInstance().getObserverObject().setMessage(msg);
			} else {
				send("/muted");
			}
		}
		
		ImportantObjects.getInstance().getObjectPool().returnThread(this);
	}
	
	public void send(String msg) {
		if (in != null && out != null) {
			CommunicationMethodsOut.sendString(out, msg);
		}
	}
	
	private String read() {
		if (in != null && out != null) {
			int length = CommunicationMethodsIn.readInteger(in);
			if (length == -1) {
				return null;
			}
			String msg = CommunicationMethodsIn.readMsg(in, length);
			return msg;
		}
		
		return null;
	}
	
	public void setupThread(Socket conn) {
		this.conn = conn;
		
		try {
			in = new DataInputStream(conn.getInputStream());
			out = new DataOutputStream(conn.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (in != null && out != null) {
			setUserName();
			this.start();
		} else {
			ConnectedClients.returnThread(this);
		}
	}
	
	public void nullObject() {
		conn = null;
		in = null;
		out = null;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void forceDisconnect() {
		send("/kick");
		status = false;
	}
	
	private void setUserName() {
		send("/username");
		userName = read();
	}
	
	public void mute() {
		muted = true;
		send("/mute");
	}
	
	public void unmute() {
		muted = false;
		send("/unmute");
	}
	
	public String getIP() {
		return conn.getInetAddress().toString().substring(1);
	}
	
	public ServerObserver getObserverObject() {return observerObject;}
}
