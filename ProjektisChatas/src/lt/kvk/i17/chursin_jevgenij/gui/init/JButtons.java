package lt.kvk.i17.chursin_jevgenij.gui.init;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.composite.JButtonObject;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.AddButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.ApplyCloseButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.CancelButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.DisconnectButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.HostButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.JoinButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.JoinChatButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.RemoveButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.SendButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.SettingsButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.ShowCriteriaButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.ShowInfoButton;
import lt.kvk.i17.chursin_jevgenij.gui.jbuttons.ShowUsersButton;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JButtons {
	static GUIGroup gg;
	
	public static void initButtons() {
		gg = ImportantObjects.getInstance().getGUIGroup();
		
		AddButton add = new AddButton();
		addToGroup("ADDBUTTON", add);
		
		ApplyCloseButton applyclose = new ApplyCloseButton();
		addToGroup("APPLYCLOSEBUTTON", applyclose);
		
		CancelButton cancel = new CancelButton();
		addToGroup("CANCELBUTTON", cancel);
		
		DisconnectButton disconnect = new DisconnectButton();
		addToGroup("DISCONNECTBUTTON", disconnect);
		
		HostButton host = new HostButton();
		addToGroup("HOSTBUTTON", host);
		
		JoinButton join = new JoinButton();
		addToGroup("JOINBUTTON", join);
		
		JoinChatButton joinchat = new JoinChatButton();
		addToGroup("JOINCHATBUTTON", joinchat);
		
		RemoveButton remove = new RemoveButton();
		addToGroup("REMOVEBUTTON", remove);
		
		SendButton send = new SendButton();
		addToGroup("SENDBUTTON", send);
		
		SettingsButton settings = new SettingsButton();
		addToGroup("SETTINGSBUTTON", settings);
		
		ShowCriteriaButton showcriteria = new ShowCriteriaButton();
		addToGroup("SHOWCRITERIABUTTON", showcriteria);
		
		ShowInfoButton showinfo = new ShowInfoButton();
		addToGroup("SHOWINFOBUTTON", showinfo);
		
		ShowUsersButton showusers = new ShowUsersButton();
		addToGroup("SHOWUSERSBUTTON", showusers);
	}
	
	public static void addToGroup(String name, JButton button) {
		gg.add(new JButtonObject(name, button));
	}
}
