package com.avi.java8;

@FunctionalInterface
interface C extends A {
    @Override
    default void alpha() {

    }

    void beta();
}
