package mu.lean.fundamentals.concurrency.basic;

public class RunnableWay {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			public void run() {
				int count = 0;
				while(count++ < 3)
					System.out.println("thread, runable interface way.");
			}
			
		};
		
		Thread t = new Thread(r);
		t.start();
		System.out.println("start thread.");
	}
	
}
