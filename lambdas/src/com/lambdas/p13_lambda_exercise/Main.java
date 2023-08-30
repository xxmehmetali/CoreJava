package com.lambdas.p13_lambda_exercise;

import com.lambdas.p13_lambda_exercise.domain.Person;
import com.lambdas.p13_lambda_exercise.java7.Java7Impl;
import com.lambdas.p13_lambda_exercise.java8.Java8Impl;
import com.lambdas.p13_lambda_exercise.java8.Java8Impl2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * Q1: Sort list by lastname
         * Q2: Crate a method that prints all elements in the list
         * Q3: Create a method that prints all people have last name beginning with A
         * */
        List<Person> people = Arrays.asList(
                new Person("Ali", "Karadağ", 23),
                new Person("Tülay", "Karadağ", 22),
                new Person("Ahmet", "Bülbül", 67),
                new Person("Selim", "Akkuyu", 13),
                new Person("Cansu", "Yağcılar", 32)
        );

        /** JAVA 7 SOLUTIONS */
        System.out.println("JAVA 7");
        System.out.println("List sorted by name:");
        Java7Impl.sortListByName(people);
        System.out.println(people);
        System.out.println("All list printed:");
        Java7Impl.printAll(people);
        System.out.println("All people whose name starts with A printed:");
        Java7Impl.printAllBeginsWithA(people);
        System.out.println();
        System.out.println("All people whose name starts with specified character printed:");
        Java7Impl.printAllBeginsWithSpecifiedLetter(
                people,
                new Condition() {
                    @Override
                    public boolean test(String testString, String beginningStr) {
                        return testString.toLowerCase().startsWith(beginningStr);
                    }
                },
                "T".toLowerCase()
        );

        /** JAVA 8 SOLUTIONS */
        System.out.println("JAVA 8");
        System.out.println("List sorted by name:");
        Java8Impl.sortListByName(people);
        System.out.println(people);
        System.out.println("All list printed:");
        Java8Impl.printAllBeginsWithSpecifiedLetter(people, p -> true);
        System.out.println("All people whose name starts with A printed:");
        Java8Impl.printAllBeginsWithSpecifiedLetter(people, (p) -> p.getFirstName().startsWith("T"));
        System.out.println();
        System.out.println("All people whose name starts with specified character printed:");
        Java8Impl.printAllBeginsWithSpecifiedLetter(people, (p) -> p.getFirstName().startsWith("T"));

        System.out.println("Predicate version:");
        Java8Impl2.printAllBeginsWithSpecifiedLetter(people, p -> p.getFirstName().length() > 3);
        Java8Impl2.printAllBeginsWithSpecifiedLetter2(people, p -> p.getAge() <= 23, p -> System.out.println(p.getFirstName() + " " + p.getLastName()));


    }

}
