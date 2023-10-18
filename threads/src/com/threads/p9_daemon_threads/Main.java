package com.threads.p9_daemon_threads;

import com.threads.p8_primenumber_exercise.PrimeNumberUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         User Threads : It has to finish it's job
         Daemon Threads : if this thread is running when the application thread ends, it doesn't care if this thread is running, it finishes.
         */
        /**
         Daemon threads doesn't need to end. It can be interrupted if the application thread ends.
         */

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please provide nth : ");
            int nth = sc.nextInt();
            if (nth == 0)
                break;
            Thread thread = new Thread(() -> {
                int num = PrimeNumberUtil.findNthPrimeNumber(nth);
                System.out.println(num);
            });
            thread.setDaemon(true);
            thread.start();
        }

    }
}
