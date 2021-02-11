package com.assignment.JUnitYearCheck;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class JUnitYearCheckApplicationTests {
	JUnitYearCheckApplication object;
	@BeforeAll
    public static void beforeAllTest() {
        System.out.println("Welcome");
        // set something for an object
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Before Each test");
        this.object = new JUnitYearCheckApplication();
    }
    
    // Year cannot be 0
    @Test
    public void test1() {
        boolean res = object.checkLeapYear(0);
        assertEquals(false, res);
    }
    
    @Test
    public void test2() {
        boolean res = object.checkLeapYear(1);
        assertEquals(false, res);
    }
    
    @Test
    public void test3() {
        boolean res = object.checkLeapYear(4);
        assertEquals(true, res);
    }
    
    @Test
    public void test4() {
        boolean res = object.checkLeapYear(40);
        assertEquals(true, res);
    }
    
    @Test
    public void test5() {
        boolean res = object.checkLeapYear(400);
        assertEquals(true, res);
    }
    
    // Year cannot be negative
    @Test
    public void test6() {
        boolean res = object.checkLeapYear(-400);
        assertEquals(false, res);
    }
    
    // Century Year not leap year
    @Test
    public void test7() {
        boolean res = object.checkLeapYear(1900);
        assertEquals(false, res);
    }
    
    // Century Year but leap year
    // because year is divisible by 400.
    @Test
    public void test8() {
        boolean res = object.checkLeapYear(2000);
        assertEquals(true, res);
    }
    
    @Test
    public void test9() {
        boolean res = object.checkLeapYear(2020);
        assertEquals(true, res);
    }
    
    @Test
    public void test10() {
        boolean res = object.checkLeapYear(1914);
        assertEquals(false, res);
    }
    
    @Test
    public void test11() {
        boolean res = object.checkLeapYear(2004);
        assertEquals(true, res);
    }
	
    @AfterEach
    public void afterEachTest() {
        System.out.println("After Each test");
        this.object = null;
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("Thanks");
    }

}
//1899, 1900, 1901, 1902, 1903, 1904, 1905, 1999, 2000, 2001, 2002, 2003, 2004