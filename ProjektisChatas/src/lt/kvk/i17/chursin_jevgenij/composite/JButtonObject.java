package lt.kvk.i17.chursin_jevgenij.composite;

import javax.swing.JButton;

public class JButtonObject extends GUIComponent {
	private final String name;
	private final JButton button;
	
	public JButtonObject(String name, JButton button) {
		this.name = name;
		this.button = button;
	}
	
	public JButton getButton() {
		return button;
	}
	
	String getName() {
		return name;
	}
}
