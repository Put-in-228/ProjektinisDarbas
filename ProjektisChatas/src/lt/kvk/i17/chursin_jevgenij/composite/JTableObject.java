package lt.kvk.i17.chursin_jevgenij.composite;

import lt.kvk.i17.chursin_jevgenij.gui.jtables.Table;

public class JTableObject extends GUIComponent {
	private final Table table;
	private final String name;
	
	public JTableObject(Table table, String name) {
		this.table = table;
		this.name = name;
	}
	
	public Table getTable() {
		return this.table;
	}
	
	String getName() {
		return this.name;
	}
}
