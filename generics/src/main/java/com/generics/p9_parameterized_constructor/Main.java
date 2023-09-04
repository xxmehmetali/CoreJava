package com.generics.p9_parameterized_constructor;


import com.generics.p9_parameterized_constructor.services.SomeService;

public class Main {
    public static void main(String[] args) {
        //Parameterized declaration        Not parameterized constructor
        SomeService<Integer> someService = new SomeService(2, "str");
        System.out.println(someService.getT1() * 2);
        //This line will cause exception because it was declared that the parameterized type is Integer but you assigned String for variable
        System.out.println(someService.getT2() * 2);

        /**                                  Now you have to declare both parameters as said (Parameterized type is Integer while instantiating)*/
        /**SomeService<Integer> someService2 = new SomeService<Integer>(1, "");*/

        //You may also not set the parameterized types in declaration but it is recommended.
        SomeService someService3 = new SomeService<Integer>(1, 2);

        //10.videoda kaldın
    }
}
