package com.threads.p6_code_intro;

public class Main {
    public static void main(String[] args) {
        //lambda
        Runnable code = () -> System.out.println("something");
        Thread thread = new Thread(code);
        thread.run();

        Thread thread1_1 = new Thread( () -> {/**code */} );

        //Class impl
        Runnable code2 = new CodeImpl();
        Thread thread2 = new Thread(code2);
        thread2.run();

        //anon inner class
        Runnable code3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("anon inner class");
            }
        };
        Thread thread3 = new Thread(code3);
        thread3.run();
    }
}
