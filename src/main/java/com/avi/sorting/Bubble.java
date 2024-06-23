package com.avi.sorting;

public class Bubble {

    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        sort(arr, n);
    }

    static void sort(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("After sorting:");
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

}
