package com.lambdas.p21_method_reference;

import com.lambdas.p13_lambda_exercise.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ali", "Karadağ", 23),
                new Person("Tülay", "Karadağ", 22),
                new Person("Ahmet", "Bülbül", 67),
                new Person("Selim", "Akkuyu", 13),
                new Person("Cansu", "Yağcılar", 32)
        );

        printAllBeginsWithSpecifiedLetter2(people, (person) -> true, (person) -> System.out.println(person));
        printAllBeginsWithSpecifiedLetter2(people, (person) -> true, System.out::println);

        /**
                () -> someMethod();             ===     ClassName::someMethod
                (param) -> someMethod2(param)   ===     ClassName::someMethod2
         */

        Thread thread = new Thread(Main::someMethod);
        thread.run();

    }


    public static void printAllBeginsWithSpecifiedLetter2(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people){
            if (predicate.test(p)){
                consumer.accept(p);
            }
        }
        System.out.println();
    }

    public static void someMethod(){
        System.out.println("hii");
    }
}
