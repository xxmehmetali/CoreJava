package com.junit5.p26_testinfo_testreporter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class TestInfoTestReporterDemoTest {

    @BeforeEach
    void init() {

    }

    //Injects these abstracts as concretes from it's own context
    @Test
    void test1(TestInfo testInfo) {
        // for logging purpose
        System.out.println(
                "test class : " + testInfo.getTestClass() + "\n" +
                        "display name : " + testInfo.getDisplayName() + "\n" +
                        "tags : " + testInfo.getTags() + "\n" +
                        "test method : " + testInfo.getTestMethod().get().getName()
        );
        //some logic
    }

    @Test
    //Injects these abstracts as concretes from it's own context
    //TestReporter is used for logging purpose, do not use system out println
    void test2(TestInfo testInfo, TestReporter testReporter) {
        //better way of logging
        testReporter.publishEntry("test class", testInfo.getTestClass().toString());
        testReporter.publishEntry("display name", testInfo.getDisplayName());
        testReporter.publishEntry("tags", testInfo.getTags().toString());
        testReporter.publishEntry("test method", testInfo.getTestMethod().get().getName());
    }


}