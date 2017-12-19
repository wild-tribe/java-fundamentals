package mu.lean.fundamentals.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLGetDataTest {
	
	private static URL getURL() {
		try {
			return new URL("http://www.baidu.com");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static URL getURL(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void testOpenStream() {
		URL url = getURL();
		try {
			InputStream in = url.openStream();
			int c;
			while((c = in.read()) != -1)
				System.out.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testOpenConnection() {
		URL url = getURL();
		try {
			URLConnection urlConn = url.openConnection();
			System.out.println("is HttpURLConnection: " + (urlConn instanceof HttpURLConnection));
			InputStream in = urlConn.getInputStream();
			int c;
			while((c = in.read()) != -1)
				System.out.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetContent() {
		try {
			URL url = getURL();
			Object obj = url.getContent();
			System.out.println(obj.getClass().getName());
			url = getURL("https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/static/protocol/https/global/img/icons_5859e57.png");
			obj = url.getContent();
			System.out.println(obj.getClass().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		testOpenStream();
//		testOpenConnection();
//		testGetContent();
//		public final Object getContent(Class[] classes)
	}

}
