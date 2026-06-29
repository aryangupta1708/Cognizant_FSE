/* 

# Assertions in JUnit

## Introduction

JUnit provides different assertion methods that help verify whether the expected output matches the actual output. Assertions are an important part of unit testing because they automatically check if the program is working correctly.
In this exercise, different JUnit assertions are used to test simple conditions such as equality, boolean values, and null objects.

## What are Assertions?

* Assertions are methods provided by JUnit that compare the expected result with the actual result.
* If the condition is true, the test passes.
* If the condition is false, the test fails.

## Assertions Used

### assertEquals()

Checks whether two values are equal.

### assertTrue()

Checks whether a condition is true.

### assertFalse()

Checks whether a condition is false.

### assertNull()

Checks whether an object is null.

### assertNotNull()

Checks whether an object is not null.

## Advantages of Assertions

* Helps detect bugs quickly.
* Improves code quality.
* Makes testing automatic.
* Saves development time.
*/

package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(5, 2 + 3);

        // Assert True
        assertTrue(5 > 3);

        // Assert False
        assertFalse(5 < 3);

        // Assert Null
        assertNull(null);

        // Assert Not Null
        assertNotNull(new Object());

    }
}
