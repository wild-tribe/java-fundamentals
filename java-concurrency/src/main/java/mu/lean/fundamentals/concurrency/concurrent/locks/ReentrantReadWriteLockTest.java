package mu.lean.fundamentals.concurrency.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {
		ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
		Bulletin bulletin = new Bulletin();
		new Reader("reader1", bulletin, rrwl.readLock()).start();
		new Reader("reader2", bulletin, rrwl.readLock()).start();
		new Reader("reader3", bulletin, rrwl.readLock()).start();
		new Reader("reader4", bulletin, rrwl.readLock()).start();
		
		new Writer("writer", bulletin, rrwl.writeLock()).start();
	}

}

class Bulletin {
	
	private String content;
	
	public Bulletin() {
		content = "blank";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}

class Reader extends Thread {
	
	private Bulletin bulletin;
	private Lock rl;
	
	Reader(String name, Bulletin bulletin, Lock rl) {
		super(name);
		this.bulletin = bulletin;
		this.rl = rl;
	}
	
	void read() throws InterruptedException {;
		System.out.printf("Thread %s ready read. %d%n", getName(), System.currentTimeMillis());
		rl.lock();
		System.out.printf("Thread %s read %s. %d%n", getName(), bulletin.getContent(), System.currentTimeMillis());
		Thread.sleep(1000);
		System.out.printf("Thread %s read finished. %d%n", getName(), System.currentTimeMillis());
		rl.unlock();
	}

	@Override
	public void run() {
		while(true) {
			try {
				read();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Writer extends Thread {

	private int count;
	private Bulletin bulletin;
	private Lock wl;
	
	Writer(String name, Bulletin bulletin, Lock wl) {
		super(name);
		this.bulletin = bulletin;
		this.wl = wl;
	}
	
	void write() throws InterruptedException {;
		System.out.printf("Thread %s ready write. %d%n", getName(), System.currentTimeMillis());
		wl.lock();
		bulletin.setContent("content " + count++);
		System.out.printf("Thread %s write %s. %d%n", getName(), bulletin.getContent(), System.currentTimeMillis());
		Thread.sleep(3000);
		System.out.printf("Thread %s write finished. %d%n", getName(), System.currentTimeMillis());
		wl.unlock();
	}

	@Override
	public void run() {
		while(true) {
			try {
				write();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}