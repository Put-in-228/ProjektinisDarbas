package lt.kvk.i17.chursin_jevgenij.command;

import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClientThread;
import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClients;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class DisconnectClient implements Command {
	
	@Override
	public String execute(String userName) {
		ConnectedClientThread temp = ImportantObjects.getInstance().getObjectPool().findByUsername(userName);
		if (temp == null) {
			return "noclient";
		}
		
		temp.forceDisconnect();
		
		return "s";
	}

}
