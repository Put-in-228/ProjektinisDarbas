package lt.kvk.i17.chursin_jevgenij.gui.jtextfields;

import javax.swing.JTextArea;

import lt.kvk.i17.chursin_jevgenij.singleton.Config;

public class InputUserName extends JTextArea {
	InputUserName() {
		this.setBounds(100, 130, 200, 40);
		this.setEditable(true);
		this.setText(Config.getInstance().getUserName());
	}
}
