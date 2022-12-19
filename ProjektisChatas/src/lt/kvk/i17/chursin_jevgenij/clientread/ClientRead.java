package lt.kvk.i17.chursin_jevgenij.clientread;

import java.io.DataInputStream;

import lt.kvk.i17.chursin_jevgenij.communication.CommunicationMethodsIn;
import lt.kvk.i17.chursin_jevgenij.communication.CommunicationMethodsOut;
import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class ClientRead {
	public static void read(DataInputStream in) {
		boolean check = true;
		
		String prefix = "/";
		String mute = "muted";
		String username = "username";
		
		while (check == true) {
			int amount = CommunicationMethodsIn.readInteger(in);
			
			String msg = CommunicationMethodsIn.readMsg(in, amount);
			
			if (msg.substring(0, 1).equals(prefix)) {
				System.out.println("MESSAGEWITHPREFIX");
				System.out.println(msg);
				if (msg.substring(1).equals(username)) {
					CommunicationMethodsOut.sendString(ImportantObjects.getInstance().getSoketas().getOutput(), Config.getInstance().getUserName());
				}
				
				if (msg.substring(1).equals(mute)) {
					GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("OUTPUTTEXT");
					temp.getTextArea().append("You have been muted" + "\n");
				}
			} else {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("OUTPUTTEXT");
				temp.getTextArea().append(msg + "\n");
			}
		}
	}
}
