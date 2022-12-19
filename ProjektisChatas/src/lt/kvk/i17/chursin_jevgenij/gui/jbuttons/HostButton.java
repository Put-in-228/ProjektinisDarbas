package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lt.kvk.i17.chursin_jevgenij.composite.GUIComponent;
import lt.kvk.i17.chursin_jevgenij.facade.StartServer;
import lt.kvk.i17.chursin_jevgenij.facade.StartServerFacade;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class HostButton extends JButton {
	public HostButton() {
		this.setBounds(30, 250, 140, 70);
		this.setText("Host Chat");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StartServer ss = new StartServer();
				StartServerFacade facade = new StartServerFacade(ss);
				
				ImportantObjects.getInstance().setServerFacade(facade);
				
				facade.start();
				
				GUIComponent temp = ImportantObjects.getInstance().getGUIGroup().get("MAINMENUFRAME");
				temp.getFrame().setVisible(false);
				
				GUIComponent main = ImportantObjects.getInstance().getGUIGroup().get("MAINFRAME");
				main.getFrame().setVisible(true);
			}
			
		});
	}
	
	
}
