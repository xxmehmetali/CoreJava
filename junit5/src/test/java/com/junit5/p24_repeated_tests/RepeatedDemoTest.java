package com.junit5.p24_repeated_tests;

import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.RepetitionInfo;

class RepeatedDemoTest {

    @RepeatedTest(3)
    void someTest(){
        System.out.println("someTest() test");
        /*
        * OUTPUT :
        *   someTest
        *       repitition 1 of 3
        *       repitition 2 of 3
        *       repitition 3 of 3
        * */
    }

    @RepeatedTest(5)
    void someTest2(RepetitionInfo repetitionInfo){
        repetitionInfo.getTotalRepetitions(); // returns int
        repetitionInfo.getCurrentRepetition(); // returns int

        // you can use repetitions to create dynamic tests
        // make some logic on n th iteration of test.
    }



}