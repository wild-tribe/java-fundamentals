package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketServiceTypeTest {
	
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
		
		// IPTOS_LOWCOST (0x02)     低成本
		// IPTOS_RELIABILITY (0x04) 高可靠性
		// IPTOS_THROUGHPUT (0x08)  最高吞吐量
		// IPTOS_LOWDELAY (0x10)    最小延迟
		
		// 0到255之间Q
		socket.setTrafficClass(0x02);
		System.out.println("traffic class: " + socket.getTrafficClass());
//		socket.setPerformancePreferences(int connectionTime, int latency, int bandwidth);
	}

}
