package com.avi.dsa;

public class ArrayRotate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 2;

//        rotateRight(arr, k);
//        rotateLeft(arr, k);
        rotate(arr, k);
    }

    public static void rotateRight(int[] arr, int k) {

        int l = arr.length;
        int[] temp = new int[l];
        int j = 0;
        k = k % l;

        for (int i = k; i < l; i++) {
            temp[j] = arr[i];
            j++;
        }
        for (int i = 0; i < k; i++) {
            temp[j] = arr[i];
            j++;
        }
        System.arraycopy(temp, 0, arr, 0, l);

        printTheArray(arr);
    }

    public static void rotateLeft(int[] arr, int k) {

        int l = arr.length;
        int[] temp = new int[l];
        int j = 0;
        k = k % l;

        for (int i = l - k; i < l; i++) {
            temp[j] = arr[i];
            j++;
        }
        for (int i = 0; i < l - k; i++) {
            temp[j] = arr[i];
            j++;
        }
        System.arraycopy(temp, 0, arr, 0, l);

        printTheArray(arr);
    }

    public static void rotate(int[] nums, int k) {

        int l = nums.length;
        k %= l;
        reverse(nums, 0, l - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, l - 1);

        printTheArray(nums);
    }

    public static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    static void printTheArray(int[] arr) {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
