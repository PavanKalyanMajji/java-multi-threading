package com.tcs.multithreading;
class Project {
	public synchronized void taskSumOfAllEvenNo(int startingNo, int endingNo) {
		int finalOutPut = 0;
		for (; startingNo < endingNo; startingNo++)
			if (startingNo % 2 == 0) {
				System.out.print(startingNo+" ");
				finalOutPut += startingNo;
			}
		System.out.println("Sum Of all Even Numbers from:-"+finalOutPut);
	}
}

class Company implements Runnable {
	private Project project;
	private int startingNo;
	private int endingNo;

	public Company(Project project,int startingNo, int endingNo) {
		this.project=project;
		this.startingNo = startingNo;
		this.endingNo = endingNo;
	}

	@Override
	public void run() {
		project.taskSumOfAllEvenNo(startingNo, endingNo);
	}

}
public class SynchronizedThread {
	public static void main(String[] args) {
		Project project=new Project();
		Runnable runnable=new Company(project, 40, 60);
		Thread thread=new Thread(runnable);
		thread.start();
		
		Runnable runnable1=new Company(project, 60, 80);
		Thread thread1=new Thread(runnable1);
		thread1.start();
	}
}
