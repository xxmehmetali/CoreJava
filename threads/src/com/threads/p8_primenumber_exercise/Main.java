package com.threads.p8_primenumber_exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please provide nth : ");
            int nth = sc.nextInt();
            Thread thread = new Thread(() -> {
                int num = PrimeNumberUtil.findNthPrimeNumber(nth);
                System.out.println(num);
            });
            thread.start();
        }
    }
}
