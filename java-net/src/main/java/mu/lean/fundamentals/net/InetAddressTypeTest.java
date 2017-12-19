package mu.lean.fundamentals.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTypeTest {
	// 通配地址
	public static void testIsAnyLocalAddress() throws UnknownHostException {
		InetAddress inetAddr = InetAddress.getByName("www.taobao.com");
		System.out.println(inetAddr + " is wildcard address? " + inetAddr.isAnyLocalAddress());
		
		inetAddr = InetAddress.getByName("0.0.0.0");
		System.out.println(inetAddr + "(IPv4) is wildcard address? " + inetAddr.isAnyLocalAddress());
		
		inetAddr = InetAddress.getByName("::");
		System.out.println(inetAddr + "(IPv6'::') is wildcard address? " + inetAddr.isAnyLocalAddress());
		
		inetAddr = InetAddress.getByName("0:0:0:0:0:0:0:0");
		System.out.println(inetAddr + "(IPv6'0:0:0:0:0:0:0:0') is wildcard address? " + inetAddr.isAnyLocalAddress());
	}
	// 回路地址
	public static void testIsLoopbackAddress() throws UnknownHostException {
		InetAddress inetAddr = InetAddress.getByName("www.taobao.com");
		System.out.println(inetAddr + " is loopback address? " + inetAddr.isLoopbackAddress());
		
		inetAddr = InetAddress.getByName("127.0.0.1");
		System.out.println(inetAddr + "(IPv4) is loopback address? " + inetAddr.isLoopbackAddress());
		
		inetAddr = InetAddress.getByName("::1");
		System.out.println(inetAddr + "(IPv6'::1') is loopback address? " + inetAddr.isLoopbackAddress());
		
		inetAddr = InetAddress.getByName("0:0:0:0:0:0:0:1");
		System.out.println(inetAddr + "(IPv6'0:0:0:0:0:0:0:1') is loopback address? " + inetAddr.isLoopbackAddress());
	}
	
	public static void main(String[] args) throws UnknownHostException {
//		testIsAnyLocalAddress();
		testIsLoopbackAddress();
	}

}