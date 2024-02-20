package com.avi.java8;

@FunctionalInterface
public interface A {
    int x = 20;

    static void fun(int x) {
        System.out.println(x);
    }

    void alpha();

}
