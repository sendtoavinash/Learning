package com.avi.java8;

public class B extends E implements A {

    @Override
    public void alpha() {
        System.out.println("Inside class B");
    }

    @Override
    void abc() {
        System.out.println("Inside class E Abstract method ");
    }

    public static void main(String[] args) {
        E b = new B();
        b.abc();
    }


}
