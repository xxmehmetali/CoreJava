package com.threads.p20_critical_section;

public class Counter implements Runnable {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int getValue() {
        return c;
    }

    @Override
    public void run() {
        //what is critical section?
        //critical section is the part of the program where the shared resource is accessed.

        //provides uninterrupted running (MUTual EXclusion (mutex) ,atomicity)
        //otherwise while incrementing and decrementing the value, other threads can interrupt and change the value or print the wrong value.
        //"this" is the object that is being locked.
        //You can use different objects but you have to assign unique objects to each runnable. Otherwise 2 different unrelated Runnable will wait for each other to finish.
        synchronized (this){
            increment();
            System.out.println("Thread: " + Thread.currentThread().getName() + " is incremented : " + getValue());
            decrement();
            System.out.println("Thread: " + Thread.currentThread().getName() + " is decremented : " + getValue());
        }

    }

    //this use is also valid. It makes whole method synchronized.
    //structured lock
    public synchronized void someMethod(){

    }

    public void someMethod2(){
        //structured lock
        synchronized (this){

        }
        //there may be some code here also
    }
}
