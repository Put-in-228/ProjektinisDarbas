package lt.kvk.i17.chursin_jevgenij.gui.init;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.composite.JButtonObject;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JButtons {
	GUIGroup gg;
	
	public void initButtons() {
		gg = ImportantObjects.getInstance().getGUIGroup();
		
		//WelcomeFrame
		JButton host = new JButton("Host chat");
		host.setBounds(100, 300, 100, 40);
		addToGroup("HOST", host);
		
		JButton join = new JButton("Join chat");
		join.setBounds(300, 300, 100, 40);
		addToGroup("JOIN", join);
		
		JButton settings = new JButton("Settings");
		settings.setBounds(400, 10, 100, 40);
		addToGroup("SETTINGS", settings);
		
		//SettingsFrame
		JButton applyclose = new JButton("Apply & Close");
		applyclose.setBounds(150, 400, 100, 40);
		addToGroup("APPLYCLOSE", applyclose);
		
		//JoinFrame
		JButton joinchat = new JButton("Join chat");
		joinchat.setBounds(100, 200, 100, 40);
		addToGroup("JOINCHAT", joinchat);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(400, 200, 100, 40);
		addToGroup("CANCEL", cancel);
		
		//MainFrame
		JButton disconnect = new JButton("Disconnect");
		disconnect.setBounds(100, 100, 100, 40);
		addToGroup("DISCONNECT", disconnect);
		
		JButton showusers = new JButton("Show users");
		showusers.setBounds(200, 100, 100, 40);
		addToGroup("SHOWUSERS", showusers);
		
		JButton showinfo = new JButton("Show information");
		showinfo.setBounds(300, 100, 100, 40);
		addToGroup("SHOWINFO", showinfo);
		
		JButton send = new JButton("Send");
		send.setBounds(400, 100, 100, 40);
		addToGroup("SEND", send);
	}
	
	public void addToGroup(String name, JButton button) {
		gg.add(new JButtonObject(name, button));
	}
}
