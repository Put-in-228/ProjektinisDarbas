package lt.kvk.i17.chursin_jevgenij.state;

import java.io.IOException;
import java.net.Socket;

import lt.kvk.i17.chursin_jevgenij.builder.Soketas;

public class RoomNotFull implements RoomSpaceState {

	RoomSpace roomSpace;
	
	RoomNotFull(RoomSpace roomSpace) {
		this.roomSpace = roomSpace;
	}
	
	@Override
	public void acceptConnections(Soketas server) {
		Socket conn = null;
		try {
			conn = server.getServerSocket().accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (conn != null) {
			roomSpace.setUpPoolObject(conn);
		}
	}

	@Override
	public void passCurrentSpace(int currentSpace) {
		if(roomSpace.getRoomSpace() == currentSpace) {
			roomSpace.setRoomState(roomSpace.getFullState());
		} else {
			roomSpace.setRoomState(roomSpace.getNotFullState());
		}
	}

}
