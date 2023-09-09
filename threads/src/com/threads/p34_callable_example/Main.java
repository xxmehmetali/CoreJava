package com.threads.p34_callable_example;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();


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
            Future<Integer> calculatedVal = executorService.submit(c);
            // When you call get() on a Future object, it will block until the result is available.
            // So it blocks the program, you have to continue for the next input.
            System.out.println("Calculated value : " + calculatedVal.get());

        }

    }
}
