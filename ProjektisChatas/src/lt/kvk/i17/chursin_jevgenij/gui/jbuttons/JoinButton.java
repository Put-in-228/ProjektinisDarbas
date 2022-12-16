package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JoinButton extends JButton {
	JoinButton() {
		this.setBounds(230, 250, 140, 70);
		this.setText("Join Chat");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("MAINMENU");
				temp.getFrame().setVisible(false);
				
				GUIComponent joinframe = ImportantObjects.getInstance().getGUIGroup().get("JOINFRAME");
				joinframe.getFrame().setVisible(true);
			}
			
		});
	}
}
