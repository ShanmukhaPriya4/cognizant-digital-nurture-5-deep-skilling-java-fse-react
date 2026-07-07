package com.example;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)

public class OrderedTests {

    @Test
    @Order(1)
    void login() {

        System.out.println("Login");

    }

    @Test
    @Order(2)
    void searchProduct() {

        System.out.println("Search Product");

    }

    @Test
    @Order(3)
    void addToCart() {

        System.out.println("Add To Cart");

    }

    @Test
    @Order(4)
    void payment() {

        System.out.println("Payment");

    }

}
