package mu.lean.fundamentals.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketAcceptAndCloseTest {

	public static void acceptTest() {
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println(server);
			
			System.out.println("server start accept..");
			while(true) {
				Socket conn = server.accept();
				System.out.println("accept connection: " + conn);
				// do something about read or wirte
//				try {
//					InputStream in = conn.getInputStream();
//					// 处理输入
//					OutputStream out = conn.getOutputStream();
//					out.write(11);
//					// 处理输出
//					conn.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//					if(conn != null)
//						conn.close();
//				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeTest() {
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println(server);
			System.out.println("server is closed: " + server.isClosed());
			
			System.out.println();
			System.out.println("close server...");
			server.close();
			System.out.println("server is closed: " + server.isClosed());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		acceptTest();
		closeTest();
	}
	
}