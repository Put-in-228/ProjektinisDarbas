package lt.kvk.i17.chursin_jevgenij.state;

import lt.kvk.i17.chursin_jevgenij.builder.Soketas;

public interface RoomSpaceState {
	
	void acceptConnections(Soketas server);
	void passCurrentSpace(int currentSpace);
}
