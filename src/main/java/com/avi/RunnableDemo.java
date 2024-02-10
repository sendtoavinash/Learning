package com.avi;

import static java.lang.Thread.currentThread;

public class RunnableDemo {

    public static void main(String[] args) {

        Runnable hiObj = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi from " + currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        };
        Runnable helloObj = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello from " + currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }

        };

        Thread t1 = new Thread(hiObj);
        Thread t2 = new Thread(helloObj);

        t1.start();
        t2.start();

    }
}

