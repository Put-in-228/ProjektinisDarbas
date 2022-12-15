package lt.kvk.i17.chursin_jevgenij.composite;

import javax.swing.JTextField;

public class JTextFieldObject extends GUIComponent {
	private String name;
	private JTextField textField;
	
	JTextFieldObject(String name, JTextField textField) {
		this.name = name;
		this.textField = textField;
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	String getName() {
		return name;
	}
}
