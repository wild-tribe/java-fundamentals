package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

public class ServerSocketBuildTest {

	public static void buildUsePort() {
		try {
			System.out.println("build ServerSocket use port");
			// port - the port number, or 0 to use a port number that is automatically allocated.
			// default backlog 50
			ServerSocket server = new ServerSocket(8888);
			System.out.println(server);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildUsePortAndBacklog() {
		try {
			System.out.println("build ServerSocket use port and backlog");
			// port - the port number, or 0 to use a port number that is automatically allocated.
			// if backlog < 1 then use the default value 50
			ServerSocket server = new ServerSocket(8888, 10);
			System.out.println(server);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildWithAssignedLocalNetInterface() {
		try {
			System.out.println("build ServerSocket with assigned local net interface");
			// port - the port number, or 0 to use a port number that is automatically allocated.
			// if backlog < 1 then use the default value 50
			ServerSocket server = new ServerSocket(8888, 10, InetAddress.getByName("172.21.220.51"));
			System.out.println(server);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildUnboundServerSocket() {
		
		try {
			System.out.println("build unbound ServerSocket");
			ServerSocket server = new ServerSocket();
			// 稍后处理
			SocketAddress addr = new InetSocketAddress(80);
			server.bind(addr);
			//OR
//			server.bind(addr, 100);
			System.out.println(server);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
//		buildUsePort();
//		buildUsePortAndBacklog();
//		buildWithAssignedLocalNetInterface();
		buildUnboundServerSocket();
	}
	
}