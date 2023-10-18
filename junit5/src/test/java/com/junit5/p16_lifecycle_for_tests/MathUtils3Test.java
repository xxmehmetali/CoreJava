package com.junit5.p16_lifecycle_for_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtils3Test {

    private MathUtils3 mathUtils3;

    //This will run before each test method
    @BeforeEach
    void init(){
        mathUtils3 = new MathUtils3();
    }
    /*
    * Life Cycle Annotations:
    * @BeforeEach: This will run before each test method
    * @BeforeAll: This will run once before all test methods    // NEEDS TO BE STATIC because it runs before the instance is created. So it has to be owned by class.
    * @AfterEach: This will run after each test method
    * @AfterAll: This will run once after all test methods      // NEEDS TO BE STATIC because it runs before the instance is created. So it has to be owned by class.
    * */

    @Test
    void testAdd()         // Junit runs this as test
    {
        int expected = 2;
        int actual = mathUtils3.add(1, 1);
        // it checks if the expected value is equal to the actual value
        assertEquals(expected, actual, "Add method should return 2");
    }

    @Test
    public void testDivide() {
        // assertThrows takes a lambda expression and runs the supplier.
        // If the supplier throws an exception that matches with passed exception argument, the test passes
        assertThrows(ArithmeticException.class, () -> mathUtils3.divide(1, 0), "Divide by zero should throw!");
    }

    @Test
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils3.computeCircleArea(10), "Should return right circle area");
    }

}