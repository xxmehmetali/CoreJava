package com.lambdas.p11_thread_runnable_interface;

public class Main {
    public static void main(String[] args) {
        /** 1 */
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("thread 1");
                    }
                }
        );
        thread1.run();

        /** 2 */
        Thread thread2 = new Thread( () -> System.out.println("thread 2") );
        thread2.run();
    }
}
