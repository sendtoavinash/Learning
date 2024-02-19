package com.avi.dsa;

import java.util.Arrays;

public class StudentMarks {

    public static void main(String[] args) {
        int[][] marks = {{75, 76, 65, 87, 87}, {78, 76, 68, 56, 89}, {67, 87, 78, 77, 65}};
        System.out.println(Arrays.toString(sortStudentMarks(3, 5, marks)));
    }

    public static int[] sortStudentMarks(int n, int m, int[][] marks) {

        int[] avgMarks = new int[m];
        int[] avgMarksSorted = new int[n];

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                avgMarks[j] += marks[i][j];
                if (i == n - 1 && avgMarks[j] < min) {
                    min = avgMarks[j];
                    minIndex = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j != minIndex) {
                    avgMarksSorted[i] += marks[i][j];
                }
            }
        }
        return avgMarksSorted;
    }
}
