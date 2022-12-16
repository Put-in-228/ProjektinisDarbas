package lt.kvk.i17.chursin_jevgenij.filter;

public class CriteriaFactory implements Criteria{

	private final String bannedword;
	
	CriteriaFactory(String bannedword) {
		this.bannedword = bannedword;
	}
	
	@Override
	public String[] criteria(String[] words) {
		String[] newWords = words;
		
		for (int i = 0; i<words.length; i++) {
			if (words[i].contains(bannedword)) {
				String newWord = "";
				for (int o = 0; o < words[i].length(); o++) {
					newWord += "*";
				}
				newWords[i] = newWord;
			}
		}
		
		return newWords;
	}

}
