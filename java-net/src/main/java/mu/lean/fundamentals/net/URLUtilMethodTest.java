package mu.lean.fundamentals.net;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLUtilMethodTest {
	
	public static void main(String[] args) {
		try {
			URL u1 = new URL("http://www.baidu.com#FF");
			URL u2 = new URL("http://www.baidu.com#RR");
			System.out.println("u1: " + u1);
			System.out.println("u2: " + u2);
			System.out.println("u1, u2 is same file? " + u1.sameFile(u2));
			System.out.println("u1 to external form: " + u1.toExternalForm());
			System.out.println("u1 to URI: " + u1.toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
