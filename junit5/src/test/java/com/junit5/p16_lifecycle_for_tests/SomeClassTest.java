package com.junit5.p16_lifecycle_for_tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeClassTest {

    @Test
    @DisplayName("Some test display name")
    void someTest(){
        System.out.println("someTest() method");
    }

    @Test
    @DisplayName("Some Disabled test display name")
    @Disabled
    void someDisabledTest(){
        System.out.println("someDisabledTest() method");
        fail(); // This test will not fail because it is disabled
    }

}