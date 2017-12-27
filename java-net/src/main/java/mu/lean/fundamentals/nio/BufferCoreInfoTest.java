package mu.lean.fundamentals.nio;

import java.nio.CharBuffer;

public class BufferCoreInfoTest {

	public static void main(String[] args) {
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		
		// position
		System.out.println("position: " + buffer.position());
		buffer.position(3);
		System.out.println("position after changed: " + buffer.position());
		
		// capacity
		System.out.printf("%n%n capacity test..");
		System.out.println("capacity: " + buffer.capacity());
		
		// limit
		System.out.printf("%n%n limt test..");
		System.out.println("limit: " + buffer.limit());
		buffer.limit(8);
		System.out.println("limit after changed: " + buffer.limit());
		
		// mark
		System.out.printf("%n%n mark test..");
		buffer.mark();
		buffer.position(8);
		buffer.reset();
		System.out.println("position: " + buffer.position());
		
		// clear 清空
		buffer.position(5);
		buffer.limit(7);
		System.out.printf("%nbefore clear. position: %s; limit: %s; capacity: %s;%n"
				, buffer.position()
				, buffer.limit()
				, buffer.capacity());
		buffer.clear();
		System.out.printf("after clear. position: %s; limit: %s; capacity: %s;%n"
				, buffer.position()
				, buffer.limit()
				, buffer.capacity());
		
		
		// flip 写转读
		buffer.position(5);
//		buffer.limit(7);
		System.out.printf("%nbefore flip. position: %s; limit: %s; capacity: %s;%n"
				, buffer.position()
				, buffer.limit()
				, buffer.capacity());
		buffer.flip();
		System.out.printf("after flip. position: %s; limit: %s; capacity: %s;%n"
				, buffer.position()
				, buffer.limit()
				, buffer.capacity());
		
		// rewind 重新读
		buffer.position(5);
		buffer.limit(7);
		System.out.printf("%nbefore rewind. position: %s; limit: %s; capacity: %s;%n"
				, buffer.position()
				, buffer.limit()
				, buffer.capacity());
		buffer.rewind();
		System.out.printf("after rewind. position: %s; limit: %s; capacity: %s;%n"
				, buffer.position()
				, buffer.limit()
				, buffer.capacity());
	}
	
}
