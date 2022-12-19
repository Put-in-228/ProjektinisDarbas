package lt.kvk.i17.chursin_jevgenij.composite;


import lt.kvk.i17.chursin_jevgenij.gui.jframes.Frame;

public class JFrameObject extends GUIComponent{
	private final String name;
	private final Frame frame;
	
	public JFrameObject(String name, Frame frame) {
		this.name = name;
		this.frame = frame;
	}
	
	public Frame getFrame() {
		return frame;
	}
	
	String getName() {
		return name;
	}
}
