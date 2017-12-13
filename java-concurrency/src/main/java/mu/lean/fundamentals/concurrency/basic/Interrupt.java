package mu.lean.fundamentals.concurrency.basic;

public class Interrupt {

	public static void main(String[] args) throws InterruptedException {

		Runnable r = new Runnable() {

			public void run() {
				System.out.println("thread start");
				int count = 0;
				while (count++ < 15)
					System.out.println("thread run");
				
				System.out.println("thread end");
				Thread.interrupted();
			}

		};
		
		Thread t = new Thread(r);
		t.start();
		System.out.println(" is interrupted: " + t.isInterrupted());
		t.interrupt();
		System.out.println(" is interrupted: " + t.isInterrupted());
		
		Thread.sleep(3);
		System.out.println(" is interrupted: " + t.isInterrupted());
	}
	
}
