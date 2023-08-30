package com.lambdas.p10_lambda_basics;

import com.lambdas.p10_lambda_basics.interfaces.MathThing;
import com.lambdas.p10_lambda_basics.interfaces.StringFuncInterface;

public class Main {
    public static void main(String[] args) {

        MathThing mathThing = (int a, int b) -> a+b;

        //dont need to specify types. It knows types from contract in functional interface
        MathThing mathThing2 = (a, b) -> a+b;

        //all valid
        StringFuncInterface stringFuncInterface = (String str) -> str.length();
        StringFuncInterface stringFuncInterface2 = (str) -> str.length();
        /** if there is only one parameter, then you can write it without pharantesis */
        StringFuncInterface stringFuncInterface3 = str -> str.length();

        lambda(stringFuncInterface);
    }

    public static void lambda(StringFuncInterface stringFuncInterface){
        System.out.println(stringFuncInterface.getLength("hello"));
    }
}
