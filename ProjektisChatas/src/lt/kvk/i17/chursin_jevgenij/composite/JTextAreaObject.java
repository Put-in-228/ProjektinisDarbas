package lt.kvk.i17.chursin_jevgenij.composite;

import javax.swing.JTextArea;

public class JTextAreaObject extends GUIComponent {
	private final String name;
	private final JTextArea textArea;
	
	public JTextAreaObject(String name, JTextArea textArea) {
		this.name = name;
		this.textArea = textArea;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
	
	String getName() {
		return name;
	}
}
