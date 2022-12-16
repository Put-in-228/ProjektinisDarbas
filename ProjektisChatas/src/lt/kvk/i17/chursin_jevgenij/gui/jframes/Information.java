package lt.kvk.i17.chursin_jevgenij.gui.jframes;

import javax.swing.JFrame;

public class Information extends JFrame implements Frame {
	Information() {
		this.setSize(400, 400);
		this.setVisible(false);
		this.setLayout(null);
	}
	
	@Override
	public void setVisibility(boolean state) {
		this.setVisible(state);
	}

}
