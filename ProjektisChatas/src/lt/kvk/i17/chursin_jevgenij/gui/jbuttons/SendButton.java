package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.communication.CommunicationMethodsOut;
import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class SendButton extends JButton {
	SendButton() {
		this.setBounds(30, 430, 140, 60);
		this.setText("Send");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("INPUTFIELD");
				
				if (ImportantObjects.getInstance().getObserverObject() == null) {
					CommunicationMethodsOut.sendString(ImportantObjects.getInstance().getSoketas().getOutput(), temp.getTextArea().getText());
				} else {
					ImportantObjects.getInstance().getObserverObject().setMessage(temp.getTextArea().getText());
				}
			}
			
		});
	}
}
