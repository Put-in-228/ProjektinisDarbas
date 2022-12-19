package lt.kvk.i17.chursin_jevgenij.functions;

public class ConstructMsg {
	public static String constructMessage(String msg, String username) {
		String newmsg = username + ": " + msg;
		return newmsg;
	}
}
