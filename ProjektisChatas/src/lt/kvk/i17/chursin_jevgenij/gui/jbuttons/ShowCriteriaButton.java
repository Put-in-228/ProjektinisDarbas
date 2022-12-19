package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class ShowCriteriaButton extends JButton {
	public ShowCriteriaButton() {
		this.setBounds(30, 280, 140, 70);
		this.setText("Show Criterias");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup();
				
				temp.get("CRITERIAFRAME").getFrame().setVisible(true);
			}
			
		});
	}
}
