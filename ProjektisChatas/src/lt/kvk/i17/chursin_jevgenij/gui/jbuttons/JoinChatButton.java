package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.facade.StartClient;
import lt.kvk.i17.chursin_jevgenij.facade.StartClientFacade;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JoinChatButton extends JButton {
	public JoinChatButton() {
		this.setBounds(130, 30, 140, 70);
		this.setText("Join");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup();
				
				String ip = temp.get("INPUTCONNIP").getTextArea().getText();
				int port = Integer.parseInt(temp.get("INPUTCONNPORT").getTextArea().getText());
				
				StartClient main = new StartClient();
				StartClientFacade facade = new StartClientFacade(ip, port, main);
				
				ImportantObjects.getInstance().setClientFacade(facade);
				
				facade.start();
			}
			
		});
	}
}
