package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class ShowUsersButton extends JButton {
	public ShowUsersButton() {
		this.setBounds(30, 100, 140, 70);
		this.setText("Show Users");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup();
				
				temp.get("USERSFRAME").getFrame().showFrame();
			}
			
		});
	}
}
