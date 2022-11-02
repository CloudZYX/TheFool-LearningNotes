package com.zyx.arithmetic.recursion;

/**
 * 阶乘
 */
public class Num01_Factorial {
    public static int factorial(int n) {
        return n == 1 ? n : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n1 = 5;
        System.out.printf("n = %d, f(n) = %d", n1, factorial(n1));
    }
}
