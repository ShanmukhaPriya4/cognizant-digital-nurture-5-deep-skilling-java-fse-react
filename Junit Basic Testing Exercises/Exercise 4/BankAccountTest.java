package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {

        System.out.println("Before Test");

        account=new BankAccount(1000);

    }

    @After
    public void tearDown() {

        System.out.println("After Test");

        account=null;

    }

    @Test
    public void testDeposit() {

        // Arrange
        double amount=500;

        // Act
        account.deposit(amount);

        // Assert
        assertEquals(1500,account.getBalance(),0.01);

    }

    @Test
    public void testWithdraw() {

        // Arrange
        double amount=300;

        // Act
        account.withdraw(amount);

        // Assert
        assertEquals(700,account.getBalance(),0.01);

    }

}