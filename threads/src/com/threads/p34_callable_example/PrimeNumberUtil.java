package com.threads.p34_callable_example;

public class PrimeNumberUtil {
    public static int findNthPrimeNumber(int nth){
        int num, count, i;
        num=1;
        count=0;

        while (count < nth){
            num=num+1;
            for (i = 2; i <= num; i++){ //Here we will loop from 2 to num
                if (num % i == 0) {
                    break;
                }
            }
            if ( i == num){//if it is a prime number
                count = count+1;
            }
        }
        return num;

    }
}
