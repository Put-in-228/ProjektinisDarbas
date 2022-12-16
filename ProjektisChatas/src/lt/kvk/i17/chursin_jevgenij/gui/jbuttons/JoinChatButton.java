package lt.kvk.i17.chursin_jevgenij.gui.jbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JoinChatButton extends JButton {
	JoinChatButton() {
		this.setBounds(130, 250, 140, 70);
		this.setText("Join");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}
}
