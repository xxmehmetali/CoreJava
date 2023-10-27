package com.junit5.p21_assert_all;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertAllDemoTest {

    @Test
    void test1(){
        System.out.println("test1() method");
        assertEquals(1, 1);
    }

    @Test
    void test2(){
        System.out.println("test2() method");
        assertEquals(1, 1);
    }

    @Test
    void testAll() {
        // all the
        assertAll(
                () -> assertEquals(1,1),
                () -> assertEquals(1,2),
                () -> assertEquals(4,4)
        );
    }

}