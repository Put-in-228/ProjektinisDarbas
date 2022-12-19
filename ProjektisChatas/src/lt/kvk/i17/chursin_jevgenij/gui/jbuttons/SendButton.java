package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.communication.CommunicationMethodsOut;
import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.functions.ConstructMsg;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class SendButton extends JButton {
	public SendButton() {
		this.setBounds(30, 430, 140, 60);
		this.setText("Send");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("INPUTFIELD");
				
				if (ImportantObjects.getInstance().getServerFacade() == null) {
					CommunicationMethodsOut.sendString(ImportantObjects.getInstance().getSoketas().getOutput(), temp.getTextArea().getText());
				} else {
					String msg = String.join(" ", ImportantObjects.getInstance().getCriteriaGroup().runThroughFilter(temp.getTextArea().getText().split(" ")));
					msg = ConstructMsg.constructMessage(msg, Config.getInstance().getUserName());
					ImportantObjects.getInstance().getObserverObject().setMessage(msg);
					GUIComponent output = ImportantObjects.getInstance().getGUIGroup().get("OUTPUTFIELD");
					output.getTextArea().append(msg);
				}
			}
			
		});
	}
}
