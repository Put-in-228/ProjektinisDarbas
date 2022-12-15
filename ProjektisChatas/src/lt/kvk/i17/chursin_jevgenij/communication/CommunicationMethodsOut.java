package lt.kvk.i17.chursin_jevgenij.communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CommunicationMethodsOut {
	public static void sendInteger(DataOutputStream connOut, int integerToSend) {
		try {
			connOut.writeInt(integerToSend);
			connOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendString(DataOutputStream connOut, String msg) {
		byte[] msgInBytes = null;
		try {
			msgInBytes = msg.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (msgInBytes != null) {
			for(int i = 0; i<msgInBytes.length; i++) {
				try {
					connOut.write(msgInBytes[i]);
					connOut.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
