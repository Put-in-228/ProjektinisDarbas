package lt.kvk.i17.chursin_jevgenij.gui.jtextfields;

import javax.swing.JTextArea;

import lt.kvk.i17.chursin_jevgenij.singleton.Config;

public class InputPort extends JTextArea {
	InputPort() {
		this.setBounds(100, 70, 200, 40);
		this.setEditable(true);
		this.setText(String.valueOf(Config.getInstance().getPort()));
	}
}
