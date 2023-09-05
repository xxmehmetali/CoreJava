package com.generics.p10_11_inheritance_wildcards;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Name-1");
        names.add("Name-2");

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);

        //You should pass List<Object> to that method.
        //printList(names);
        //printList(nums);


    }

    /**This method should only accept List of Objects. String is an Object type, we know that.
    Logically List of String is also be accepted but when it comes to generic types, it is strict
    If you write List<Object> as argument, then it only accepts List<Object>. Not any inherited types like String, Integer*/
    public static void printList(List<Object> lst){
        lst.forEach(System.out::println);
    }

    /**This method accepts any of type.
     It is okay to read values inside but writing is not. You can write any type into list but it will cause to trouble type safety.
     */
    public static void printList2(List lst){
        lst.forEach(System.out::println);
        lst.add(2);
        lst.add("Sample");
    }
}
