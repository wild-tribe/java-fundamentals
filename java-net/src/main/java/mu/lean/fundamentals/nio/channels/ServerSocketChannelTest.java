package mu.lean.fundamentals.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelTest {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			ServerSocket server = serverChannel.socket();
			SocketAddress address = new InetSocketAddress(80);
			server.bind(address);
			serverChannel.configureBlocking(false);
			
//			SocketChannel socketChannel = serverChannel.accept();
			
			// 注册到 Selector
			Selector selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
