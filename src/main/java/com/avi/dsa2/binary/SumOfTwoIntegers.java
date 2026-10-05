package com.avi.dsa2.binary;

/**
 * Blind 75 - Binary #1: Sum of Two Integers (no + or -)
 * ------------------------------------------------------------------
 * Problem:
 *   Compute a + b without using the + or - operators.
 *
 * Example:
 *   a = 2, b = 3 -> 5
 *   a = -2, b = 3 -> 1
 *
 * Approach (bit manipulation):
 *   Binary addition splits into two parts:
 *     - XOR (a ^ b) adds the bits while ignoring carries (0+0=0, 1+0=1, 1+1=0).
 *     - AND then left shift ((a & b) << 1) computes exactly where carries go.
 *   Repeat: add the carry into the sum until there is no carry left. This works
 *   for negatives too thanks to two's-complement representation.
 *
 * Complexity:
 *   Time  O(1) - at most 32 iterations for a 32-bit int.
 *   Space O(1).
 */
public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // bits where both are 1 produce a carry
            a = a ^ b;                // add without carrying
            b = carry;                // now fold the carry back in
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(2, 3));   // 5
        System.out.println(getSum(-2, 3));  // 1
        System.out.println(getSum(-5, -7)); // -12
    }
}
