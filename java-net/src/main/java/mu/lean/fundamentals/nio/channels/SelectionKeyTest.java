package mu.lean.fundamentals.nio.channels;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class SelectionKeyTest {

	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
			while(true) {
				// 阻塞
				selector.select();
				Set<SelectionKey> keySet = selector.selectedKeys();
				for(SelectionKey key : keySet) {
					if(key.isAcceptable()) {
						ServerSocketChannel serverChannel = (ServerSocketChannel)key.channel();
						// 接受连接
						SocketChannel socketChannel = serverChannel.accept();
						socketChannel.configureBlocking(false);
						// 注册
						socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
					} else if(key.isConnectable()) {
						//
						
					} else if(key.isReadable()) {
						//
						SocketChannel socketChannel = (SocketChannel)key.channel();
//						socketChannel.read(ByteBuffer src)
					} else if(key.isWritable()) {
						//
						SocketChannel socketChannel = (SocketChannel)key.channel();
//						socketChannel.write(ByteBuffer src)
						//
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
