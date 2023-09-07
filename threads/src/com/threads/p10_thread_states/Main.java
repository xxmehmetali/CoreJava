package com.threads.p10_thread_states;

import com.threads.p8_primenumber_exercise.PrimeNumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        Runnable statusReporter = () -> {
            try {
                while (true) {
                    //do not make verbosity full time. Wait for a bit user to enter a number and then report.
                    Thread.sleep(5000);
                    printThreadStates(threads);
                }
            }catch (InterruptedException e){
                System.out.println("Exiting..");
            }

        };
        Thread statusReporterThread = new Thread(statusReporter);
        statusReporterThread.setDaemon(true);
        statusReporterThread.start();

        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please provide a number : ");
            int num = sc.nextInt();

            if (num == 0)
                break;

            Thread primeNumThread = new Thread( () -> System.out.println("\n" + PrimeNumberUtil.findNthPrimeNumber(num)) );
            threads.add(primeNumThread);
            primeNumThread.start();
        }
    }

    public static void printThreadStates(List<Thread> threads){
        System.out.println("\nStatusses : ");
        threads.forEach(t -> System.out.print(t.getState() + " "));
        System.out.println();
    }
}
