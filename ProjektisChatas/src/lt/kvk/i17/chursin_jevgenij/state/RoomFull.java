package lt.kvk.i17.chursin_jevgenij.state;

import lt.kvk.i17.chursin_jevgenij.builder.Soketas;

public class RoomFull implements RoomSpaceState {

	RoomSpace roomSpace;
	
	RoomFull(RoomSpace roomSpace) {
		this.roomSpace = roomSpace;
	}
	
	@Override
	public void acceptConnections(Soketas server) {
		System.out.println("Room is full!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
