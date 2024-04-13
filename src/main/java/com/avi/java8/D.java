package com.avi.java8;

public class D {
    public void test() {
        B y = new B();
        System.out.println(y.x);
//        y.fun(10);               //Important point
        A.fun(10);
    }
}
