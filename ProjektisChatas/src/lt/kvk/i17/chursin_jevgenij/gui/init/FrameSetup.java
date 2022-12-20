package lt.kvk.i17.chursin_jevgenij.gui.init;

import javax.swing.JPanel;

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
		
		Frame join = group.get("JOINCHATFRAME").getFrame();
		join.add(group.get("INPUTCONNIPTEXT").getTextArea());
		join.add(group.get("INPUTCONNPORTTEXT").getTextArea());
		join.add(group.get("JOINCHATBUTTON").getButton());
		join.add(group.get("CANCELBUTTON").getButton());
		
		mainmenu.setVisible(true);
	}
	
	public static void onJoinServer() {
		GUIComponent group = ImportantObjects.getInstance().getGUIGroup();
		
		Frame mainframe = group.get("MAINFRAME").getFrame();
		
		mainframe.getContentPane().removeAll();
		
		JPanel buttons = group.get("BUTTONSPANEL").getPane();
		JPanel textfields = group.get("TEXTFIELDSPANEL").getPane();
		
		buttons.removeAll();
		textfields.removeAll();
		
		textfields.add(group.get("INPUTCHATTEXT").getTextArea());
		textfields.add(group.get("OUTPUTTEXT").getTextArea());
		buttons.add(group.get("SENDBUTTON").getButton());
		buttons.add(group.get("DISCONNECTBUTTON").getButton());
		
		mainframe.add(textfields);
		mainframe.add(buttons);
		
		mainframe.validate();
		
		mainframe.repaint();
	}
	
	public static void onHostServer() {
		GUIComponent group = ImportantObjects.getInstance().getGUIGroup();
		
		Frame mainframe = group.get("MAINFRAME").getFrame();
		
		mainframe.getContentPane().removeAll();
		
		JPanel buttons = group.get("BUTTONSPANEL").getPane();
		JPanel textfields = group.get("TEXTFIELDSPANEL").getPane();
		
		buttons.removeAll();
		textfields.removeAll();
		
		textfields.add(group.get("INPUTCHATTEXT").getTextArea());
		textfields.add(group.get("OUTPUTTEXT").getTextArea());
		buttons.add(group.get("SENDBUTTON").getButton());
		buttons.add(group.get("DISCONNECTBUTTON").getButton());
		buttons.add(group.get("SHOWCRITERIABUTTON").getButton());
		buttons.add(group.get("SHOWINFOBUTTON").getButton());
		buttons.add(group.get("SHOWUSERSBUTTON").getButton());
		
		mainframe.add(textfields);
		mainframe.add(buttons);
		
		Frame criteria = group.get("CRITERIAFRAME").getFrame();
		
		criteria.getContentPane().removeAll();
		
		criteria.add(group.get("ADDBUTTON").getButton());
		criteria.add(group.get("REMOVEBUTTON").getButton());
		criteria.add(group.get("CRITERIATABLE").getTable().getScrollPane());
		
		Frame users = group.get("USERSFRAME").getFrame();
		
		users.getContentPane().removeAll();
		
		users.add(group.get("USERSTABLE").getTable().getScrollPane());
		
		mainframe.validate();
		criteria.validate();
		users.validate();
		
		mainframe.repaint();
		criteria.repaint();
		users.repaint();
	}
	
	public static void onLeaveServer() {
		GUIComponent group = ImportantObjects.getInstance().getGUIGroup();
		
		Frame mainframe = group.get("MAINFRAME").getFrame();
		
		mainframe.setVisible(false);
		group.get("MAINMENUFRAME").getFrame().setVisible(true);
	}
	
	public static void onStopHost() {
		GUIComponent group = ImportantObjects.getInstance().getGUIGroup();
		
		Frame criteria = group.get("CRITERIAFRAME").getFrame();
		
		Frame users = group.get("USERSFRAME").getFrame();
		
		Frame mainframe = group.get("MAINFRAME").getFrame();
		
		users.setVisible(false);
		criteria.setVisible(false);
		mainframe.setVisible(false);
		group.get("MAINMENUFRAME").getFrame().setVisible(true);
	}
}
