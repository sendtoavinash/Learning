package com.avi.dsa;

public class MinMaxArray {

    public static void main(String[] args) {

        int arr[] = {3, 3, 3, 1, 1, 1};
//        int arr[] = {6, 5, 4, 3, 2, -1};
//        int arr[] = {6, 6, 4, 3, 2, 1};

        int sortedArr[] = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (max < arr[i]) {
                secondMax = max;
                max = arr[i];
            } else if (secondMax < arr[i] && max != arr[i]) {
                secondMax = arr[i];

            } else {
                min = arr[i];
            }
        }

        System.out.println("MAX : " + max);
        System.out.println("SECONDMAX : " + secondMax);
        System.out.println("MIN : " + min);
    }


}
