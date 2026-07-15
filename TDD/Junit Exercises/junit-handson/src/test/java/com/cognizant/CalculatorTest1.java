package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest1 {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setup: Creating Calculator object");
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @After
    public void tearDown() {
        System.out.println("Teardown: Cleaning up");
        calculator = null;
    }
}
