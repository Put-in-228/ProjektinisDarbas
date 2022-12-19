package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class CancelButton extends JButton {
	public CancelButton() {
		this.setBounds(230, 230, 140, 70);
		this.setText("Cancel");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent joinframe = ImportantObjects.getInstance().getGUIGroup().get("JOINCHATFRAME");
				joinframe.getFrame().setVisible(false);
				
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("MAINMENUFRAME");
				temp.getFrame().setVisible(true);
			}
			
		});
	}
}
