package com.lambdas.p8_functional_interfaces;

import com.lambdas.p8_functional_interfaces.interfaces.Greeting;
import com.lambdas.p8_functional_interfaces.interfaces.MathThing;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello world");
        greetImpl(greeting);

        System.out.println(addTwoNumbersImpl( (int a, int b) -> a+b,  1, 2));

    }

    public static void greetImpl(Greeting greeting){
        greeting.greet();
    }

    public static int addTwoNumbersImpl(MathThing mathThing, int a, int b){
        return mathThing.addTwoNumbers(a, b);
    }
}
