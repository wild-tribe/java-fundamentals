package mu.lean.fundamentals.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class ProxyTest {

	public static void main(String[] args) {

		// 无密码另外一种方式 
		//参考规范地址：https://docs.oracle.com/javase/7/docs/api/java/net/doc-files/net-properties.html
		//System.setProperty("http.proxyHost", "172.16.9.20");
		//System.setProperty("http.proxyPort", "8088");
		//http.nonProxyHosts (default: localhost|127.*|[::1])
		//System.setProperty("http.nonProxyHosts", "*.si-tech.com.cn|*.on-con.*|*.teamshub.com");
		
		// 需要用户名密码认证方式
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.9.20", 8088));  
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zhanglong", "888888".toCharArray());
			}
		});
		
		try {
			URL url = new URL("http://www.baidu.com");
			URLConnection conn = url.openConnection(proxy);  
			InputStream in = conn.getInputStream();
			int c;
			while((c = in.read()) != -1)
				System.out.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//ProxySelector
	}
	
}