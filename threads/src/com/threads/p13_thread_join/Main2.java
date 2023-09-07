package com.threads.p13_thread_join;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();


        t1.join();
        //Below lines will wait to run for t1. After t1 finished then below lines will be runned.
        //join method make waits the scope for thread to finish.
        System.out.println("Finished !!");
    }

    /**
                                                                TimeLine
                0       1       2       3       4       5       6       7       8       9       10      11      12
        T1      Hello   Hello   Hello   Hello   Hello
        T2      Hi                      Hi                      Hi                      Hi                      Hi
        MAIN                                    Finished !!
                                                (waits T1 to finish)
     */
}
