package lt.kvk.i17.chursin_jevgenij.clientread;

import java.io.DataInputStream;

import lt.kvk.i17.chursin_jevgenij.communication.CommunicationMethodsIn;
import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class ClientRead {
	public void read(DataInputStream in) {
		boolean check = true;
		
		String prefix = "/";
		
		while (check == true) {
			int amount = CommunicationMethodsIn.readInteger(in);
			
			String msg = CommunicationMethodsIn.readMsg(in, amount);
			
			if (msg.substring(0, 1).equals(prefix)) {
				//Disconnect
			} else {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("OUTPUTFIELD");
				temp.getTextArea().append(msg);
			}
		}
	}
}
