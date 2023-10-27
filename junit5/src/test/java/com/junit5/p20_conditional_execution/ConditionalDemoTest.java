package com.junit5.p20_conditional_execution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalDemoTest {

    @Test
    @EnabledOnOs(OS.MAC)
    void someTestConditionalOnOs_MAC() {
        System.out.println("someTestConditionalOnOs() method");
        System.out.println("WORKS ON MAC OS");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void someTestConditionalOnOs_WINDOWS() {
        System.out.println("someTestConditionalOnOs() method");
        System.out.println("WORKS ON WINDOWS");
    }
}