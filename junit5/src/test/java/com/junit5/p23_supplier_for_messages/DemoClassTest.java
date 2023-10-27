package com.junit5.p23_supplier_for_messages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class DemoClassTest {

    @Test
    @DisplayName("some test")
    void someTest() {
        int expected = 1;
        int actual = 1;
        //"expected " + expected + " but found " + actual
        //is hard to create. So we can use Supplier<String> to create it
        //if the test only fails, then only the supplier will be executed
        //note that you use local variable in a supplier. So variables's value shouldn't be changed in this scope.
        //if you change the value of the variable, code will not compile.
        //if you really want to change the value, assign the value to a new variable (final or effectively final) and use it in the supplier
        assertEquals(expected, actual, () -> "expected " + expected + " but found " + actual);
    }
}