package mu.lean.fundamentals.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLGetInfoTest {
	
	public static void main(String[] args) throws Exception {
		try {
			URL url = new URL("http://www.baidu.com:8080/tt/index?cid=1000#detail");
			System.out.println("url: " + url);
			System.out.println("protocol: " + url.getProtocol());
			System.out.println("host: " + url.getHost());
			System.out.println("port: " + url.getPort());
			System.out.println("default port: " + url.getDefaultPort());
			System.out.println("file: " + url.getFile());
			System.out.println("path: " + url.getPath());
			System.out.println("ref: " + url.getRef());
			System.out.println("query: " + url.getQuery());
			System.out.println("user info: " + url.getUserInfo());
			System.out.println("authority: " + url.getAuthority());
		} catch (MalformedURLException e) {
			// 不支持协议或者语法错误时抛出此异常
			e.printStackTrace();
		}
	}

}
