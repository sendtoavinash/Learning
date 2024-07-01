package com.avi.dsa;

public class SortArrayEven {

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
            // Move left pointer to the right while it points to even numbers
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }

            // Move right pointer to the left while it points to odd numbers
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }

            // Swap the elements at left and right pointers
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
