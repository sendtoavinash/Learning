package com.avi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

    static void hasPair(int arr[], int sum) {

        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];
            if (s.contains(temp)) {
                System.out.println("yes");
                return;
            }
            s.add(arr[i]);
        }
        System.out.println("No");
    }

    static int[] findTwoSum(int[] nums, int sum) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = sum - nums[i];
            if (numMap.containsKey(temp)) {
                return new int[]{numMap.get(temp), i};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int Arr[] = {1, 4, 45, 6, 10, 8};
        int sum = 16;
        hasPair(Arr, sum);
        int[] index = findTwoSum(Arr, sum);
        System.out.print("Index ");
        Arrays.stream(index).forEach(e -> System.out.print(e + " "));
//        Arrays.stream(index).forEach(System.out::println);

    }
}
