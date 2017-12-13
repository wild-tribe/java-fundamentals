package mu.lean.fundamentals.concurrency.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date() + ", task excute.");
			}
			
		};
		
		TimerTask timerTask1 = new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date() + ", task1 excute.");
			}
			
		};
		
		TimerTask timerTask2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date() + ", task2 excute.");
			}
			
		};
		
		Timer timer = new Timer();
		timer.schedule(timerTask, new Date(System.currentTimeMillis() + 2000));
		
		timer.schedule(timerTask1, new Date(System.currentTimeMillis() + 3000), 2000);
		timer.schedule(timerTask2, new Date(System.currentTimeMillis() + 3000), 4000);
		
	}

}
