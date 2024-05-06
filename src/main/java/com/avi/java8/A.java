package com.avi.java8;

@FunctionalInterface
interface A {
    int x = 20;

    void alpha();

    static void fun(int x) {
        System.out.println(x);
    }

}
