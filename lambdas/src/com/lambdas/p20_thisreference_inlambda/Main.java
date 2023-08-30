package com.lambdas.p20_thisreference_inlambda;

/**
    1-while using this keyword in anonymous inner class, you will access the anonymous inner class, not the outsider class.
    2-while you use this keyword in lambda expression, it will automatically uses current class
    3-if you are using this keyword in a static context in lambda expression, it will not compile.
 */

public class Main {
    public void execute(){
        doProcess(10, i -> {
            System.out.println(i);
            //outside class
            System.out.println(this);
        });
    }

    public void execute2(){
        doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println(i);
                //anonymous inner class
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "Anon inner class";
            }
        });
    }

    public void execute3(){
        doProcess(10, i -> {
            System.out.println(i);
            //outside class
            System.out.println(this);
        });
    }

    public void doProcess(int i, Process process){
        process.process(i);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("execute");
        main.execute();
        System.out.println("--------\nexecute2");
        main.execute2();
        System.out.println("--------\nexecute3");
        main.execute3();

        main.doProcess(10, i-> {
            System.out.println(i);
            //This is a static method so you cannot have this keyword here!
            //System.out.println(this);
        });
    }
}

interface Process{
    void process(int i);
}