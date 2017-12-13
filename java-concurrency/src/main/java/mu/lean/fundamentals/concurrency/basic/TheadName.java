package mu.lean.fundamentals.concurrency.basic;

public class TheadName {

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			
			public void run() {
				int count = 0;
				while(count++ < 3)
					System.out.println("thread run");
			}
			
		};
		
		Thread t1 = new Thread(r, "t1");
		System.out.println("thread name: " + t1.getName());
		
		Thread t2 = new Thread(r);
		t2.setName("t2");
		System.out.println("thread name: " + t2.getName());
		
		//default : "Thread-" + nextThreadNum()
		Thread t3 = new Thread(r);
		System.out.println("thread name: " + t3.getName());
		
		Thread t4 = new Thread(r);
		System.out.println("thread name: " + t4.getName());
		
	}

}
