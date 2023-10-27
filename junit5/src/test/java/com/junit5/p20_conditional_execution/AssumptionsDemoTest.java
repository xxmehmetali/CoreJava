package com.junit5.p20_conditional_execution;

import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class AssumptionsDemoTest {

    @Test
    void someMethod(){
        // Get this value from some external source
        boolean isServerUp = false;
        // IF IT IS TRUE, THEN EXECUTE THE TEST. OTHERWISE SKIP THIS TEST
        assumeTrue(isServerUp);
        //some code
    }
}