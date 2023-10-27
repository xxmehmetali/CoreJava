package com.threads.p38_forkjoin;

import java.util.concurrent.RecursiveTask;


public class CalculatePrimeTask extends RecursiveTask<Integer> {

    int[] array;
    int start;
    int end;

    public CalculatePrimeTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start == end) {
            return PrimeNumberUtil.findNthPrimeNumber(array[start]);
        }
        if (end - start == 1) {
            return PrimeNumberUtil.findNthPrimeNumber(array[start]) + PrimeNumberUtil.findNthPrimeNumber(array[end]);
        }
        int mid = (start + end) / 2;
        CalculatePrimeTask subTask1 = new CalculatePrimeTask(array, start, mid);
        CalculatePrimeTask subTask2 = new CalculatePrimeTask(array, mid + 1, end);
        //invokeAll() method submits the tasks to the pool and waits for them to complete
        invokeAll(subTask1, subTask2);
        //join() method waits for the task to complete and returns the result. It is similar to get() method of Future in terms of being a blocking call.
        return subTask1.join() + subTask2.join();
    }
}
