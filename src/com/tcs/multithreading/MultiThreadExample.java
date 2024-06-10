package com.tcs.multithreading;

class ThreadExample extends Thread {

	private int start;
	private int end;

	public ThreadExample(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public void task(int start, int end) {
		for (; start <= end; start++) {
			System.out.print(start+" ");
		}
	}

	@Override
	public void run() {
		task(this.start, this.end);
	}

}

public class MultiThreadExample {
	public static void main(String[] args) {
		Thread thread1=new ThreadExample(0,5);
		thread1.start();
		Thread thread2 =new ThreadExample(6, 10);
		thread2.start();
	}
}
