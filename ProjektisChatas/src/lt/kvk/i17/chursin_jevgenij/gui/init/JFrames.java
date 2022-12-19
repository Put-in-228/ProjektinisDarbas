package lt.kvk.i17.chursin_jevgenij.gui.init;



import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.composite.JFrameObject;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.CriteriaFrame;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.Frame;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.Information;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.JoinChat;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.MainFrame;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.MainMenu;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.Settings;
import lt.kvk.i17.chursin_jevgenij.gui.jframes.Users;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JFrames {
	static GUIGroup gg;
	
	public static void initFrames() {
		gg = ImportantObjects.getInstance().getGUIGroup();
		
		CriteriaFrame criteria = new CriteriaFrame();
		addToGroup("CRITERIAFRAME", criteria);
		
		Information information = new Information();
		addToGroup("INFORMATIONFRAME", information);
		
		JoinChat joinchat = new JoinChat();
		addToGroup("JOINCHATFRAME", joinchat);
		
		MainFrame mainframe = new MainFrame();
		addToGroup("MAINFRAME", mainframe);
		
		MainMenu mainmenu = new MainMenu();
		addToGroup("MAINMENUFRAME", mainmenu);
		
		Settings settings = new Settings();
		addToGroup("SETTINGSFRAME", settings);
		
		Users users = new Users();
		addToGroup("USERSFRAME", users);
	}
	
	static void addToGroup(String name, Frame frame) {
		gg.add(new JFrameObject(name, frame));
	}
}
