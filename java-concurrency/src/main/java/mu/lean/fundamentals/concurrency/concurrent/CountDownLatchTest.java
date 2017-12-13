package mu.lean.fundamentals.concurrency.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchTest {
	
	public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	
	public static void println(String msg) {
		System.out.println(df.format(new Date()) + " " + msg);
	}

	public static void main(String[] args) {
		
		int threadNumber = 10;
		AtomicInteger ai = new AtomicInteger(0);
		
		final CountDownLatch threadsStart = new CountDownLatch(1);
		final CountDownLatch threadsDone = new CountDownLatch(threadNumber);
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				int tNum = ai.incrementAndGet();
				println("start thread " + tNum);
				try {
					threadsStart.await();
					println("start work. thread " + tNum);
					for(int i = 0; i < 3; i ++) 
						Thread.sleep(2000);
					
					threadsDone.countDown();
				} catch (InterruptedException e) {
					println("interrupted exception. thread " + tNum);
				}
				println("finish work. thread " + tNum);
			}
			
		};
		
		ExecutorService es = Executors.newFixedThreadPool(threadNumber);
		for(int i = 0; i < threadNumber; i ++)
			es.execute(r);
		
		try {
			Thread.sleep(3000);
			println("threads ready...");
			println("wait main thread do something...");
			Thread.sleep(2000);
			println("main thread do finished...");
			println("wait threads finished...");
			threadsStart.countDown();
			threadsDone.await();
			es.shutdown();
		} catch (InterruptedException e) {
			println("main thread interrupted exception.");
		}
		println("the end.");
	}
	
}