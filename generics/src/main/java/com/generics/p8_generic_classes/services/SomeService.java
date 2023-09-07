package com.generics.p8_generic_classes.services;

public class SomeService<T> {
    T t1;
    T t2;

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }

    public T getT2() {
        return t2;
    }

    public void setT2(T t2) {
        this.t2 = t2;
    }

    public void summarize(){
        System.out.println(t1.toString() + "\n" + t2.toString());
    }
}
