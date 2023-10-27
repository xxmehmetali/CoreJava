package com.junit5.p7_creating_junit_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilsTest {

    @Test
        // Junit runs this as test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        // it checks if the expected value is equal to the actual value
        assertEquals(expected, actual, "Add method should return 2");
    }

    @Test
    public void testDivide() {
        MathUtils mathUtils = new MathUtils();
        // assertThrows takes a lambda expression and runs the supplier.
        // If the supplier throws an exception that matches with passed exception argument, the test passes
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw!");
    }

    @Test
    void testComputeCircleArea() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

}