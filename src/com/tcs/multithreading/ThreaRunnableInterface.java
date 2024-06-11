package com.tcs.multithreading;

class Task {
	public void sumOfAllEvenNo(int startingNo, int endingNo) {
		int finalOutPut = 0;
		for (; startingNo < endingNo; startingNo++)
			if (startingNo % 2 == 0) {
				System.out.print(startingNo+" ");
				finalOutPut += startingNo;
			}
		System.out.println("Sum Of all Even Numbers from:-"+finalOutPut);
	}
}

class Student implements Runnable {
	private Task task;
	private int startingNo;
	private int endingNo;

	public Student(Task task,int startingNo, int endingNo) {
		this.task=task;
		this.startingNo = startingNo;
		this.endingNo = endingNo;
	}

	@Override
	public void run() {
		task.sumOfAllEvenNo(startingNo, endingNo);
	}

}

public class ThreaRunnableInterface {
	public static void main(String[] args) {
		Task task=new Task();
		Runnable runnable=new Student(task,0, 20);
		Thread thread=new Thread(runnable);
		thread.start();
		
		Runnable runnable1=new Student(task,20, 40);
		Thread thread1 = new Thread(runnable1);
		thread1.start();
	}
}
