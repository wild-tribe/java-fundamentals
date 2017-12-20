package mu.lean.fundamentals.net;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDataProcessTest {
	
	private static Socket getSocket() {
		try {
			return new Socket("sso.teamshub.com", 80);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeTest(Socket socket) {
		System.out.println("socket write data start...");
		try {
			OutputStream buffered = new BufferedOutputStream(socket.getOutputStream());
			Writer out = new OutputStreamWriter(buffered);
			out.write("GET / HTTP 1.0\r\n\r\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("socket write data end.");
	}
	
	public static void readTest(Socket socket) {
		System.out.println("socket read data start...");
		try {
			InputStream in = socket.getInputStream();
			int c;
			while((c = in.read()) != -1)
				System.out.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("socket read data end.");
	}
	
	public static void main(String[] args) {
		Socket socket = getSocket();
		if(socket == null) {
			System.out.println("socket is null, check your net settings.");
			return;
		}
		
		System.out.println("socket: " + socket);
		writeTest(socket);
		readTest(socket);
	}

}
