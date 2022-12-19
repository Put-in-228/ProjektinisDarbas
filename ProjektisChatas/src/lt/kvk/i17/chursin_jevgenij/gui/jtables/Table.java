package lt.kvk.i17.chursin_jevgenij.gui.jtables;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract class Table extends JTable {
	public void refresh() {
		throw new UnsupportedOperationException();
	}
	
	public JScrollPane getScrollPane() {
		throw new UnsupportedOperationException();
	}
	
	public String getSelectedBannedWord() {
		throw new UnsupportedOperationException();
	}
}
