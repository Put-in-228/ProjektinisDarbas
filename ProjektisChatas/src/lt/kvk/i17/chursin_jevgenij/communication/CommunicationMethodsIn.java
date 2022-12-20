package lt.kvk.i17.chursin_jevgenij.communication;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class CommunicationMethodsIn {
	public static int readInteger(DataInputStream connIn) {
		byte[] integerToRead = new byte[4];
		for (int i = 0; i < 4; i++) {
			try {
				integerToRead[i] = connIn.readByte();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		}
		
		ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
		buffer.put(integerToRead);
		buffer.rewind();
		int valueToReturn = buffer.getInt();
		return valueToReturn;
	}
	
	public static String readMsg (DataInputStream connIn, int amount) {
		byte[] bytesToRead = new byte[amount];
		for (int i = 0; i < amount; i++) {
			try {
				bytesToRead[i] = connIn.readByte();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		ByteBuffer buffer = ByteBuffer.allocate(amount);
		buffer.put(bytesToRead);
		buffer.rewind();
		
		String msg = null;
		
		try {
			msg = new String(bytesToRead, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (msg != null) {
			return msg;
		}
		
		return null;
	}
}
