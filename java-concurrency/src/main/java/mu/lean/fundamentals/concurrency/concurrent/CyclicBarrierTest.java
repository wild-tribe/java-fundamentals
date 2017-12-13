package mu.lean.fundamentals.concurrency.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	public static void dump(float[][] matrix) {
		for(float[] array : matrix) {
			for(float v : array)
				System.out.print(v + " ");
			
			System.out.println();
		}
	}

	
	
	public static void main(String[] args) {
		float[][] matrix = new float[3][3];
		int counter = 0;
		for(int row = 0; row < matrix.length; row ++)
			for(int col = 0; col < matrix[row].length; col++)
				matrix[row][col] = counter++;
		
		dump(matrix);
		System.out.println();
		@SuppressWarnings("unused")
		Solver solver = new Solver(matrix);
		System.out.println();
		dump(matrix);
	}

}

class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;

	public Solver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		
		barrier = new CyclicBarrier(N, new Runnable() {
											@Override
											public void run() {
												mergeRows();
											}			
										});
		
		for(int i = 0; i < N; i ++)
			new Thread(new Worker(i)).start();
		
		waitUntilDone();
	}
	
	void mergeRows() {
		System.out.println("merging");
		
		synchronized("abc") {
			"abc".notify();
		}
		
	}
	
	void waitUntilDone() {
		synchronized("abc") {
			try {
				System.out.println("main thread waiting");
				"abc".wait();
				System.out.println("main thread notified");
			} catch(InterruptedException e) {
				System.out.println("main thread interrupted");
			}
		}
	}
	
	class Worker implements Runnable {

		int myRow;
		boolean done = false;

		Worker(int row) {
			myRow = row;
		}
		
		boolean done() {
			return done;
		}
		
		void processRow(int myRow) {
			System.out.println("Proccessing row: " + myRow);
			for(int i = 0; i < N; i++)
				data[myRow][i] *= 10;
			
			done = true;
		}

		public void run() {
			while (!done()) {
				processRow(myRow);

				try {
					barrier.await();
				} catch (InterruptedException ex) {
					return;
				} catch (BrokenBarrierException ex) {
					return;
				}
			}
		}
	}
}
