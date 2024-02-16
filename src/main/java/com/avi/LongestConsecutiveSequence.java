package com.avi;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {6, 7, 9,10,8, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int count = 0;
        int out = 0;
        int[] temp = Arrays.stream(nums).distinct().sorted().toArray();
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] + 1 == temp[i + 1]) {
                count++;
            } else {
                if (out < count) {
                    out = count;
                }
                count = 0;
            }
        }
        if (out < count) {
            out = count;
        }
        return out + 1;
    }
}
