package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerSocketOptionsTest {

	public static void soTimeoutTest(ServerSocket server) {
		try {
			System.out.println("SO_TIMEOUT default value: " + server.getSoTimeout());
			// 单位：millisecond
			// A timeout of zero is interpreted as an infinite timeout.
			server.setSoTimeout(2000);
			System.out.println("SO_TIMEOUT value: " + server.getSoTimeout());
			
			System.out.println();
			System.out.println("start accept...");
			try {
				Socket conn = server.accept();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("accept error...");
			}
			System.out.println("end accept...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void soReuseAddr(ServerSocket server) {
		System.out.println();
		// 是否立即释放本地地址
		try {
			System.out.println("SO_REUSEADDR default value: " + server.getReuseAddress());
			server.setReuseAddress(true);
			System.out.println("SO_REUSEADDR value: " + server.getReuseAddress());
//			socket.sendUrgentData(data); //发送紧急数据
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void soRcvbuf(ServerSocket server) {
		System.out.println();
		// TCP 接收建议缓冲区大小
		try {
			System.out.println("SO_RCVBUF default value: " + server.getReceiveBufferSize());
			// 单位字节
			server.setReceiveBufferSize(100);
			System.out.println("SO_RCVBUF value: " + server.getReceiveBufferSize());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(2000);
//		soTimeoutTest(server);
//		soReuseAddr(server);
//		soRcvbuf(server);
//		server.setPerformancePreferences(int connectionTime, int latency, int bandwidth);
	}
	
}