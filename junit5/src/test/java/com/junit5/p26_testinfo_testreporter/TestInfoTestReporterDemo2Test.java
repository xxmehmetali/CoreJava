package com.junit5.p26_testinfo_testreporter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.*;

class TestInfoTestReporterDemo2Test {

    private TestReporter testReporter;
    private TestInfo testInfo;

    @BeforeEach
    // injecting
    void init(TestReporter testReporter, TestInfo testInfo){
        this.testReporter = testReporter;
        this.testInfo = testInfo;
    }


    // better way of doing injection is to use @BeforeEach not repeating the same code
    // it would be unnecessary to repeat injection in each method, instead inject it to the class
    @Test
    void test() {
        //better way of logging
        testReporter.publishEntry("test class", testInfo.getTestClass().toString());
        testReporter.publishEntry("display name", testInfo.getDisplayName());
        testReporter.publishEntry("tags", testInfo.getTags().toString());
        testReporter.publishEntry("test method", testInfo.getTestMethod().get().getName());
    }

}