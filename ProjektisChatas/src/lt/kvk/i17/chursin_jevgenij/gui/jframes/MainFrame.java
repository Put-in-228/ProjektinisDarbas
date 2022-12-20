package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class MainFrame extends Frame {
	public MainFrame() {
		this.setSize(600, 600);
		this.setVisible(false);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				if (ImportantObjects.getInstance().getServerFacade() == null) {
					ImportantObjects.getInstance().getClientFacade().stop();
				} else {
					ImportantObjects.getInstance().getServerFacade().stop();
				}
			}
			
		});
	}
}
