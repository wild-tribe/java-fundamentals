package mu.lean.fundamentals.nio;

import java.nio.CharBuffer;

public class BufferDataOperationTest {
	
	public static void getTest() {
		System.out.println("get test..");
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		char c1 = buffer.get();
		System.out.println();
		System.out.println("invoke get() method. c1: " + c1);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		char c2 = buffer.get();
		System.out.println();
		System.out.println("invoke get() method. c2: " + c2);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("iterate invoke get() method. print remain chars:");
		while(buffer.hasRemaining()) 
			System.out.print(buffer.get());
			
		System.out.println();
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("now try get again");
		System.out.print(buffer.get());
	}
	
	public static void putTest() {
		System.out.println("put test..");
		CharBuffer buffer = CharBuffer.allocate(10);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("invoke put() method.");
		buffer.put('0');
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("invoke put() method.");
		buffer.put('1');
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("iterate invoke put() method.");
		for(int i = 2; i < 10; i ++)
			buffer.put((char)i);
		
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("now try put again");
		buffer.put((char)11);
	}
	
	public static void getAbsoluteTest() {
		System.out.println("get absolute test..");
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		char c5 = buffer.get(5);
		System.out.println();
		System.out.println("invoke get() method. c5: " + c5);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
	}
	
	public static void putAbsoluteTest() {
		System.out.println("put absolute test..");
		CharBuffer buffer = CharBuffer.allocate(10);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println("invoke put() method.");
		buffer.put(5, '5');
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
	}
	
	public static void bulkGetTest() {
		System.out.println("bulk get test..");
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		char[] ca1 = new char[2];
		buffer.get(ca1);
		System.out.println();
		System.out.println("invoke bulk get() method.");
		System.out.println("ca1: " + ca1[0] + ca1[1]);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		char[] ca2 = new char[2];
		buffer.get(ca2);
		System.out.println();
		System.out.println("invoke bulk get() method.");
		System.out.println("ca2: " + ca2[0] + ca2[1]);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
	}
	
	public static void bulkGetWithOffsetAndLengthTest() {
		System.out.println("bulk get with offset&length test..");
		char[] data = "0123456789".toCharArray();
		CharBuffer buffer = CharBuffer.wrap(data);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		char[] ca1 = new char[2];
		buffer.get(ca1, 0, 2);
		System.out.println();
		System.out.println("invoke bulk get() method.");
		System.out.println("ca1: " + ca1[0] + ca1[1]);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
	}
	
	public static void bulkPutTest() {
		System.out.println("bulk put test..");
		CharBuffer buffer = CharBuffer.allocate(10);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("invoke bulk put() method.");
		char[] ca1 = new char[2];
		ca1[0] = '0';
		ca1[0] = '1';
		buffer.put(ca1);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("invoke bulk put() method.");
		char[] ca2 = new char[2];
		ca2[0] = '2';
		ca2[0] = '3';
		buffer.put(ca2);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
	}
	
	public static void bulkPutWithOffsetAndLengthTest() {
		System.out.println("bulk put with offset&length test..");
		CharBuffer buffer = CharBuffer.allocate(10);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
		
		System.out.println();
		System.out.println("invoke bulk put() method.");
		char[] ca1 = new char[2];
		ca1[0] = '0';
		ca1[0] = '1';
		buffer.put(ca1, 0, 2);
		System.out.printf("position: %s;%ncapacity: %s;%nlimit: %s;%n"
				, buffer.position()
				, buffer.capacity()
				, buffer.limit());
	}
	
	public static void main(String[] args) {
//		getTest();
//		putTest();
//		getAbsoluteTest();
//		putAbsoluteTest();
//		bulkGetTest();
//		bulkGetWithOffsetAndLengthTest();
//		bulkPutTest();
//		bulkPutWithOffsetAndLengthTest();
	}

}
