package com.lambdas.p19_closures;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        //that b's value below is 20. It must be a [final, effectively final or an Atomic type].
        /**
            effectively final : it shouldn't be changed. It will be effectively final if declared once but never changed.
            final : defined with final keyword.
            atomic type : Uses atomic types.
         */
        doProcess(a, i -> System.out.println(i + b));

    }

    public static void doProcess(int i, Process process){
        process.process(i);
    }
}

interface Process{
    void process(int i);
}
