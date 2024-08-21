package com.avi.dsa;

public class ArraySortEven {

    public static void main(String[] args) {
        int[] arr = {1, 3, 45, 2, 67, 10};
        rearrangeArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void rearrangeArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }

            while (left < right && arr[right] % 2 != 0) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

}
