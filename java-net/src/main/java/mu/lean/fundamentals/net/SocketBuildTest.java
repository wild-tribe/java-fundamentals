package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class SocketBuildTest {

	public static void buildUseHost() {
		try {
			System.out.println("build socket use host");
			Socket socket = new Socket("sso.teamshub.com", 80);
			System.out.println(socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildUseInetAddress() {
		try {
			System.out.println("build socket use InetAddress");
			InetAddress inetAddr = InetAddress.getByName("sso.teamshub.com");
			Socket socket = new Socket(inetAddr, 80);
			System.out.println(socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildWithAssignedLocalNetInterface() {
		//A local port number of zero will let the system pick up a free port in the bind operation.
		try {
			System.out.println("build socket with assigned local interface 1");
			InetAddress localAddr = InetAddress.getByName("router");
			Socket socket1 = new Socket("sso.teamshub.com", 80, localAddr, 0);
			System.out.println(socket1);
			
			System.out.println("build socket with assigned local interface 2");
			InetAddress inetAddr = InetAddress.getByName("sso.teamshub.com");
			Socket socket = new Socket(inetAddr, 80, localAddr, 0);
			System.out.println(socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildUnconnectedSocket() {
		System.out.println("build unconnected socket");
		Socket socket = new Socket();
		System.out.println(socket);
		// do something before connect
//		socket.setReceiveBufferSize(100);
//		socket.setTcpNoDelay(true);
//		socket.connect(SocketAddress endpoint, int timeout);
		
	}
	
	public static void buildWithProxy() {
		System.out.println("build with proxy");
		Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("172.16.9.20", 8088));  
//		Authenticator.setDefault(new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("zhanglonga", "888888".toCharArray());
//			}
//		});
		Socket socket = new Socket(proxy);
		System.out.println(socket);
		SocketAddress remote = new InetSocketAddress("www.baidu.com", 80);
		try {
//			socket.connect(remote, 1000);
			socket.connect(remote);
			System.out.println(socket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		buildUseHost();
//		buildUseInetAddress();
//		buildWithAssignedLocalNetInterface();
//		buildUnconnectedSocket();
//		buildWithProxy();
		
		// user sockeimpl
//		protected Socket(SocketImpl impl)
//		          throws SocketException
//		Creates an unconnected Socket with a user-specified SocketImpl. 
	}

}
