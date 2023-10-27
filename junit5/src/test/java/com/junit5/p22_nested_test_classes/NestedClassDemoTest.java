package com.junit5.p22_nested_test_classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class NestedClassDemoTest {

    @Test
    @DisplayName("test-1")
    void test1(){
        System.out.println("test1() method");
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("test-2")
    void test2(){
        System.out.println("test2() method");
        assertEquals(1, 1);
    }

    @Nested
    @DisplayName("nested-test-class")
    class NestedTest {
        @Test
        @DisplayName("nested-test-1")
        void nestedTest1(){
            System.out.println("nestedTest1() method");
            assertEquals(1, 1);
        }

        @Test
        @DisplayName("nested-test-2")
        void nestedTest2(){
            System.out.println("nestedTest2() method");
            assertEquals(1, 1);
        }
    }

}