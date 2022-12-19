package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.filter.Criteria;
import lt.kvk.i17.chursin_jevgenij.filter.CriteriaFactory;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class AddButton extends JButton {
	public AddButton() {
		this.setBounds(40, 300, 120, 50);
		this.setText("Add Criteria");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup();
				
				String bannedword = JOptionPane.showInputDialog(temp.get("CRITERIAFRAME").getFrame(), "Input word to be censored: ", null);
				
				if (bannedword.length() > 0) {
					Criteria newBannedword = new CriteriaFactory(bannedword);
					ImportantObjects.getInstance().getCriteriaGroup().add(newBannedword);
					
					temp.get("CRITERIATABLE").getTable().refresh();
				}
			}
			
		});
	}
}
