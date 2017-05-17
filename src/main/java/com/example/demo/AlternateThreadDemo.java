package com.example.demo;

public class AlternateThreadDemo {
	

	public static void main(String[] args) {
		Object LOCK = new Object();  
		
		Printer aPrinter = new Printer(LOCK);
		Printer bPrinter = new Printer(LOCK);
		
		Thread thread1 = new Thread(aPrinter, "A");
		Thread thread2 = new Thread(bPrinter, "B");
		
		thread1.start();
		thread2.start();
	}
	
}

class Printer implements Runnable {
	
	private Object Lock;
	
	public Printer(Object lock) {
		this.Lock = lock;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			synchronized (Lock) {
				System.out.println(Thread.currentThread().getName() + i);
				Lock.notify();
				
				try {
					Lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}