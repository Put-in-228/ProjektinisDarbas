package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class DisconnectButton extends JButton {
	DisconnectButton() {
		this.setBounds(30, 30, 140, 70);
		this.setText("Disconnect");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("MAINFRAME");
				temp.getFrame().setVisible(false);
				
				GUIComponent menu = ImportantObjects.getInstance().getGUIGroup().get("MAINMENU");
				menu.getFrame().setVisible(true);
			}
			
		});
	}
}
