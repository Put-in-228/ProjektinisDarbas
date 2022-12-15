package lt.kvk.i17.chursin_jevgenij.composite;

import javax.swing.JPanel;

public class JPanelObject extends GUIComponent{
	private String name;
	private JPanel panel;
	
	JPanelObject(String name, JPanel panel) {
		this.name = name;
		this.panel = panel;
	}
	
	public JPanel getPane() {
		return panel;
	}
	
	String getName() {
		return name;
	}
}
