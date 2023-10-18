package com.threads.p38_forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int[] inputNumbers = {2, 4, 6, 12, 44, 67};
        //ForkJoinPool is a thread pool that manages worker threads that execute ForkJoinTask
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //invoke() method submits the task to the pool and waits for it to complete
        Integer result = forkJoinPool.invoke(new CalculatePrimeTask(inputNumbers, 0, inputNumbers.length - 1));
        System.out.println("Result = " + result);
    }
}
