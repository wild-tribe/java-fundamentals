package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class SocketAddressTest {
	
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
	
	public static void main(String[] args) throws IOException {
		Socket socket = getSocket();
		if(socket == null) {
			System.out.println("socket is null, check your net settings.");
			return;
		}
		System.out.println("socket: " + socket);
		
		System.out.println();
		System.out.println("socket's remote SocketAddress: " + socket.getRemoteSocketAddress());
		System.out.println("socket's local SocketAddress: " + socket.getLocalSocketAddress());
	
		SocketAddress socketAddress = socket.getRemoteSocketAddress();
		
		socket.close();
		
		Socket socket1 = new Socket();
		System.out.println();
		System.out.println("socket1's remote SocketAddress: " + socket1.getRemoteSocketAddress());
		System.out.println("socket1's local SocketAddress: " + socket1.getLocalSocketAddress());
		socket1.connect(socketAddress);
		System.out.println("socket1: " + socket1);
		
		socket1.close();
	}

}
