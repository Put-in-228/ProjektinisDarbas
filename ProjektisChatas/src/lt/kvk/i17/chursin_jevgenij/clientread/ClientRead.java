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
		String muted = "muted";
		String unmute = "unmute";
		String username = "username";
		String mute = "mute";
		String kick = "kick";
		
		while (check == true) {
			int amount = -1;
			
			amount = CommunicationMethodsIn.readInteger(in);
			
			if (amount == -1) {
				break;
			}
			
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
				
				if (msg.substring(1).equals(muted)) {
					GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("OUTPUTTEXT");
					temp.getTextArea().append("You are muted" + "\n");
				}
				
				if (msg.substring(1).equals(unmute)) {
					GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("OUTPUTTEXT");
					temp.getTextArea().append("You have been unmuted" + "\n");
				}
				
				if (msg.substring(1).equals(kick)) {
					GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("MAINFRAME");
					temp.getFrame().setVisible(false);
					
					GUIComponent temp2 = ImportantObjects.getInstance().getGUIGroup().get("MAINMENUFRAME");
					temp2.getFrame().setVisible(true);
				}
			} else {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("OUTPUTTEXT");
				temp.getTextArea().append(msg + "\n");
			}
		}
		
		GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("MAINFRAME");
		temp.getFrame().setVisible(false);
		
		GUIComponent temp2 = ImportantObjects.getInstance().getGUIGroup().get("MAINMENUFRAME");
		temp2.getFrame().setVisible(true);
	}
}
