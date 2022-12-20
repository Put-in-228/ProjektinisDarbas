package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class Settings extends Frame {
	public Settings() {
		this.setSize(400, 400);
		this.setVisible(false);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				GUIComponent group = ImportantObjects.getInstance().getGUIGroup();
				
				group.get("SETTINGSFRAME").getFrame().setVisible(false);
				group.get("MAINMENUFRAME").getFrame().setVisible(true);
			}
			
		});
	}
}
