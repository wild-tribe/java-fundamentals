package mu.lean.fundamentals.nio.sample.nonblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Client {
	
	public static ByteBuffer readBuffer = ByteBuffer.allocate(50);
	
	public static void printReadResult(SocketChannel socketChannel) {
		try {
			while(socketChannel.read(readBuffer) != -1) {
				readBuffer.flip();
				byte[] data = new byte[readBuffer.limit()];
				int index = 0;
				while(readBuffer.hasRemaining()) {
					data[index] = readBuffer.get();
					index ++;
				}
				System.out.print(new String(data));
				readBuffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		SocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 80);
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		channel.connect(socketAddress);
		
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		int count = 0;
		while(count ++ < 5) {
			// 阻塞
			selector.select();
			System.out.printf("%n select()... %n");
			Set<SelectionKey> keySet = selector.selectedKeys();
			for(SelectionKey key : keySet) {
				System.out.printf("%nkey info. connectable: %s; readable: %s; writable: %s;%n"
						, key.isConnectable()
						, key.isReadable()
						, key.isWritable());
				
				
				if(key.isReadable())
					printReadResult((SocketChannel)key.channel());
				
				if(key.isWritable()) {
					SocketChannel socketChannel = (SocketChannel)key.channel();
					byte[] data = "GET / HTTP 1.1\r\n\r\n".getBytes();
					ByteBuffer buffer = ByteBuffer.wrap(data);
					try {
						socketChannel.write(buffer);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if(key.isConnectable()) {
					System.out.println("connected..");
					SocketChannel socketChannel = (SocketChannel)key.channel();
					socketChannel.finishConnect();
				}
			}
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
