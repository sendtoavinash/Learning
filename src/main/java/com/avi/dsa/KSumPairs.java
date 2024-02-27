package com.avi.dsa;

import java.util.HashMap;
import java.util.Map;

public class KSumPairs {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    static int maxOperations(int[] nums, int k) {
        int count = 0;
        int[] containSum = findTwoSum(nums, k);
        if (containSum.length > 0) {
            count++;
            int[] newArray = new int[nums.length - 1];
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i == containSum[0]) {
                    continue;
                }
                newArray[j++] = nums[i];
            }
            count +=  maxOperations(newArray, k);
        }
        return count;
    }

    static int[] findTwoSum(int[] arr, int sum) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if (numMap.containsKey(temp)) {
                return new int[]{numMap.get(temp), i};
            } else {
                numMap.put(arr[i], i);
            }
        }
        return new int[]{};
    }
}
