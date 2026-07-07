package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(5,2+3);

        // Assert True
        assertTrue(10>5);

        // Assert False
        assertFalse(10<5);

        // Assert Null
        String name=null;
        assertNull(name);

        // Assert Not Null
        Object obj=new Object();
        assertNotNull(obj);

        // Assert Same
        String s1="Java";
        String s2=s1;
        assertSame(s1,s2);

        // Assert Not Same
        String a=new String("Hello");
        String b=new String("Hello");
        assertNotSame(a,b);

        // Assert Array Equals
        int expected[]= {1,2,3};
        int actual[]= {1,2,3};

        assertArrayEquals(expected,actual);

    }

}