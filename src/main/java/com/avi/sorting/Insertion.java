package com.avi.sorting;

public class Insertion {

    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before sorting:");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
//        sort(arr,n);
        recursiveInsertionSort(arr,n);
    }

    static void sort(int[] arr,int n) {
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println("After sorting:");
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    static void recursiveInsertionSort(int[] arr, int n){
        if (n <= 1) {
            System.out.println("After sorting:");
            for (int a : arr) {
                System.out.print(a + " ");
            }
            return;
        }
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;

        recursiveInsertionSort(arr, n - 1);

    }
}
