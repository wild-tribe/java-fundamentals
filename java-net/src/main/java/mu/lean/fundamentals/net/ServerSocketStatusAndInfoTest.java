package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

public class ServerSocketStatusAndInfoTest {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket();
		System.out.println("server is bound: " + server.isBound());
		System.out.println("server is closed: " + server.isClosed());
		
		SocketAddress addr = new InetSocketAddress(80);
		server.bind(addr);
		System.out.println("server is bound: " + server.isBound());
		System.out.println("server local port: " + server.getLocalPort());
		System.out.println("server local InetAddress: " + server.getInetAddress());
		
		server.close();
		System.out.println("server is closed: " + server.isClosed());
	}
	
}