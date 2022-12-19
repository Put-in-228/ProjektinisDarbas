package lt.kvk.i17.chursin_jevgenij.gui.init;

import lt.kvk.i17.chursin_jevgenij.composite.GUIGroup;
import lt.kvk.i17.chursin_jevgenij.composite.JTableObject;
import lt.kvk.i17.chursin_jevgenij.gui.jtables.CriteriaTable;
import lt.kvk.i17.chursin_jevgenij.gui.jtables.Table;
import lt.kvk.i17.chursin_jevgenij.gui.jtables.UsersTable;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class JTables {
	static GUIGroup gg;
	
	public static void initTables() {
		gg = ImportantObjects.getInstance().getGUIGroup();
		
		Table criterias = new CriteriaTable();
		addToGroup("CRITERIATABLE", criterias);
		
		Table users = new UsersTable();
		addToGroup("USERSTABLE", users);
	}
	
	static void addToGroup(String name, Table frame) {
		gg.add(new JTableObject(frame, name));
	}
}
