package com.threads.p29_executor_service_intro;


import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecuterCodeExample {
    public static void main(String[] args) {
        // SingleThreadExecuter will have 1 thread in the pool.
        // If it is busy, tasks will be queued.
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
