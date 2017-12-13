package mu.lean.fundamentals.concurrency.basic;

public class Sleep {

	public static void main(String[] args) throws InterruptedException {

		Runnable r = new Runnable() {

			public void run() {
				System.out.println(Thread.currentThread().getName() + " thread start");
				int count = 0;
				while (count < 6) {
					System.out.println(Thread.currentThread().getName() + " sleep start." + count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " sleep end." + count);
					count ++;
				}
				
			}
		};
		
		Thread t1 = new Thread(r, "t1");
		t1.start();
		System.out.println("main thread sleep start");
		Thread.sleep(10000);
		System.out.println("main thread sleep end");
	}
	
}
