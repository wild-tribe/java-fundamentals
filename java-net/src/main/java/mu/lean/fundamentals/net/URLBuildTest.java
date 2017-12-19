package mu.lean.fundamentals.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLBuildTest {
	
	public static void buildUseUrlString() {
		try {
			URL url = new URL("http://www.baidu.com");
			System.out.println("url: " + url);
		} catch (MalformedURLException e) {
			// 不支持协议或者语法错误时抛出此异常
			e.printStackTrace();
		}
	}
	
	public static void buildUseParts() {
		try {
			URL url = new URL("http", "www.baidu.com", 8080, "/index.html");
			System.out.println("build url use parts: " + url);
			
			url = new URL("http", "www.baidu.com", "/tt/index.html");
			System.out.println("build url use parts(without port): " + url);
			
			URL relativeUrl = new URL(url, "test.html");
			System.out.println("build relative url: " + relativeUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
//		buildUseUrlString();
//		buildUseParts();
//		URL(String protocol, String host, int port, String file,URLStreamHandler handler)
//		URL(URL context, String spec, URLStreamHandler handler)
	}

}
