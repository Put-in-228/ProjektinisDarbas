package lt.kvk.i17.chursin_jevgenij.runtime;

import com.dosse.upnp.UPnP;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.gui.init.FrameSetup;
import lt.kvk.i17.chursin_jevgenij.gui.init.JButtons;
import lt.kvk.i17.chursin_jevgenij.gui.init.JFrames;
import lt.kvk.i17.chursin_jevgenij.gui.init.JPanels;
import lt.kvk.i17.chursin_jevgenij.gui.init.JTables;
import lt.kvk.i17.chursin_jevgenij.gui.init.JTextFields;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class Main {
	public static void main (String[] args) {
		
		Config.getInstance();
		ImportantObjects.getInstance();
		
		ImportantObjects.getInstance().setGUIGroup(new GUIGroup());
		
		JButtons.initButtons();
		JFrames.initFrames();
		JPanels.initPanes();
		JTables.initTables();
		JTextFields.initTextFields();
		
		FrameSetup.onStart();
		
		UPnP.closePortTCP(7898);
	}
}
