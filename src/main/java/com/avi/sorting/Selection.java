package com.avi.sorting;

public class Selection {

    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before sorting:");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        sort(arr, n);
    }

    static void sort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println("After sorting:");
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

}
