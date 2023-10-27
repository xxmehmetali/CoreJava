package com.junit5.p16_lifecycle_for_tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) // DEFAULT ONE
    // Each method will have its own instance of the test class
class MathUtils4Test {
    private MathUtils4 mathUtils4;

    //This will run before each test method
    @BeforeEach
    void init(){
        mathUtils4 = new MathUtils4();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @Test
    void testAdd()         // Junit runs this as test
    {
        int expected = 2;
        int actual = mathUtils4.add(1, 1);
        // it checks if the expected value is equal to the actual value
        assertEquals(expected, actual, "Add method should return 2");
    }

    @Test
    public void testDivide() {
        // assertThrows takes a lambda expression and runs the supplier.
        // If the supplier throws an exception that matches with passed exception argument, the test passes
        assertThrows(ArithmeticException.class, () -> mathUtils4.divide(1, 0), "Divide by zero should throw!");
    }

    @Test
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils4.computeCircleArea(10), "Should return right circle area");
    }
}