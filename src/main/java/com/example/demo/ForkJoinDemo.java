package com.example.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author lvfeibiao
 * @date 2017/5/29
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 100);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
    }

    private static class CountTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 10;
        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (end - start <= THRESHOLD) {
                for(int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                int middle = (start + end) / 2;
                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle + 1, end);

                leftTask.fork();
                rightTask.fork();

                int leftResult = leftTask.join();
                int rightResult = rightTask.join();
                sum = leftResult + rightResult;
            }
            return sum;
        }
    }

}
