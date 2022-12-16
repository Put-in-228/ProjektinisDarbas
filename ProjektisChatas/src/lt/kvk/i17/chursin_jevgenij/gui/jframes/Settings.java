package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import javax.swing.JFrame;

public class Settings extends JFrame implements Frame {
	Settings() {
		this.setSize(400, 400);
		this.setVisible(false);
		this.setLayout(null);
	}
	
	public void setVisibility(boolean state) {
		this.setVisible(state);
	}
}
