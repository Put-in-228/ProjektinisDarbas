package lt.kvk.i17.chursin_jevgenij.gui.init;

import javax.swing.JTextArea;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.composite.JTextAreaObject;
import lt.kvk.i17.chursin_jevgenij.gui.jtextfields.InputAmount;
import lt.kvk.i17.chursin_jevgenij.gui.jtextfields.InputChat;
import lt.kvk.i17.chursin_jevgenij.gui.jtextfields.InputConnIP;
import lt.kvk.i17.chursin_jevgenij.gui.jtextfields.InputConnPort;
import lt.kvk.i17.chursin_jevgenij.gui.jtextfields.InputPort;
import lt.kvk.i17.chursin_jevgenij.gui.jtextfields.InputUserName;
import lt.kvk.i17.chursin_jevgenij.gui.jtextfields.Output;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JTextFields {
	static GUIGroup gg;
	
	public static void initTextFields() {
		gg = ImportantObjects.getInstance().getGUIGroup();
		
		InputAmount inputamount = new InputAmount();
		addToGroup("INPUTAMOUNTTEXT", inputamount);
		
		InputChat inputchat = new InputChat();
		addToGroup("INPUTCHATTEXT", inputchat);
		
		InputConnIP inputconnip = new InputConnIP();
		addToGroup("INPUTCONNIPTEXT", inputconnip);
		
		InputConnPort inputconnport = new InputConnPort();
		addToGroup("INPUTCONNPORTTEXT", inputconnport);
		
		InputPort inputport = new InputPort();
		addToGroup("INPUTPORTTEXT", inputport);
		
		InputUserName inputusername = new InputUserName();
		addToGroup("INPUTUSERNAMETEXT", inputusername);
		
		Output output = new Output();
		addToGroup("OUTPUTTEXT", output);
	}
	
	static void addToGroup(String name, JTextArea frame) {
		gg.add(new JTextAreaObject(name, frame));
	}
}
