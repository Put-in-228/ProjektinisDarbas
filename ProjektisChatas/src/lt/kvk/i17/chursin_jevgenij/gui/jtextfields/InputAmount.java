package lt.kvk.i17.chursin_jevgenij.gui.jtextfields;

import javax.swing.JTextArea;

import lt.kvk.i17.chursin_jevgenij.singleton.Config;

public class InputAmount extends JTextArea {
	InputAmount() {
		this.setBounds(100, 10, 200, 40);
		this.setEditable(true);
		this.setText(String.valueOf(Config.getInstance().getAmount()));
	}
}
