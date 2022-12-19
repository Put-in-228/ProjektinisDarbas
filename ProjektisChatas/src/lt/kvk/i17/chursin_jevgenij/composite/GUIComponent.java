package lt.kvk.i17.chursin_jevgenij.composite;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import lt.kvk.i17.chursin_jevgenij.gui.jframes.Frame;
import lt.kvk.i17.chursin_jevgenij.gui.jtables.Table;

public abstract class GUIComponent {
	
	public void add(GUIComponent component) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(GUIComponent component) {
		throw new UnsupportedOperationException();
	}
	
	public GUIComponent get(String name) {
		throw new UnsupportedOperationException();
	}
	
	String getName() {
		throw new UnsupportedOperationException();
	}
	
	public JButton getButton() {
		throw new UnsupportedOperationException();
	}
	
	public Frame getFrame() {
		throw new UnsupportedOperationException();
	}
	
	public JPanel getPane() {
		throw new UnsupportedOperationException();
	}
	
	public JTextArea getTextArea() {
		throw new UnsupportedOperationException();
	}
	
	public Table getTable() {
		throw new UnsupportedOperationException();
	}
}
