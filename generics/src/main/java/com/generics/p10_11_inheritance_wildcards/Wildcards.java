package com.generics.p10_11_inheritance_wildcards;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sample-1");
        names.add("Sample-2");

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);

        printList(names);
        printList(nums);

        //----------

        List<?> someList1 = nums;
        List<?> someList2 = names;

        /**Even though types are compatible, compiler will not know if it is.
        List<?> only can be read, not be written.*/
        //someList1.add(3);
        //someList2.add("Sample-3");


    }

    /**
     This method is going to accept anything. But you only can read from it. You cannot write anything inside.
     Because the type is unknown. When you try to put something, it will question the type.
     */
    public static void printList(List<?> lst) {
        lst.forEach(System.out::println);
//        lst.add("");
//        lst.add(new Object());
//        lst.add(2);
    }
}
