package com.avi.dsa2.binary;

/**
 * Blind 75 - Binary #2: Number of 1 Bits (Hamming Weight)
 * ------------------------------------------------------------------
 * Problem:
 *   Return the number of set bits (1s) in the binary representation of n.
 *
 * Example:
 *   n = 0b1011 (11) -> 3
 *   n = 0b10000000000000000000000000000000 -> 1
 *
 * Approach (Brian Kernighan's trick):
 *   The expression n & (n - 1) clears the LOWEST set bit of n. Each time we do
 *   it we remove exactly one 1-bit, so the number of iterations until n becomes
 *   0 equals the number of set bits. This is faster than checking all 32 bits
 *   because it loops only once per set bit.
 *
 * Complexity:
 *   Time  O(number of set bits), Space O(1).
 */
public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // drop the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));          // 3  (1011)
        System.out.println(hammingWeight(128));         // 1  (10000000)
        System.out.println(hammingWeight(-1));          // 32 (all bits set)
    }
}
