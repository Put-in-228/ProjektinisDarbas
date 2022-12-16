package lt.kvk.i17.chursin_jevgenij.communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CommunicationMethodsOut {
	public static void sendString(DataOutputStream connOut, String msg) {
		byte[] msgInBytes = null;
		try {
			msgInBytes = msg.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (msgInBytes != null) {
			try {
				connOut.writeInt(msgInBytes.length);
				connOut.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
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
