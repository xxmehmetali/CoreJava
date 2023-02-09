package com.lambdas;

public class Main {

    public static void main(String[] args) {
        /**
         * lambdas are used to do functional programming
         * lambdas are used to opposite of OOP.
         * lambda = function
         * these special functions can be treated as values.
         *
         * int x = 1;
         * String y = "val";
         * aBlockOfCode = {
         *      .... //SOME CODE
         * }
         * aBlockOfCode is not executed but it is a variable that contains function. It is needed to be executed additionally.
         *
         * Some part of the function is unnecessary when assigning it to lambda.
         * aBlockOfCode = public void perform () {
         *      System.out.println("Hello");
         * }
         * --NO ACCESS MODIFIER NEEDED
         * --NO FUNCTION NAME NEEDED
         * --NO RETURN TYPE NEEDED
         * this is the lambda expression but you need to put -> between () and { :
         * aBlockOfCode = () -> {
         *                System.out.println("Hello");
         *           }
         * if the code is only one line you can use it like (inline lambda exp.) : aBlockOfCode = () -> System.out.println("Hello");
         *
         * if your code is returning a value and the lambda exp. is not one line, you need to use return keyword.
         * On the other hand, if you use one line lambda exp. and returning value, you do not need to use return value.
         * multiplyByTwo = (int a) -> a*2; EQUALS multiplyByTwo = (int a) -> return a*2;
         *
         *
         *
         *
         */

        // OOP
        HelloGreeter helloGreeter = new HelloGreeter();
        helloGreeter.greet();

        // Functional with lambda
        // It has to be compatible with it's interface (the function side).
        LambdaGreeter lambdaGreeter = () -> System.out.println("Lamda Greetings !!");
        // Anonymous Inner Class
        LambdaGreeter lambdaGreeter2 = new LambdaGreeter() {
            @Override
            public void perform() {
                System.out.println("Second Lambda Greetings !!");
            }
        };

        // Lambda expression and Anonymous Inner Class can be used one of each other but the purposes and capabilities are not exactly same.
        //https://www.youtube.com/watch?v=a8jvxBbswp4&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=10 burdan devam
        greet(lambdaGreeter);
        greet(lambdaGreeter2);
    }

    public static void greet(LambdaGreeter greeter) {
        greeter.perform();
    }
}
