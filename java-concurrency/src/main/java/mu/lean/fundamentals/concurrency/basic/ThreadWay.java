package mu.lean.fundamentals.concurrency.basic;

public class ThreadWay extends Thread {

	@Override
	public void run() {
		int count = 0;
		while(count++ < 3)
			System.out.println("thread, thread class way.");
	}

	public static void main(String[] args) {
		Thread t = new ThreadWay();
		t.start();
		System.out.println("start thread.");
	}

}