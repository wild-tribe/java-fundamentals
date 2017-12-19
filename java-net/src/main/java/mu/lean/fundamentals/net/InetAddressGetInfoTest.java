package mu.lean.fundamentals.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressGetInfoTest {
	
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