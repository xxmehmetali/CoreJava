package com.threads.p34_callable_example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * Solution would be a list of Future objects.
         * In each iteration, we will add the Future object to the list and control the list if any of future objects is ready to be read.
         * If it is ready, we will read it and remove it from the list.
         */

        // This example is a little buggy but it clears the logic.

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();

        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please provide a number : ");
            int num = sc.nextInt();

            if (num == 0){
                System.out.println("Threads ended");
                break;
            }
            Callable<Integer> c = () -> {
                return PrimeNumberUtil.findNthPrimeNumber(num);
            };
            Future<Integer> calculatedValFuture = executorService.submit(c);
            futures.add(calculatedValFuture);
            Iterator<Future<Integer>> iterator = futures.iterator();
            // used iterator because of ConcurrentModificationException. If you used stream, you would get ConcurrentModificationException.
            while (iterator.hasNext()){
                Future<Integer> future = iterator.next();
                if(future.isDone()){
                    System.out.println("Calculated value : " + future.get());
                    iterator.remove();
                }
            }

        }

    }

}
