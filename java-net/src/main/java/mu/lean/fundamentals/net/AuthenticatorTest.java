package mu.lean.fundamentals.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class AuthenticatorTest {

	public static void main(String[] args) {
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zhanglong", "888888".toCharArray());
			}
		});
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.9.20", 8088));  
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
	}
	
}