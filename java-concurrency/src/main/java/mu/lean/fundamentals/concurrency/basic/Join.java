package mu.lean.fundamentals.concurrency.basic;

public class Join {
	
	public static void main(String[] args) throws InterruptedException {

		Runnable r = new Runnable() {

			public void run() {
				System.out.println(Thread.currentThread().getName() + " thread start");
				int count = 0;
				while (count++ < 6) {
					System.out.println("thread run " + Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " thread end");
			}
		};
		
		Thread t1 = new Thread(r, "t1");
		t1.start();
		System.out.println("main thread sleep start");
		Thread.sleep(1000);
		System.out.println("main thread sleep end");
		t1.join();
		System.out.println("fist test all end");

		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("second test start");
		Thread t2 = new Thread(r, "t2");
		t2.start();
		System.out.println("main thread sleep start");
		Thread.sleep(1000);
		System.out.println("main thread sleep end");
		t2.join(500);
		System.out.println("second test all end");
	}

}
