package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.facade.StartClient;
import lt.kvk.i17.chursin_jevgenij.facade.StartClientFacade;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JoinChatButton extends JButton {
	public JoinChatButton() {
		this.setBounds(30, 230, 140, 70);
		this.setText("Join");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup();
				
				String ip = temp.get("INPUTCONNIPTEXT").getTextArea().getText();
				String portString = temp.get("INPUTCONNPORTTEXT").getTextArea().getText();
				
				if (ip.length() < 1 || portString.length() < 1) {
					JOptionPane.showMessageDialog(temp.get("JOINCHATFRAME").getFrame(), "Please typing all the needed values and try again!");
					
					return;
				}
				
				int port = Integer.parseInt(portString);
				
				StartClient main = new StartClient();
				StartClientFacade facade = new StartClientFacade(ip, port, main);
				
				ImportantObjects.getInstance().setClientFacade(facade);
				
				temp.get("JOINCHATFRAME").getFrame().setVisible(false);
				
				facade.start();
				
				temp.get("MAINFRAME").getFrame().setVisible(true);
			}
			
		});
	}
}
