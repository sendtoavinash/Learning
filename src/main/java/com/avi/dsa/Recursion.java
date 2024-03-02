package com.avi.dsa;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(factorial(5));
//        func(1, 5);
    }

    static int factorial(int n) {
        if (n <= 1) return n;
        return n * factorial(n - 1);
    }

    /////// Print a list N times
//    public static List<String> printNtimes(int n) {
//        List<String> list = new ArrayList<>();
//        addElement(list, n);
//        return list;
//    }
//
//    public static void addElement(List<String> list, int n) {
//        if (list.size() == n) {
//            return;
//        }
//        list.add("Coding Ninjas");
//        addElement(list, n);
//    }

    /////// Print 1 to N  Backtracking
//    static void func(int i, int n) {
//        if (i > n) return;
//        System.out.println(i);
//        func(i + 1, n);
//    }

    /////// Print N to 1 Backtracking
//    static void func(int i, int n){
//        if(i<1) return;
//        System.out.println(i);
//        func(i-1,n);
//    }

//    public static int[] printNos(int x) {
//        int [] arr = new int[x];
//        recFunc(arr,x);
//        return arr;
//    }
//
//    static void recFunc(int[] arr,int x){
//        if(x<=0){
//            return;
//        }
//        arr[arr.length-x]=x;
//        recFunc(arr, x-1);
//    }


}
