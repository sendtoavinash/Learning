package com.avi.dsa2.binary;

/**
 * Blind 75 - Binary #5: Reverse Bits
 * ------------------------------------------------------------------
 * Problem:
 *   Reverse the 32 bits of an unsigned integer (bit 0 swaps with bit 31,
 *   bit 1 with bit 30, and so on).
 *
 * Example:
 *   00000010100101000001111010011100
 *   -> 00111001011110000010100101000000
 *
 * Approach (shift and OR):
 *   Build the result bit by bit. For each of the 32 positions:
 *     - Shift result left by 1 to make room for the next bit.
 *     - Take the current lowest bit of n (n & 1) and OR it into result.
 *     - Shift n right by 1 to expose the next bit.
 *   The first bit we read (lowest of n) ends up pushed all the way to the top,
 *   which is exactly the reversal we want.
 *
 * Complexity:
 *   Time  O(1) - always 32 iterations, Space O(1).
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // make space for the next bit
            result |= (n & 1);     // append n's current lowest bit
            n >>= 1;               // move to n's next bit
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 43261596; // 00000010100101000001111010011100
        int reversed = reverseBits(input);
        System.out.println(reversed);                               // 964176192
        System.out.println(Integer.toBinaryString(reversed));       // 111001011110000010100101000000
    }
}
