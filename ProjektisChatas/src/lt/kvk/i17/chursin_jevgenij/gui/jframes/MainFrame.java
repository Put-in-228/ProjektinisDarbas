package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements Frame {
	MainFrame() {
		this.setSize(600, 600);
		this.setVisible(false);
		this.setLayout(null);
	}
	
	public void setVisibility(boolean state) {
		this.setVisible(state);
	}
}
