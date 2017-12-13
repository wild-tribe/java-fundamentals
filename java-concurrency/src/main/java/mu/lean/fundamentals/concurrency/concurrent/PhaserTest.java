package mu.lean.fundamentals.concurrency.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {

	public static void main(String[] args) {
		List<Runnable> tasks = new ArrayList<Runnable>();
		tasks.add(() -> System.out.printf("%s running at %d%n",
											Thread.currentThread().getName(),
											System.currentTimeMillis()));
		
		tasks.add(() -> System.out.printf("%s running at %d%n",
				Thread.currentThread().getName(),
				System.currentTimeMillis()));
		
		tasks.add(() -> System.out.printf("%s running at %d%n",
				Thread.currentThread().getName(),
				System.currentTimeMillis()));
		
		runTasks(tasks);
		
	}
	
	static void runTasks(List<Runnable> tasks) {
		final Phaser phaser = new Phaser(1);
		for(final Runnable task : tasks) {
			phaser.register();
			Runnable r = () -> {
				try {
					Thread.sleep(5000 + (int)(Math.random() * 300));
				} catch(InterruptedException e) {
					System.out.println("interrupted exception");
				}
				System.out.printf("%s arrive at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
				int arrivalPhaseNumber = phaser.arriveAndAwaitAdvance();
				System.out.printf("%s arrival phase number : %d%n", Thread.currentThread().getName(), arrivalPhaseNumber);
				task.run();
			};
			Executors.newSingleThreadExecutor().execute(r);
		}
		int arrivalPhaseNumber = phaser.arriveAndDeregister();
		System.out.printf("%s arrival phase number : %d%n", Thread.currentThread().getName(), arrivalPhaseNumber);
//		arrivalPhaseNumber = phaser.arriveAndDeregister();
//		System.out.printf("%s arrival phase number : %d%n", Thread.currentThread().getName(), arrivalPhaseNumber);
	}
	
}
