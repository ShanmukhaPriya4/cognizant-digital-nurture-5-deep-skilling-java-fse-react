package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        int sum = 10 + 20;
        assertEquals(30, sum);
    }
}
