package com.threads.p29_executor_service_intro;

import com.threads.p8_primenumber_exercise.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorCodeExample {
    public static void main(String[] args) {
        // For more functionality, use ThreadPoolExecutor instead of ExecutorService
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        // You have to cast to ScheduledExecutorService to use scheduleAtFixedRate method
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) Executors.newScheduledThreadPool(1);
        Runnable r = () -> {
            System.out.println("\nReporter running !!");
            System.out.println("current running threads : " + executorService.getActiveCount());
            System.out.println("finished threads : " + executorService.getCompletedTaskCount());
        };
        scheduledExecutorService.scheduleAtFixedRate(r, 1, 3, TimeUnit.SECONDS);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please provide a number : ");
            int num = sc.nextInt();

            if (num == 0)
                break;

            // execute only accepts Runnable
            executorService.execute(() -> {
                System.out.println("\nvalue : " + PrimeNumberUtil.findNthPrimeNumber(num));
            });

            // submit accepts both Runnable and Callable
            //executorService.submit( () -> System.out.println("\n" + PrimeNumberUtil.findNthPrimeNumber(num)) );

        }
    }
}
