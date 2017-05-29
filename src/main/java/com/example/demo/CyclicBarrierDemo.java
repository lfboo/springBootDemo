package com.example.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lvfeibiao
 * @date 2017/5/29
 */
public class CyclicBarrierDemo {

    private static final int THREAD_NUM = 5;

    static class WorkThread implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public WorkThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            try {
                cyclicBarrier.await();
                System.out.println("name:" + Thread.currentThread().getName() + " working...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
                @Override
                public void run() {
                    System.out.println("all thread reach barrier");
                }
            });

            for (int i = 0; i < 5; i++) {
                new Thread(new WorkThread(cyclicBarrier)).start();
            }
        }
    }



}
