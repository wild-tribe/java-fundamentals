package mu.lean.fundamentals.concurrency.basic;

public class CacheVariable {

	public static Integer result;
	
	public static void main(String[] args) throws InterruptedException {

		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				result = Math.max(100, 1000);
				System.out.println("result: " + result);
			}
			
		};
		
		Thread t1 = new Thread(r, "t1");
		t1.start();
		System.out.println("result1: " + result);
		Thread.sleep(10000);
		System.out.println("result2: " + result);
		
	}
	
}
