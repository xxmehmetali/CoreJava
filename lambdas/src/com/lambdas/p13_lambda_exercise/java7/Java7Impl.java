package com.lambdas.p13_lambda_exercise.java7;

import com.lambdas.p13_lambda_exercise.Condition;
import com.lambdas.p13_lambda_exercise.domain.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Java7Impl {

    public static void sortListByName(List<Person> people){
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getFirstName().compareTo(person2.getFirstName());
            }
        });
    }

    public static void printAll(List<Person> people){
        for (Person p : people)
            System.out.println(p);
        System.out.println();
    }

    public static void printAllBeginsWithA(List<Person> people){
        for (Person p : people){
            if (p.getFirstName().toLowerCase().startsWith("a"))
                System.out.println(p);
        }
        System.out.println();
    }

    public static void printAllBeginsWithSpecifiedLetter(List<Person> people, Condition condition, String beginningStr){
        for (Person p : people){
            if (condition.test(p.getFirstName(), beginningStr))
                System.out.println(p);
        }
        System.out.println();
    }
}
