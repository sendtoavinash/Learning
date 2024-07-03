package com.avi.coreJava;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Worker(latch)).start();
        }

        try {
            latch.await(); // Wait until the latch counts down to zero
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All workers are done.");
    }
}

class Worker implements Runnable {
    private final CountDownLatch latch;

    Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working.");
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown(); // Decrement the latch count
        System.out.println(Thread.currentThread().getName() + " has finished.");
    }
}
