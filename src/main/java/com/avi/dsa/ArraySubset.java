package com.avi.dsa;

import java.util.Arrays;

public class ArraySubset {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 5};

        System.out.println(isSubset(arr1, arr2)); // true
    }

    public static boolean isSubset(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return j == arr2.length;
    }

//    static boolean a(int[] arr1, int[] arr2) {
//        int count = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr2.length; j++) {
//                if (arr1[i] == arr2[j]) {
//                    count++;
//                }
//            }
//        }
//        if (count == arr2.length) {
//            return true;
//        }
//        return false;
//    }

}
