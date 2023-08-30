package com.lambdas.p9_anonymous_innerclass;

import com.lambdas.p9_anonymous_innerclass.interfaces.MathThing;

public class Main {
    public static void main(String[] args) {

        //Defining an interface's implementation makes it class and also you do not give it a name, so it is anonymous. It is also inside of another class so it is an inner class.
        MathThing mathThing = new MathThing() {
            @Override
            public int addTwoNumbers(int a, int b) {
                return a+b;
            }
        };

        //lambda
        MathThing mathThing2 = (int a, int b) -> a+b;

        //Notice that lambda and anonymous inner class is not same but works same.

        System.out.println(mathThing.addTwoNumbers(1, 2));
        System.out.println(mathThing2.addTwoNumbers(5,5));

    }
}
