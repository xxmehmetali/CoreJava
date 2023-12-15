package stream_api_practice_2;

import java.util.Arrays;
import java.util.List;

public class LazyEvaluation {
    public static void main(String[] args) {
        int num = doOperation();
        System.out.println(num);
        /**
            OUTPUT :
                 isGT3 : 1
                 isGT3 : 2
                 isGT3 : 3
                 isGT3 : 4
                 isEven : 4
                 doubleIt : 4
                 8
         */
    }

    /**
        conditions:
     *      greater than 3
     *      even
        int.operations:
            double
        terminal.operations:
            findFirst
     *
     * */
    public static int doOperation() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        return nums.stream()
                .filter(LazyEvaluation::isGT3)  //is applied for 1
                .filter(LazyEvaluation::isEven) //is applied for 1
                .map(LazyEvaluation::doubleIt)  //is applied for 1
                .findFirst()                    //
                .orElse(0);
        //filter and map functions are not runned until findFirst() is called.
        /*
            iteration : 1
                isGT3           (element = 1)
            iteration : 2
                isGT3           (element = 1)
            iteration : 3
                isGT3           (element = 1)
            iteration : 4
                isGT3           (element = 1)
                isEven          (element = 1)
                doubleIt        (element = 1)

            ***
            iteration : 1
                isGT3           (element = 2)
            iteration : 2
                isGT3           (element = 2)
            iteration : 3
                isGT3           (element = 2)
            iteration : 4
                isGT3           (element = 2)
                isEven          (element = 2)
                doubleIt        (element = 2)
            ***
            ...goes on

            NOTE THAT THESE OPERATIONS ARE NOT RUNNED UNTIL FINDFIRST() METHOD CALLED.
            When you call findFirst() it iterate over list like this.

            Not like this :
            iteration : 1
                isGT3           (element = 1)
                isGT3           (element = 2)
                isGT3           (element = 3)
                isGT3           (element = 4)
                isGT3           (element = 5)
                isGT3           (element = 6)
                  ....
            iteration : 2
                isEven           (element = 4)
                isEven           (element = 5)
                isEven           (element = 6)
                  ....
            iteration : 3
                doubleIt           (element = 8)
                doubleIt          (element = 10)
                doubleIt        (element = 12)
                 ....
             iteration : 4
                findFirst()      element = 8


             This would cause performance issues. Lazy Evaluation is more efficient.

         */

    }

    public static boolean isGT3(int num) {
        System.out.println("isGT3 : " + num); // side effect
        return num > 3;
    }

    public static boolean isEven(int num) {
        System.out.println("isEven : " + num); // side effect
        return num % 2 == 0;
    }

    public static int doubleIt(int num) {
        System.out.println("doubleIt : " + num); // side effect
        return num * 2;
    }

    /**
     * NOTE THAT SIDE EFFECT SHOULDN'T USED
     * FOR INSTANCE, When you iterate over stream, not all the elements are iterated but you want to log something for all elements.
     * Or instead logging, you want to push elements to kafka or rabbitmq into different topics.
     * But not all the elements are iterated. So if you do this operation in stream you could misfunction.
     * Let's say you have filter in stream and then you suck because iteration is decreased so not all the elements are pushed to kafka|rabbitmq or logged.
     * -- FOCUS ONLY THE THING YOU WANT TO DO. --
     * -- DO NOT DO ANY OTHER OPERATION THAN GETTING THE ACTUAL WANTED DATA. --
     */

}
