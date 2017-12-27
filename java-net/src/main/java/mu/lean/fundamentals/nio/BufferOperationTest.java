package mu.lean.fundamentals.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferOperationTest {

//	private static void printFullBuffer(ByteBuffer buffer) {
//		buffer.position(0);
//		while(buffer.hasRemaining())
//			System.out.print((char)buffer.get());
//	}
//	
//	private static void printFullBuffer(CharBuffer buffer) {
//		buffer.position(0);
//		while(buffer.hasRemaining())
//			System.out.print(buffer.get());
//	}
	
	private static byte[] getBytes() {
		byte[] data = new byte[10];
		data[0]=0;
		data[1]=1;
		data[2]=2;
		data[3]=3;
		data[4]=4;
		data[5]=5;
		data[6]=6;
		data[7]=7;
		data[8]=8;
		data[9]=9;
		
		return data;
	}
	
	public static void viewTest() {
		System.out.println("get test..");
		ByteBuffer buffer = ByteBuffer.wrap(getBytes());
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		CharBuffer charViewBuffer = buffer.asCharBuffer();
		System.out.printf("%n%nchar result: " + (short)charViewBuffer.get());
		
		System.out.printf("%n%n");
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, charViewBuffer.position()
				, charViewBuffer.capacity()
				, charViewBuffer.limit());
		
//		buffer.asDoubleBuffer();
//		buffer.asFloatBuffer();
//		buffer.asIntBuffer();
//		buffer.asLongBuffer();
//		buffer.asShortBuffer();
//		buffer.asReadOnlyBuffer();
		
		// share data
//		byte[] dataArray = buffer.array();
//		dataArray[0] = 1;
//		System.out.printf("%n%n affer data array change. 0 index:%s", buffer.get(0));
//		System.out.printf("%n%n char view buffer content. 0 index:%s", (short)charViewBuffer.get(0));
	}
	
	public static void compactTest() {
		System.out.println("compact test..");
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		int invokeTimes = 4;
		System.out.println();
		System.out.print("buffer invoke get() " + invokeTimes + " times. get result:");
		
		for(int i = 0; i < invokeTimes; i ++) 
			System.out.print(buffer.get());
		
		System.out.printf("%n%n");
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.printf("%n%ncompact buffer %n");
		buffer.compact();
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		char[] compactResult = buffer.array();
		System.out.print("compact result:");
		for(int i = 0; i < compactResult.length; i ++)
			System.out.print(compactResult[i]);
		
	}
	
	public static void duplicateTest() {
		System.out.println("compact test..");
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		CharBuffer buffer1 = buffer.duplicate();
		int invokeTimes = 4;
		System.out.println();
		System.out.print("buffer1 invoke get() " + invokeTimes + " times. get result:");
		
		for(int i = 0; i < invokeTimes; i ++) 
			System.out.print(buffer1.get());
		
		System.out.printf("%n%n");
		System.out.printf("%n%nbuffer infos:%n");
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		System.out.printf("%nbuffer1 infos:%n");
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer1.position()
				, buffer1.capacity()
				, buffer1.limit());
		
		// share data
//		char[] dataArray = buffer.array();
//		dataArray[9] = '0';
//		System.out.printf("%n%n affer data array change. buffer 9 index:%s", buffer.get(9));
//		System.out.printf("%n%n affer data array change. buffer1 9 index:%s", buffer1.get(9));
	}
	
	public static void sliceTest() {
		System.out.println("compact test..");
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		buffer.position(5);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		
		CharBuffer sliceBuffer = buffer.slice();
		System.out.printf("%n%nslice buffer info:%n position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, sliceBuffer.position()
				, sliceBuffer.capacity()
				, sliceBuffer.limit());
		System.out.print("slice buffer content: ");
		while(sliceBuffer.hasRemaining())
			System.out.print(sliceBuffer.get());
		
		// share data
		char[] dataArray = buffer.array();
		dataArray[9] = '0';
		System.out.printf("%n%n affer data array change. buffer 9 index:%s", buffer.get(9));
		System.out.printf("%n%n affer data array change. slice buffer 9 index:%s", sliceBuffer.get(4));
		char[] sliceDataArray = sliceBuffer.array();
		System.out.printf("%nslice data array:");
		for(int i = 0; i < sliceDataArray.length; i ++)
			System.out.print(sliceDataArray[i]);
	}
	
//	public static void dataShareTest() {
//		System.out.println("get test..");
//		byte[] data = "0123456789".getBytes();
//		ByteBuffer buffer = ByteBuffer.wrap(data);
//		
//		CharBuffer charViewBuffer = buffer.asCharBuffer();
//		ByteBuffer duplicate = buffer.duplicate();
//		
//	}
//	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		viewTest();
//		compactTest();
//		duplicateTest();
		sliceTest();
	}

}
