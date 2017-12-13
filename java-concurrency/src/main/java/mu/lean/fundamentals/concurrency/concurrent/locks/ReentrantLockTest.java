package mu.lean.fundamentals.concurrency.concurrent.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		final ReentrantLock lock = new ReentrantLock();
		
		class Worker implements Runnable {
			private final String name;
			
			Worker(String name) {
				this.name = name;
			}

			@Override
			public void run() {
				System.out.printf("Thread %s ready to get lock.%n", name);
				lock.lock();
				try {
					if(lock.isHeldByCurrentThread())
						System.out.printf("Thread %s entered critical section.%n", name);
					
					System.out.printf("Thread %s performing work.%n", name);
					try {
						Thread.sleep(2000);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("Thread %s finished working.%n", name);
				} finally {
					lock.unlock();
				}
			}	
		}
		executor.execute(new Worker("ThdA"));
		executor.execute(new Worker("ThdB"));
//		executor.execute(new Worker("ThdC"));
//		executor.execute(new Worker("ThdD"));
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}