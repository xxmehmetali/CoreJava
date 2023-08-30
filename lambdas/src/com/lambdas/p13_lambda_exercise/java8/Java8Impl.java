package com.lambdas.p13_lambda_exercise.java8;

import com.lambdas.p13_lambda_exercise.Condition2;
import com.lambdas.p13_lambda_exercise.domain.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Java8Impl {

    public static void sortListByName(List<Person> people){
        Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
    }

    public static void printAll(List<Person> people){
        for (Person p : people)
            System.out.println(p);
        System.out.println();
    }


    public static void printAllBeginsWithSpecifiedLetter(List<Person> people, Condition2 Condition2){
        for (Person p : people){
            if (Condition2.test(p))
                System.out.println(p);
        }
        System.out.println();
    }
}
