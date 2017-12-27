package mu.lean.fundamentals.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class SocketChannelDataOperation {

	private static SocketChannel getSocketChannel() {
		SocketAddress socketAddress = new InetSocketAddress("sso.teamshub.com", 80);
		try {
			return SocketChannel.open(socketAddress);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeTest(SocketChannel channel) {
		byte[] data = "GET / HTTP 1.0\r\n\r\n".getBytes();
		ByteBuffer buffer = ByteBuffer.wrap(data);
		try {
			channel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readTest(SocketChannel channel) {
		ByteBuffer buffer = ByteBuffer.allocate(50);
		WritableByteChannel out = Channels.newChannel(System.out);
		try {
			while(channel.read(buffer) != -1) {
				buffer.flip();
				while(buffer.hasRemaining())
					out.write(buffer);
				
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SocketChannel channel = getSocketChannel();
		writeTest(channel);
		//public final long write(ByteBuffer[] srcs) throws IOException
		//public abstract long write(ByteBuffer[] srcs, int offset, int length) throws IOException
		readTest(channel);
		//public final long read(ByteBuffer[] dsts) throws IOException
		//public abstract long read(ByteBuffer[] dsts, int offset, int length) throws IOException
	}

}
