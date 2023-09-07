package com.threads.p7_thread_class;

public class Main {
    public static void main(String[] args) {
        /**
         .run() method runs the runnable inside of Thread class. Since you overrided the run() method, it doesn't runs the runnable object. Instead applies what you provided to it.
         */
        new CustomThread().run();

        //8th video continue
    }
}
