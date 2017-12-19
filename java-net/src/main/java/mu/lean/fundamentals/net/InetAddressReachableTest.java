package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressReachableTest {
	
	public static void main(String[] args) {
		InetAddress address = null;
		try {
			address = InetAddress.getByName("www.baidu.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("check your net settings");
			return;
		}
		
		try {
			System.out.println(address + " (internet)is reachable? " + address.isReachable(2000));
//			address.isReachable(NetworkInterface netif, int ttl, int timeout)
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			address = InetAddress.getByName("eip.teamshub.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("check your net settings");
			return;
		}
		
		try {
			System.out.println(address + " (intranet)is reachable? " + address.isReachable(2000));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}