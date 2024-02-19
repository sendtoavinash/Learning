package com.avi.dsa;

import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(duplicate(arr));
    }

    public static boolean duplicate(int[] nums) {

        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.contains(num))
                return true;
            unique.add(num);
        }
        return false;
    }
}


