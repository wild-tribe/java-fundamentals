package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketOptionsTest {
	
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
	
	public static void tcpNoDelayTest(Socket socket) {
		//TCP_NODELAY socket缓冲
		System.out.println();
		try {
			System.out.println("TCP_NODELAY default value: " + socket.getTcpNoDelay());
			socket.setTcpNoDelay(true);
			System.out.println("set TCP_NODELAY true value: " + socket.getTcpNoDelay());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void soLingerTest(Socket socket) {
		//SO_LINGER socket关闭时如何处理剩余数据
		// getSoLinger() 返回-1 代表选项被禁用，会尽可能多的发送剩余数据
		// 设置时，socket close方法将阻塞指定的秒数
		// 最大秒数65535
		System.out.println();
		try {
			System.out.println("SO_LINGER default value: " + socket.getSoLinger());
			// 单位秒
			socket.setSoLinger(true, 10);// 10秒
			System.out.println("set SO_LINGER true 10: " + socket.getSoLinger());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void soTimeoutTest(Socket socket) {
		System.out.println();
		// 影响socket read() 方法。0，代表无限超时
		try {
			System.out.println("SO_TIMEOUT default value: " + socket.getSoTimeout());
			// 单位 milliseconds
			socket.setSoTimeout(2000);
			System.out.println("SO_TIMEOUT value 2s: " + socket.getSoTimeout());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void soRcvbuf(Socket socket) {
		System.out.println();
		// TCP 接收建议缓冲区大小
		try {
			System.out.println("SO_RCVBUF default value: " + socket.getReceiveBufferSize());
			// 单位字节
			socket.setReceiveBufferSize(100);
			System.out.println("SO_RCVBUF value: " + socket.getReceiveBufferSize());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void soSndbuf(Socket socket) {
		System.out.println();
		// TCP 发送建议缓冲区大小
		try {
			System.out.println("SO_SNDBUF default value: " + socket.getSendBufferSize());
			// 单位字节
			socket.setSendBufferSize(100);
			System.out.println("SO_SNDBUF value: " + socket.getSendBufferSize());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void soKeepalive(Socket socket) {
		System.out.println();
		// 空闲连接发送一个数据包（一般2个小时一次），以确保服务器未崩溃
		
		// 如果服务器未响应，客户端会持续尝试11分钟多的时间，直到收到响应为止。
		// 12分钟未响应，关闭此连接
		try {
			System.out.println("SO_KEEPALIVE default value: " + socket.getKeepAlive());
			socket.setKeepAlive(true);
			System.out.println("SO_KEEPALIVE value: " + socket.getKeepAlive());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void soOOBInline(Socket socket) {
		System.out.println();
		// 发送紧急数据
		try {
			System.out.println("SO_OOBINLINE default value: " + socket.getOOBInline());
			socket.setOOBInline(true);
			System.out.println("SO_OOBINLINE value: " + socket.getOOBInline());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void soReuseAddr(Socket socket) {
		System.out.println();
		// 是否立即释放本地地址
		try {
			System.out.println("SO_REUSEADDR default value: " + socket.getReuseAddress());
			socket.setReuseAddress(true);
			System.out.println("SO_REUSEADDR value: " + socket.getReuseAddress());
//			socket.sendUrgentData(data); //发送紧急数据
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Socket socket = getSocket();
		if(socket == null) {
			System.out.println("socket is null, check your net settings.");
			return;
		}
		System.out.println("socket: " + socket);
		
//		tcpNoDelayTest(socket);
//		soLingerTest(socket);
//		soTimeoutTest(socket);
//		soRcvbuf(socket);
//		soSndbuf(socket);
//		soKeepalive(socket);
//		soOOBInline(socket);
//		soReuseAddr(socket);
	}

}
