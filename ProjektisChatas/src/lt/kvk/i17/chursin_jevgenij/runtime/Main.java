package lt.kvk.i17.chursin_jevgenij.runtime;

import lt.kvk.i17.chursin_jevgenij.singleton.Config;
import lt.kvk.i17.chursin_jevgenij.singleton.ImportantObjects;

public class Main {
	public static void main (String[] args) {
		
		Config.getInstance();
		ImportantObjects.getInstance();
		
		
	}
}
