package com.avi.dsa;

import java.util.Arrays;

public class FirstLastPositionArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        Arrays.stream(searchRange(nums, target)).forEach(System.out::println);
    }

    public static int[] searchRange(int[] nums, int target) {
        int f = -1;
        int l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            } else {
                if (f == -1)
                    f = i;
                l = i;
            }
        }
        return new int[]{f, l};
    }
}
