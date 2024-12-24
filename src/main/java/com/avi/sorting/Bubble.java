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
//        sort(arr,n);
        recursiveBubbleSort(arr, n);
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

    static void recursiveBubbleSort(int[] arr, int n) {
        if (n <= 1) {
            System.out.println("After sorting:");
            for (int a : arr) {
                System.out.print(a + " ");
            }
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        recursiveBubbleSort(arr, n - 1);
    }

}
