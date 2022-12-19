package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.filter.Criteria;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class RemoveButton extends JButton {
	public RemoveButton() {
		this.setBounds(240, 300, 120, 50);
		this.setText("Remove Criteria");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent table = ImportantObjects.getInstance().getGUIGroup().get("CRITERIATABLE");
				
				String bannedword = table.getTable().getSelectedBannedWord();
				
				if (bannedword == null) {
					return;
				}
				
				Criteria criteriaToRemove = ImportantObjects.getInstance().getCriteriaGroup().getCriteriaByBannedWord(bannedword);
				
				ImportantObjects.getInstance().getCriteriaGroup().remove(criteriaToRemove);
				
				table.getTable().refresh();
			}
			
		});
	}
}
