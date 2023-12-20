package com.avi;

public class ArrayRotate {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        int k = 2;

//        rotateRight(arr, k);
        rotateLeft(arr, k);
    }

    public static void rotateRight(Integer[] arr, int k) {

        int length = arr.length;
        Integer[] temp = new Integer[length];
        int j = 0;

        for (int i = k; i < length; i++) {
            temp[j] = arr[i];
            j++;
        }
        for (int i = 0; i < k; i++) {
            temp[j] = arr[i];
            j++;
        }
        System.arraycopy(temp, 0, arr, 0, length);

        printTheArray(arr);
    }

    public static void rotateLeft(Integer[] arr, int k) {

        int length = arr.length;
        Integer[] temp = new Integer[length];
        int j = 0;

        for (int i = length-k; i < length; i++) {
            temp[j] = arr[i];
            j++;
        }
        for (int i = 0; i < length-k; i++) {
            temp[j] = arr[i];
            j++;
        }
        System.arraycopy(temp, 0, arr, 0, length);

        printTheArray(arr);
    }

    static void printTheArray(Integer[] arr) {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
