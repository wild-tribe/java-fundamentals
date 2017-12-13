package mu.lean.fundamentals.concurrency.basic;

public class ThreadPriority {

	public static void main(String[] args) {

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
		System.out.println("default priority: " + t.getPriority());
		
		t.setPriority(Thread.MAX_PRIORITY);
		System.out.println("max priority: " + t.getPriority());
		
		t.setPriority(Thread.MIN_PRIORITY);
		System.out.println("min priority: " + t.getPriority());
		
		t.setPriority(Thread.NORM_PRIORITY);
		System.out.println("normal priority: " + t.getPriority());
		
//		t.setPriority(20);
//		System.out.println("normal priority: " + t.getPriority());

		t.setPriority(0);
		System.out.println("normal priority: " + t.getPriority());

	}

}
