package com.generics.p4_boxing;

public class Main {
    public static void main(String[] args) {
        /**Autoboxing*/
        int a = 10;
        //a is boxed
        Integer aWrapper = a;

        /**Unboxing*/
        Integer bWrapper = new Integer(20);
        //bWrapper is unboxed
        int b = bWrapper;


    }
}
