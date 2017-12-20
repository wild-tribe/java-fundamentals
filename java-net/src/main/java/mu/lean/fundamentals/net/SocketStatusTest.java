package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketStatusTest {
	
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
		System.out.println("socket closed: " + socket.isClosed());
		System.out.println("socket connected: " + socket.isConnected());
		System.out.println("socket bound local: " + socket.isBound());
		
		System.out.println("socket input shutdown: " + socket.isInputShutdown());
		System.out.println("socket output shutdown: " + socket.isOutputShutdown());
		
		System.out.println();
		System.out.println("shutdown input.");
		socket.shutdownInput();
		System.out.println("socket input shutdown: " + socket.isInputShutdown());
		
		System.out.println();
		System.out.println("shutdown output.");
		socket.shutdownOutput();
		System.out.println("socket output shutdown: " + socket.isOutputShutdown());
		
		System.out.println();
		socket.close();
		System.out.println("close socket.");
		System.out.println("socket closed: " + socket.isClosed());
		System.out.println("socket connected: " + socket.isConnected());
		
		
	}

}
