package com.avi.java8;

@FunctionalInterface
public interface C extends A {
    @Override
    default void alpha() {

    }

    void beta();
}
