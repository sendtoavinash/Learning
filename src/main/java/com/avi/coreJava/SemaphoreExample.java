package com.avi.coreJava;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // Two permits

        for (int i = 0; i < 5; i++) {
            new Thread(new Work(semaphore)).start();
        }
    }
}

class Work implements Runnable {
    private final Semaphore semaphore;

    Work(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for a permit.");
            semaphore.acquire(); // Acquire a permit
            System.out.println(Thread.currentThread().getName() + " has acquired a permit.");
            Thread.sleep(2000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " is releasing a permit.");
            semaphore.release(); // Release the permit
        }
    }
}

