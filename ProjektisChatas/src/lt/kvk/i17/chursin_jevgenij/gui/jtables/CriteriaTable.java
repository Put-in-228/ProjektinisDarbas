package lt.kvk.i17.chursin_jevgenij.gui.jtables;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import lt.kvk.i17.chursin_jevgenij.filter.Criteria;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class CriteriaTable extends Table {
	JScrollPane scPane;
	
	public CriteriaTable() {
		scPane = new JScrollPane(this);
		scPane.setBounds(20,20,360,260);
		this.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void refresh() {
		List<Criteria> list = ImportantObjects.getInstance().getCriteriaGroup().getCriterias();
		
		String data[][] = new String[list.size()][2];
		
		if (list.size() > 0) {
			int index = 0;
			
			for (Criteria v : list) {
				data[index][0] = String.valueOf(index);
				data[index][1] = v.getBannedWord();
				index++;
			}
		}
		
		String cols[] = {"ID", "Banned word"};
		
		DefaultTableModel temp = new DefaultTableModel(data, cols);
		
		this.setModel(temp);
		this.repaint();
	}
	
	public JScrollPane getScrollPane() {
		return scPane;
	}
	
	public String getSelectedBannedWord() {
		int row = this.getSelectedRow();
		
		if (row == -1) {
			return null;
		}
		
		String value = (String) this.getValueAt(row, 1);
		System.out.println(value);
		return value;
	}
}
