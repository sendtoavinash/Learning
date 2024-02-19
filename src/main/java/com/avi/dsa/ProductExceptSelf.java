package com.avi.dsa;

public class ProductExceptSelf {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {-1, 1, 0, -3, 3};
        int[] output = productExceptSelf(nums);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }

    }

   /* public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j)
                    prod *= nums[j];
            }
            result[i] = prod;
        }
        return result;
    }*/

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prod = 1;
        int zeroIndex = 0;
        boolean containsZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                containsZero = true;
            }
        }
        if (containsZero) {
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex) {
                    prod *= nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex) {
                    result[i] = 0;
                }
                result[zeroIndex] = prod;
            }
            return result;
        }


        for (int x : nums) {
            prod *= x;
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prod / nums[i];
        }
        return result;
    }
}
