package com.avi.dsa;

import java.util.Arrays;

public class ArrayRotate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 2;

        rotateRight(arr, k);
//        rotateLeft(arr, k);
//        rotate(arr, k);
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

        Arrays.stream(temp).forEach(System.out::print);
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

        Arrays.stream(temp).forEach(System.out::print);
    }

    public static void rotate(int[] arr, int k) {
        int l = arr.length;
        k %= l;
        reverse(arr, 0, l - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, l - 1);

        Arrays.stream(arr).forEach(System.out::print);
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

}
