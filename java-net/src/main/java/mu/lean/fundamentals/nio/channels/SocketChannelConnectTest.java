package mu.lean.fundamentals.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class SocketChannelConnectTest {

	public static void openUseSocketAddress() {
		System.out.println("open and connect.");
		SocketAddress socketAddress = new InetSocketAddress("eip.teamshub.com", 80);
		try {
			//Opens a socket channel and connects it to a remote address. 
			SocketChannel channel = SocketChannel.open(socketAddress);
			System.out.println(channel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void connectUseSocketAddress() {
		System.out.println("connect after open.");
		
		try {
			SocketChannel channel = SocketChannel.open();
			System.out.println(channel);
			// do something
//			channel.configureBlocking(false);
			SocketAddress socketAddress = new InetSocketAddress("eip.teamshub.com", 80);
			channel.connect(socketAddress);
			System.out.println(channel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void connectCheckBlockingMode() {
		try {
			System.out.println("connect status check...");
			SocketChannel channel = SocketChannel.open();
			channel.configureBlocking(true);
			SocketAddress socketAddress = new InetSocketAddress("www.teamshub.com", 80);
			boolean connectBack = channel.connect(socketAddress);
			System.out.printf("connect back: %s;%nis connect: %s;%nis connection pending: %s;%n"
					, connectBack
					, channel.isConnected()
					, channel.isConnectionPending());
			
			System.out.println("finish connect: " + channel.finishConnect());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void connectCheckNonBolockingMode() {
		try {
			SocketChannel channel = SocketChannel.open();
			channel.configureBlocking(false);
			SocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 80);
			boolean connectBack = channel.connect(socketAddress);
			System.out.printf("connect back: %s;%nis connect: %s;%nis connection pending: %s;%n"
					, connectBack
					, channel.isConnected()
					, channel.isConnectionPending());
			System.out.println("finish connect: " + channel.finishConnect());
			
			int count = 0;
			while(true) {
				System.out.println();
				System.out.println("current thread sleep 2 seconds start...");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("current thread sleep error.");
				}
				System.out.println("current thread sleep 2 seconds end.");
				
				System.out.println();
				System.out.printf("is connect: %s;%nis connection pending: %s;%n"
						, channel.isConnected()
						, channel.isConnectionPending());
				
				count ++;
				if(count > 6) {
					System.out.println();
					System.out.println("invoke finishConnect(). result: " + channel.finishConnect());
					break;
				}
			}
			
			System.out.println();
			System.out.printf("is connect: %s;%nis connection pending: %s;%n"
					, channel.isConnected()
					, channel.isConnectionPending());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		openUseSocketAddress();
//		connectUseSocketAddress();
//		connectCheckBlockingMode();
		connectCheckNonBolockingMode();
	}

}