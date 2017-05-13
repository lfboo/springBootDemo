package com.example.demo;

public class TestMultiThread {
	
	public static void main(String[] args) {
		TestMultiThread.Wicket wicket =  new TestMultiThread().new Wicket();
		Thread wicket1 = new Thread(wicket, "售票窗口1");
		Thread wicket2 = new Thread(wicket, "售票窗口2");
		Thread wicket3 = new Thread(wicket, "售票窗口3");
		
		wicket1.start();
		wicket2.start();
		wicket3.start();
	}
	
	class Wicket implements Runnable {
		private int totalTicketNum = 500;

		@Override
		public void run() {
			for (int i = 0; i < totalTicketNum; i++) {
				synchronized (this) {
					if (totalTicketNum > 0) {
						System.out.println(Thread.currentThread().getName() + " 卖票，剩余" + (--totalTicketNum));
					}
				}
			}
		}
		
	}
}
