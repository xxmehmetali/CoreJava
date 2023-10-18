package com.threads.p29_executor_service_intro;

import com.threads.p8_primenumber_exercise.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutorCodeExample {
    public static void main(String[] args) {

        // CachedThreadPool will have 0 threads in the pool default. It will create threads as needed.
        // No limit on the number of threads. As many as needed.
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please provide a number : ");
            int num = sc.nextInt();

            if (num == 0)
                break;

            // execute only accepts Runnable
            executorService.execute(() -> System.out.println("\n" + PrimeNumberUtil.findNthPrimeNumber(num)));

            // submit accepts both Runnable and Callable
            //executorService.submit( () -> System.out.println("\n" + PrimeNumberUtil.findNthPrimeNumber(num)) );
        }
    }
}
