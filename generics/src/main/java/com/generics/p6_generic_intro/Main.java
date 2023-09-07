package com.generics.p6_generic_intro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Ali");
        names.add("Veli");
        names.add("Cuma");

        /**will get error because list is in String type. This is a compile time error.*/
        //names.add(1);
        System.out.println(names);

        addStrToList(names, "SampleName");
        System.out.println(names);

        addIntToList(names, 1);
        System.out.println(names);

        /**4th element is not string. It is added at somewhere out of this scope.*/
        //it will throw ClassCastException in runtime.
        String el4 = names.get(4);
    }

    public static void addStrToList(List<String> lst, String str){
        lst.add(str);
    }

    //always use generics while using collections
    public static void addIntToList(List lst, Integer integer){
        //note that lst does not have any parameterized type (<T>)
        //it will add integer but will cause problem in future while try to work with elements inside list
        lst.add(integer);
    }
}
