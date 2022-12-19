package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import javax.swing.JFrame;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class Users extends Frame {
	public Users() {
		this.setSize(400, 400);
		this.setVisible(false);
		this.setLayout(null);
	}
	
	public void showFrame() {
		this.setVisible(true);
		GUIComponent temp = ImportantObjects.getInstance().getGUIGroup();
		temp.get("USERSTABLE").getTable().refresh();
		this.repaint();
	}
}
