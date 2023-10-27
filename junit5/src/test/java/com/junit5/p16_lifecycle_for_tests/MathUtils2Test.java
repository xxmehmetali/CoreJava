package com.junit5.p16_lifecycle_for_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtils2Test {

    /** CLASS MEMBERS VALUES SHOULDN'T BE INITIALIZED LIKE THIS */
    /** For each test, this MathUtilsTest class will be instantiated
     * and the someValue member initalized again and again. Other methods
     * that depends on this value won't see the changed value.*/
    private int someValue = 1;

    @Test
        // Junit runs this as test
    void testAdd() {
        //MathUtilsTest class is instantiated for this method and value changed to 2.
        someValue = 2;

        MathUtils2 mathUtils = new MathUtils2();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        // it checks if the expected value is equal to the actual value
        assertEquals(expected, actual, "Add method should return 2");
    }

    @Test
    public void testDivide() {
        //MathUtilsTest class is instantiated for this method and value is checked if it is 2.
        //But it is not 2, it is 1. testAdd() method changed the value for it's own instance, not for this method's instance.
        //So the value will be 1 for this method.
        if (someValue == 2)
            System.out.println("someValue is 2");

        MathUtils2 mathUtils = new MathUtils2();
        // assertThrows takes a lambda expression and runs the supplier.
        // If the supplier throws an exception that matches with passed exception argument, the test passes
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw!");
    }

    @Test
    void testComputeCircleArea() {
        MathUtils2 mathUtils = new MathUtils2();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

}