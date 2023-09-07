package com.threads.p7_thread_class;

public class CustomThread extends Thread{

    @Override
    public void run() {
        //the logic you want to implement by not providing runnable
        System.out.println("custom thread has run by overriding run() method!!");
    }
}
