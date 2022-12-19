package lt.kvk.i17.chursin_jevgenij.gui.init;

import javax.swing.JPanel;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.composite.JPanelObject;
import lt.kvk.i17.chursin_jevgenij.gui.jpanels.Buttons;
import lt.kvk.i17.chursin_jevgenij.gui.jpanels.TextFields;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JPanels {
	static GUIGroup gg;
	
	public static void initPanes() {
		gg = ImportantObjects.getInstance().getGUIGroup();
		
		Buttons buttons = new Buttons();
		addToGroup("BUTTONSPANEL", buttons);
		
		TextFields textfields = new TextFields();
		addToGroup("TEXTFIELDSPANEL", textfields);
	}
	
	static void addToGroup(String name, JPanel frame) {
		gg.add(new JPanelObject(name, frame));
	}
}
