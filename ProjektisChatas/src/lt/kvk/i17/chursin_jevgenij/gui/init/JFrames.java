package lt.kvk.i17.chursin_jevgenij.gui.init;

import javax.swing.JFrame;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.composite.JFrameObject;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JFrames {
	GUIGroup gg;
	
	public void initFrames() {
		gg = ImportantObjects.getInstance().getGUIGroup();
		
		JFrame startframe = new JFrame("Main menu");
		startframe.setSize(400, 400);
		startframe.setVisible(false);
		addToGroup("STARTFRAME", startframe);
		
		JFrame settings = new JFrame("Settings");
		settings.setSize(300, 300);
		settings.setVisible(false);
		addToGroup("SETTINGSFRAME", settings);
		
		JFrame join = new JFrame("Join Chat");
		join.setSize(400, 400);
		join.setVisible(false);
		addToGroup("JOINFRAME", join);
		
		JFrame main = new JFrame("Chat Window");
		main.setSize(600, 600);
		main.setVisible(false);
		addToGroup("MAINFRAME", join);
		
		JFrame infoframe = new JFrame("Chat room information");
		infoframe.setSize(400, 400);
		infoframe.setVisible(false);
		addToGroup("INFOFRAME", infoframe);
	}
	
	void addToGroup(String name, JFrame frame) {
		gg.add(new JFrameObject(name, frame));
	}
}
