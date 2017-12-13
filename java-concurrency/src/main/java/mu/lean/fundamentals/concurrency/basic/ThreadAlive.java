package mu.lean.fundamentals.concurrency.basic;

public class ThreadAlive {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = new Runnable() {
			
			public void run() {
				System.out.println("thread start");
				int count = 0;
				while(count++ < 3)
					System.out.println("thread run");
				
				System.out.println("thread end");
			}
			
		};
		
		Thread t = new Thread(r);
		System.out.println("thread alive: " + t.isAlive());
		t.start();
		System.out.println("thread alive: " + t.isAlive());
		Thread.sleep(2000l);
		System.out.println("thread alive: " + t.isAlive());
		
	}

}