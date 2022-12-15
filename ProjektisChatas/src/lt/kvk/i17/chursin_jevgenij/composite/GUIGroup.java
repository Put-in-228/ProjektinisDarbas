package lt.kvk.i17.chursin_jevgenij.composite;

import java.util.LinkedList;
import java.util.List;

public class GUIGroup extends GUIComponent {
	
	List<GUIComponent> buttons = new LinkedList<>();
	
	public void add(GUIComponent button) {
		buttons.add(button);
	}
	
	public void remove(GUIComponent button) {
		buttons.remove(button);
	}
	
	public GUIComponent get(String name) {
		for (GUIComponent v : buttons) {
			if (name.equals(v.getName())) {
				return v;
			}
		}
		
		return null;
	}
}
