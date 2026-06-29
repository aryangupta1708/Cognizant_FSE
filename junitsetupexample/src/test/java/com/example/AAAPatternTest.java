/* 
# Arrange-Act-Assert (AAA) Pattern in JUnit

## Introduction

The Arrange-Act-Assert (AAA) pattern is a simple and organized way of writing unit tests in JUnit. It improves the readability of test cases and makes them easier to understand and maintain.
In this exercise, the AAA pattern is used along with **@Before** and **@After** annotations to perform setup and cleanup operations before and after each test.

## Arrange-Act-Assert (AAA) Pattern

### Arrange

In this step, all required objects and input data are created before executing the test.

### Act

The method that needs to be tested is executed.

### Assert

The actual output is compared with the expected output using JUnit assertions.

## Test Fixtures

A test fixture is the common setup required before running test cases.

JUnit provides:

**@Before** → Executes before every test method.
**@After** → Executes after every test method.

These methods help prepare and clean the test environment automatically.

## Advantages

* Makes test cases easy to read.
* Reduces duplicate code.
* Improves code maintenance.
* Provides better organization of test cases.

*/

package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AAAPatternTest {

    private Calculator calculator;

    @Before
    public void setUp() {

        calculator = new Calculator();

        System.out.println("Setup completed.");

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

        calculator = null;

        System.out.println("Teardown completed.");

    }

}
