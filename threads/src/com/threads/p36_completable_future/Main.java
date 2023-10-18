package com.threads.p36_completable_future;

import com.threads.p34_callable_example.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        /**
         * In Future object we needed to handle if it returned the value or not by ourselves and iterate the Future list in each loop to print what we wanted.
         * Completable Future is a more advanced version of Future. It has some extra methods to handle the result.
         */


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please provide a number : ");
            int num = sc.nextInt();

            if (num == 0) {
                System.out.println("Threads ended");
                break;
            }
            Callable<Integer> c = () -> {
                return PrimeNumberUtil.findNthPrimeNumber(num);
            };

            // supplyAsync accepts Callable. Return some value inside of supplyAsync.
            // And handle it with thenAccept method.
            // All code is minimized with 3 lines of code. You can continue to use .thenAccept(..) method to handle the result again.
            CompletableFuture
                    .supplyAsync(() -> PrimeNumberUtil.findNthPrimeNumber(num))
                    .thenAccept((result) -> System.out.println("Calculated value : " + result)
                    );
            // This thread is placed in ForkJoinPool.commonPool() by default. But you can change it with supplyAsync method.
            // You can provide it with your own ExecutorService. For example:
            // CompletableFuture.supplyAsync(() -> PrimeNumberUtil.findNthPrimeNumber(num), executorService);


        }

    }
}
