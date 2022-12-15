package lt.kvk.i17.chursin_jevgenij.composite;

import javax.swing.JFrame;

public class JFrameObject extends GUIComponent{
	private String name;
	private JFrame frame;
	
	JFrameObject(String name, JFrame frame) {
		this.name = name;
		this.frame = frame;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	String getName() {
		return name;
	}
}
