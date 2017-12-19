package mu.lean.fundamentals.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkInterfaceGetInfoTest {

	public static void testGetByName() {
		System.out.print("test getByName method: ");
		try {
			NetworkInterface ni = NetworkInterface.getByName("wlan0");
			System.out.println(ni);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetNetworkInterfaces() {
		System.out.print("test getNetworkInterfaces method: ");
		Enumeration<NetworkInterface> interfaces;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
			while(interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				System.out.println(ni);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetByByInetAddress() {
		System.out.print("test getByInetAddress method: ");
		NetworkInterface ni;
		try {
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			ni = NetworkInterface.getByInetAddress(addr);
			System.out.println(ni);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		NetworkInterface ni;
		try {
			ni = NetworkInterface.getByName("lo");
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("check your local NetworkInterface names.");
			return;
		}
		
		System.out.println("name: " + ni.getName());
		System.out.println("display name: " + ni.getDisplayName());
		
		System.out.println("addresses: ");
		Enumeration<InetAddress> addrs = ni.getInetAddresses();
		while(addrs.hasMoreElements()) {
			InetAddress addr = addrs.nextElement();
			System.out.println(addr);
		}
	}
	
}