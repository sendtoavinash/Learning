package com.avi.dsa;

public class Fibonacci {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.print(fib(i)+" ");
        }

//        System.out.println(Arrays.toString(generateFibonacciNumbers(5)));
    }

    /////// Recursion
    public static int fib(int n) {
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }


    public static int[] generateFibonacciNumbers(int n) {
        int[] f = new int[n];
        f[0] = 0;
        if (n <= 1) return f;
        f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
