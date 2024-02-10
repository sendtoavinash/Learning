package com.avi;

class Hi extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi from "+ currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

    }
}

class Hello extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from "+ currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

    }
}

public class ThreadDemo {

    public static void main(String[] args) {

        Hi hiObj = new Hi();
        Hello helloObj = new Hello();

        hiObj.start();
        helloObj.start();

    }
}
