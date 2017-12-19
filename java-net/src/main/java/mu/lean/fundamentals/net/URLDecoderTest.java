package mu.lean.fundamentals.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String original = "AFZafz069.-*_ :/&?@#;$+=%";
		String encode = URLEncoder.encode(original, "UTF-8");
		String decode = URLDecoder.decode(encode, "UTF-8");
		System.out.printf("original->'%s'%nencode->'%s'%ndecode->'%s'%n", original, encode, decode);
	}

}