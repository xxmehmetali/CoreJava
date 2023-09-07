package com.threads.p15_thread_interruption;


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
                    //Thread.sleep() also throws InterruptedException
                    Thread.sleep(5000);
                    printThreadStates(threads);
                }
            }catch (InterruptedException e){
                //if interrupt() method is called, here is the exiting scenerio. Do something before thread is shutdowned.
                System.out.println("Status reporter interrupted..");
            }

        };
        Thread statusReporterThread = new Thread(statusReporter);
        statusReporterThread.setDaemon(true);
        statusReporterThread.start();

        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please provide a number : ");
            int num = sc.nextInt();

            if (num == 0){
                //This interrupt() method will make the statusReporter to throw InterruptedException. So the catch block will run in case of interruption.
                statusReporterThread.interrupt();

                System.out.println("Waiting for all threads to finish!");
                waitForThreads(threads);
                System.out.println("Threads ended : size = " + threads.size());

                break;
            }
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

    public static void waitForThreads(List<Thread> threads){
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
