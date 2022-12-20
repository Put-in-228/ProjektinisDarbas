package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class MainMenu extends Frame {
	public MainMenu() {
		this.setSize(400, 400);
		this.setVisible(false);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
}
