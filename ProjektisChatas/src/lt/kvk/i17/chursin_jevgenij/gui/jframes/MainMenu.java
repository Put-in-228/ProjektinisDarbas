package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import javax.swing.JFrame;

public class MainMenu extends JFrame implements Frame {
	MainMenu() {
		this.setSize(400, 400);
		this.setVisible(false);
		this.setLayout(null);
	}
	
	public void setVisibility(boolean state) {
		this.setVisible(state);
	}
}
