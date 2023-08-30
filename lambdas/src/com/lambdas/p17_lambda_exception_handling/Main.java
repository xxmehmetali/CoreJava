package com.lambdas.p17_lambda_exception_handling;

import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int key = 2;

        // it works with no problem
        process(nums, key, (n, k) -> System.out.print(n + k + " "));

        // it throws exception
        key = 0;
        //process(nums, key, (n, k) -> System.out.print(n / k + " "));

        // handle it like this [ref1]
        process(nums, key, (n, k) -> {
            try {
                System.out.print(n / k + " ");
            }catch (Exception e){
                System.out.println("An exception happened !!!");
            }

        });

        // or instead of applying [ref1], create an exceptionHandler layer for lambda and handle exceptions on that layer
        process(nums, key, exceptionHandlerBiConsumer( (n, k) -> System.out.println(n / k)) );

    }

    public static void process(int[] nums, int key, BiConsumer<Integer, Integer> consumer){
        for (int i : nums){
            consumer.accept(i, key);
        }
        System.out.println();
        System.out.println();
    }

    public static BiConsumer<Integer, Integer> exceptionHandlerBiConsumer(BiConsumer<Integer, Integer> consumer){
        return (n, k) -> {
            try {
                consumer.accept(n, k);
            } catch (Exception e) {
                System.out.println("An exception happened in handler");
            }
        };
    }


}
