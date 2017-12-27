package mu.lean.fundamentals.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ByteBufferBuildTest {
	
	public static void allocateTest() {
		System.out.println("allocate test..");
		ByteBuffer buffer = ByteBuffer.allocate(100);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
	}
	
	public static void allocateDirectTest() {
		System.out.println("allocate direct test..");
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
	}
	
	public static void wrapTest() {
		System.out.println("wrap test..");
		try {
			byte[] data = "some data".getBytes("UTF-8");
			ByteBuffer buffer = ByteBuffer.wrap(data);
			System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
					, buffer.position()
					, buffer.capacity()
					, buffer.limit());
			
			System.out.println();
			System.out.println("wrap with offset&length test..");
			buffer = ByteBuffer.wrap(data, 2, 5);
			System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
					, buffer.position()
					, buffer.capacity()
					, buffer.limit());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		allocateTest();
//		allocateDirectTest();
//		wrapTest();
	}

}
