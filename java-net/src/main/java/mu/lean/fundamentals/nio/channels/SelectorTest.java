package mu.lean.fundamentals.nio.channels;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

public class SelectorTest {

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		// 非阻塞
		selector.selectNow();
		
		// 阻塞
		selector.select();
		// 阻塞指定秒数。0，无限期
//		selector.select(long timeout)
		
		Set<SelectionKey> keySet = selector.selectedKeys();
	}

}
