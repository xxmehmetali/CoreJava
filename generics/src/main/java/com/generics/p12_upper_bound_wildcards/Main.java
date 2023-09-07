package com.generics.p12_upper_bound_wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intNums = new ArrayList<>();
        intNums.add(1);
        intNums.add(2);

        List<Double> doubleNums = new ArrayList<>();
        doubleNums.add(1.0);
        doubleNums.add(2.0);

        print(intNums);
        print(doubleNums);


    }

    //upper bound wild card : <? extends smt>
    public static void print(List<? extends Number> nums) {
        nums.forEach(System.out::println);
        Number number = nums.get(0);
        System.out.println(number);
    }
}
