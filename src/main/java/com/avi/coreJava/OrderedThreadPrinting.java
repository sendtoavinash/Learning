package com.avi.coreJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderedThreadPrinting {
    public static void main(String[] args) {
        final int THREAD_COUNT = 4;
        final int MAX_NUMBER = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        AtomicInteger currentNumber = new AtomicInteger(1);

        for (int i = 1; i <= THREAD_COUNT; i++) {
            int threadId = i;
            executorService.submit(() -> {
                while (true) {
                    synchronized (currentNumber) {
                        if (currentNumber.get() > MAX_NUMBER) {
                            break;
                        }
                        if (currentNumber.get() % THREAD_COUNT == threadId % THREAD_COUNT) {
                            System.out.println("Thread " + threadId + ": " + currentNumber.getAndIncrement());
                            currentNumber.notifyAll();
                        } else {
                            try {
                                currentNumber.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
