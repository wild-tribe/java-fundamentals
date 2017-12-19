package mu.lean.fundamentals.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressGetInfoTest {

	public static void testGetByNameUseDomainName() {
		System.out.println("test getByName use domain name:");
		try {
			InetAddress address = InetAddress.getByName("www.jd.com");
			System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetByNameUseIp() {
		System.out.println("test getByName use IP");
		try {
			//eip.teamshub.com/111.202.213.13/0.180.10.92
			//JDK1.3 会进行域名查找，显示结果与传域名一样
			//JDK1.4不会进行域名查找
			InetAddress address = InetAddress.getByName("10.180.10.92");
			System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetAllByName() {
		System.out.println("test getAllByName use domain:");
		try {
			InetAddress[] addresses = InetAddress.getAllByName("www.taobao.com");
			for(InetAddress address : addresses)
				System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetByAddress() {
		//eip.teamshub.com/111.202.213.13/0.180.10.92
		byte[] addr = new byte[4];
		addr[0] = (byte)111;
		addr[1] = (byte)202;
		addr[2] = (byte)213;
		addr[3] = (byte)13;
		
		System.out.println("test getByAddress use ip:");
		try {
			InetAddress address = InetAddress.getByAddress(addr);
			System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("test getByAddress use domain name and ip:");
		try {
			InetAddress address = InetAddress.getByAddress("eip.teamshub.com", addr);
			System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetLocalHost() {
		System.out.println("test getLocalHost:");
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InetAddress address = null;
		try {
			//www.taobao.com/202.108.249.254
//			address = InetAddress.getByName("www.taobao.com");
			address = InetAddress.getByName("202.108.249.254");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("check your net settings");
			return;
		}
		
		System.out.printf("host name: %s%n", address.getHostName());
		
		System.out.printf("host address: %s%n", address.getHostAddress());
		
		System.out.print("address: ");
		byte[] ipArray = address.getAddress();
		for(int i = 0; i < 4; i ++) {
			if(i > 0)
				System.out.print(".");
			
			System.out.print(ipArray[i] & 0xFF);
		}
		
	}

}