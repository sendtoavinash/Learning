package com.avi.java8;

@FunctionalInterface
interface A {
    int x = 20;

    void alpha();

    default void beta() {
        System.out.println("Inside default " + x);
    }

    static void fun(int x) {
        System.out.println("Inside static " + x);
    }

}
