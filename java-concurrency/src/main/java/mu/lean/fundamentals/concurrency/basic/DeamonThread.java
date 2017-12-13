package mu.lean.fundamentals.concurrency.basic;

public class DeamonThread {

	public static void main(String[] args) throws InterruptedException {

		Runnable r = new Runnable() {

			public void run() {
				System.out.println("thread start");
				int count = 0;
				while (count++ < 3)
					System.out.println("thread run");

				System.out.println("thread end");
			}

		};
		
		Runnable r1 = new Runnable() {

			public void run() {
				System.out.println("deamon thread start");
				
				while (true)
					System.out.println("deamon thread run");
			}

		};

		Thread t = new Thread(r);
		System.out.println("is deamon: " + t.isDaemon());
		
		System.out.println("is deamon: " + Thread.currentThread().isDaemon());
		t.start();
		System.out.println("is deamon: " + t.isDaemon());
		System.out.println("main thread is deamon: " + Thread.currentThread().isDaemon());
		
		Thread.sleep(2000);
		Thread deamonT = new Thread(r1);
		deamonT.setDaemon(true);
		Thread normalT = new Thread(r);
		deamonT.start();
		normalT.start();
		System.out.println("all started");
	}
	
}
