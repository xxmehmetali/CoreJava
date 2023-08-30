package com.lambdas.p13_lambda_exercise.java8;

import com.lambdas.p13_lambda_exercise.Condition2;
import com.lambdas.p13_lambda_exercise.domain.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Java8Impl2 {

    public static void printAllBeginsWithSpecifiedLetter(List<Person> people, Predicate<Person> predicate){
        for (Person p : people){
            if (predicate.test(p))
                System.out.println(p);
        }
        System.out.println();
    }

    public static void printAllBeginsWithSpecifiedLetter2(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people){
            //predicate will test person (implementation comes from caller method)
            if (predicate.test(p)){
                //consumer is a void metod that does something inside. Implementation comes from caller method
                consumer.accept(p);
            }
        }
        System.out.println();
    }

}
