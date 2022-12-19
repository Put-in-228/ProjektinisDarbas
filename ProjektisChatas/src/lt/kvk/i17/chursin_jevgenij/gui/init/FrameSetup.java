package lt.kvk.i17.chursin_jevgenij.gui.init;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.Frame;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class FrameSetup {
	public static void onStart() {
		GUIComponent group = ImportantObjects.getInstance().getGUIGroup();
		
		Frame mainmenu = group.get("MAINMENUFRAME").getFrame();
		mainmenu.add(group.get("JOINBUTTON").getButton());
		mainmenu.add(group.get("HOSTBUTTON").getButton());
		mainmenu.add(group.get("SETTINGSBUTTON").getButton());
		
		Frame settings = group.get("SETTINGSFRAME").getFrame();
		settings.add(group.get("APPLYCLOSEBUTTON").getButton());
		settings.add(group.get("INPUTAMOUNTTEXT").getTextArea());
		settings.add(group.get("INPUTPORTTEXT").getTextArea());
		settings.add(group.get("INPUTUSERNAMETEXT").getTextArea());
		
		mainmenu.setVisible(true);
	}
	
	public static void onJoinServer() {
		
	}
	
	public static void onHostServer() {
		
	}
}
