package lt.kvk.i17.chursin_jevgenij.filter;

import java.util.LinkedList;
import java.util.List;

public class CriteriaGroup {
	List<Criteria> criterias = new LinkedList<>();
	
	public void add(Criteria criteria) {
		criterias.add(criteria);
	}
	
	public void remove(Criteria criteria) {
		criterias.remove(criteria);
	}
	
	public String[] runThroughFilter(String[] words) {
		if (criterias.size() > 0) {
			for (Criteria v : criterias) {
				words = v.criteria(words);
			}
		}
		
		return words;
	}
	
	public List<Criteria> getCriterias() {
		return criterias;
	}
}
