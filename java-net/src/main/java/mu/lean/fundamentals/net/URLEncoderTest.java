package mu.lean.fundamentals.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// URL 合法字符集
		// 1 大写字母 A ~ Z
		// 2 小写字母 a ~ z
		// 3 数字 0 ~ 9
		// 4 标点符合字符 - _ . ! ~ * ' ,
		
		// 只用于特殊目的字符，用于文件名需转译：:/&?@#;$+=%
		
		// 转换规则：
		// ' ' -> '+'
		// 其余字符转换为字节，每个字节写为%号后面加两个16进制数
		
//		String unneededEncodeChars = "AFZafz069.-*_";
//		System.out.println("unneeded encode chars: '" + unneededEncodeChars + "'->'" + URLEncoder.encode(unneededEncodeChars, "UTF-8") + "'");
//		String space = " ";
//		System.out.println("space: '" + space + "'->'" + URLEncoder.encode(space, "UTF-8") + "'");
//		String plusSign = "+";
//		System.out.println("plus sign: '" + plusSign + "'->'" + URLEncoder.encode(plusSign, "UTF-8") + "'");
//		String specialChars = "/&?#=";
//		System.out.println("special chars: '" + specialChars + "'->'" + URLEncoder.encode(specialChars, "UTF-8") + "'");
//		String url = "http://www.baidu.com:8080/test?cid=1000&bsid=9888#map";
//		System.out.println("url with special chars: '" + url + "'->'" + URLEncoder.encode(url, "UTF-8") + "'");
		
	}

}