/*
# Financial Forecasting Using Recursion

## Introduction

Financial forecasting is used to estimate future values based on previous data and growth rates. It helps businesses and investors understand how an investment or financial value may grow over time.

In this project, I used a **recursive approach** to calculate the future value. Recursion makes the solution simple by solving the same problem repeatedly until a base condition is reached.

## Understanding Recursion

Recursion is a programming technique in which a method calls itself to solve a problem.

A recursive method always has:

* A **base case**, which stops the recursion.
* A **recursive case**, where the method calls itself with a smaller problem.

Recursion is useful for problems that can be divided into smaller, similar subproblems.

## Implementation

In this project, a recursive method is created to calculate the future value of an investment.

The method takes:

* Initial Value
* Growth Rate
* Number of Years

Each recursive call calculates the value for one year and continues until all years are completed.

## Time Complexity

The recursive solution performs one recursive call for each year.

* **Time Complexity:** O(n)
* **Space Complexity:** O(n) because each recursive call is stored in the call stack.

## Optimization

Although recursion makes the code simple and easy to understand, it uses additional memory because of recursive function calls.

The solution can be optimized by:

* Using an iterative (loop-based) approach.
* Using Dynamic Programming or Memoization if repeated calculations are involved.
* Avoiding unnecessary recursive calls for large inputs.

*/

public class FinancialForecasting {

    public static double predictValue(double presentValue, double growthRate, int years) {
        
        // Base case
        if (years == 0) {
            return presentValue;
        }

        // Recursive case
        return predictValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue = predictValue(presentValue, growthRate, years);

        System.out.println("Predicted Future Value: " + futureValue);
    }
}