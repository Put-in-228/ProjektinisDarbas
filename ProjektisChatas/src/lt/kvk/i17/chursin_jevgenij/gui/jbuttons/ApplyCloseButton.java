package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class ApplyCloseButton extends JButton {
	public ApplyCloseButton() {
		this.setBounds(130, 250, 140, 70);
		this.setText("Apply & Close");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent amount = ImportantObjects.getInstance().getGUIGroup().get("INPUTAMOUNTTEXT");
				Config.getInstance().setAmount(Integer.parseInt(amount.getTextArea().getText()));
				
				GUIComponent port = ImportantObjects.getInstance().getGUIGroup().get("INPUTPORTTEXT");
				Config.getInstance().setPort(Integer.parseInt(port.getTextArea().getText()));
				
				GUIComponent username = ImportantObjects.getInstance().getGUIGroup().get("INPUTUSERNAMETEXT");
				Config.getInstance().setName(username.getTextArea().getText());
				
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("SETTINGSFRAME");
				temp.getFrame().setVisible(false);
				
				GUIComponent main = ImportantObjects.getInstance().getGUIGroup().get("MAINMENUFRAME");
				main.getFrame().setVisible(true);
			}
			
		});
	}
}
