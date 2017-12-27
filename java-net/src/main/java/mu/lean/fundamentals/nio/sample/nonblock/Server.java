package mu.lean.fundamentals.nio.sample.nonblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Server {
	
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket server = serverChannel.socket();
		SocketAddress address = new InetSocketAddress(80);
		server.bind(address);
		
		serverChannel.configureBlocking(false);
		
		// 注册到选择器
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true) {
			// 阻塞
			selector.select();
			
			Set<SelectionKey> keySet = selector.selectedKeys();
			for(SelectionKey key : keySet) {
				if(key.isAcceptable()) {
					ServerSocketChannel serverChannel1 = (ServerSocketChannel)key.channel();
					// 接受连接
					SocketChannel socketChannel = serverChannel1.accept();
					socketChannel.configureBlocking(false);
					// 注册
					socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
				} else if(key.isConnectable()) {
					//
					
				} else if(key.isReadable()) {
					//
//					SocketChannel socketChannel = (SocketChannel)key.channel();
//					socketChannel.read(ByteBuffer src)
				} else if(key.isWritable()) {
					//
//					SocketChannel socketChannel = (SocketChannel)key.channel();
//					socketChannel.write(ByteBuffer src)
					//
				}
			}
		}
	}
	
}
