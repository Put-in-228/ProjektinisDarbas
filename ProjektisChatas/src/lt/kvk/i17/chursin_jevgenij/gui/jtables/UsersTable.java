package lt.kvk.i17.chursin_jevgenij.gui.jtables;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import lt.kvk.i17.chursin_jevgenij.filter.Criteria;
import lt.kvk.i17.chursin_jevgenij.object_pool.ConnectedClientThread;
import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class UsersTable extends Table {
	JScrollPane scPane;
	
	public UsersTable() {
		scPane = new JScrollPane(this);
		scPane.setBounds(20,20,300,260);
	}
	
	public void refresh() {
		List<ConnectedClientThread> list = ImportantObjects.getInstance().getObjectPool().getClients();
		
		String data[][] = new String[list.size()+1][2];
		
		data[0][0] = Config.getInstance().getUserName();
		data[0][1] = "local";
		
		if (list.size() > 0) {
			int index = 1;
			
			for (ConnectedClientThread v : list) {
				data[index][0] = v.getUserName();
				data[index][1] = v.getIP();
				index++;
			}
		}
		
		String cols[] = {"Username", "IP"};
		
		DefaultTableModel temp = new DefaultTableModel(data, cols);
		
		this.setModel(temp);
		this.repaint();
	}
	
	public JScrollPane getScrollPane() {
		return scPane;
	}
}
