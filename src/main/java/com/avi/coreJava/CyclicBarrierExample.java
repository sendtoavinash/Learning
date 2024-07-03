package com.avi.coreJava;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, new BarrierAction());

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Employee(barrier)).start();
        }
    }
}

class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("All threads have reached the barrier. Barrier action executed.");
    }
}

class Employee implements Runnable {
    private final CyclicBarrier barrier;

    Employee(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working.");
        try {
            Thread.sleep(1000); // Simulate work
            System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
            barrier.await(); // Wait for other threads to reach the barrier
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has crossed the barrier.");
    }
}

