package lt.kvk.i17.chursin_jevgenij.state;

import java.net.Socket;

import lt.kvk.i17.chursin_jevgenij.builder.Soketas;
import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClientThread;
import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClients;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class RoomSpace {
	RoomSpaceState roomFull;
	RoomSpaceState roomNotFull;
	
	RoomSpaceState roomState;
	
	int chatRoomSpace;
	
	Soketas server;
	
	RoomSpace(Soketas server, ConnectedClients pool) {
		this.server = server;
		this.chatRoomSpace = Config.getInstance().getAmount();
		
		roomFull = new RoomFull(this);
		roomNotFull = new RoomNotFull(this);
		setRoomState(roomNotFull);
	}
	
	void setRoomState(RoomSpaceState newRoomState) {
		this.roomState = newRoomState;
	}
	
	int getRoomSpace() {
		return chatRoomSpace;
	}
	
	void setUpPoolObject(Socket conn) {
		ConnectedClientThread temp = ImportantObjects.getInstance().getObjectPool().getThread();
		temp.setupThread(conn);
	}
	
	public void acceptConnections() {
		roomState.acceptConnections(server);
	}
	
	public void passCurrentSpace(int currentSpace) {
		roomState.passCurrentSpace(currentSpace);
	}
	
	RoomSpaceState getFullState() {return roomFull;}
	RoomSpaceState getNotFullState() {return roomNotFull;}
}
