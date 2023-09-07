package com.generics.p7_typed_arrays;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String[] names = new String[5];
        names[0] = "Name-1";
        System.out.println(names[0]);

        addToArray(names, "Name-2");
        System.out.println(names[0]);

        addToArrayCheatOnCompiler(names, 1);
        System.out.println(names[0]);
    }

    private static void addToArray(String[] names, String str) {
        names[0] = str;
    }

    //You will have a object array, it is okay because String is also an object type. So string[] is object[].
    private static void addToArrayCheatOnCompiler(Object[] names, int i) {
        //the problem is here that string[] is instantiated in the memory as string. So when you put integer into string list, it will throw an exception : ArrayStoreException
        //Note that while working on list, you can put integer into a string list and do not have any problem. The problem is when you try to get an element from that list and assign it to an unrelated data type. (int-string).
        names[0] = i;
    }
}
