package com.avi.dsa;

public class PlaceFlower {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 2;

        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftBed = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightBed = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if (leftBed && rightBed) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }
}
