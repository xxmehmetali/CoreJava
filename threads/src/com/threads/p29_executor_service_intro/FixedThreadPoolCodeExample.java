package com.threads.p29_executor_service_intro;

import com.threads.p8_primenumber_exercise.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolCodeExample {
    public static void main(String[] args) {

        // ExecutorService is a thread pool
        // FixedThreadPool will have 3 threads in the pool.
        // When you have more tasks than threads, tasks will be queued.
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please provide a number : ");
            int num = sc.nextInt();

            if (num == 0)
                break;

            // execute only accepts Runnable
            executorService.execute( () -> System.out.println("\n" + PrimeNumberUtil.findNthPrimeNumber(num)) );

            // submit accepts both Runnable and Callable
            //executorService.submit( () -> System.out.println("\n" + PrimeNumberUtil.findNthPrimeNumber(num)) );

        }
    }
}
