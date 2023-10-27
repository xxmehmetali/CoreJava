package com.threads.p20_critical_section;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
        //Many threads can access the same object.
        Thread t1 = new Thread(counter, "Thread One");
        Thread t2 = new Thread(counter, "Thread Two");
        Thread t3 = new Thread(counter, "Thread Three");
        Thread t4 = new Thread(counter, "Thread Four");

        Counter counter2 = new Counter();
        Thread t5 = new Thread(counter2, "Counter2 Thread One");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
