package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class SettingsButton extends JButton {
	SettingsButton() {
		this.setBounds(250, 20, 100, 70);
		this.setText("Settings");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("MAINMENU");
				temp.getFrame().setVisible(false);
				
				GUIComponent settings = ImportantObjects.getInstance().getGUIGroup().get("SETTINGSFRAME");
				settings.getFrame().setVisible(true);
			}
			
		});
	}
}
