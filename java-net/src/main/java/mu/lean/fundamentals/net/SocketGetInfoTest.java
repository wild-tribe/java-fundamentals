package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketGetInfoTest {
	
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

	public static void getInetAddressTest(Socket socket) {
		System.out.println("socket InetAddress: " + socket.getInetAddress());
	}
	
	public static void getPortTest(Socket socket) {
		System.out.println("socket port: " + socket.getPort());
	}
	
	public static void getLocalPortTest(Socket socket) {
		System.out.println("socket local port: " + socket.getLocalPort());
	}
	
	public static void getLocalAddressTest(Socket socket) {
		System.out.println("socket local address: " + socket.getLocalAddress());
	}

	public static void main(String[] args) {
		Socket socket = getSocket();
		if(socket == null) {
			System.out.println("socket is null, check your net settings.");
			return;
		}
		
		System.out.println("socket: " + socket);
//		getInetAddressTest(socket);
//		getPortTest(socket);
//		getLocalPortTest(socket);
//		getLocalAddressTest(socket);
	}

}
