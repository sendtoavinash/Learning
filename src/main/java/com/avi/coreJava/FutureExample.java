package com.avi.coreJava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 123;
        };

        Future<Integer> future = executor.submit(task);

        try {
            // Do some other tasks if needed
            System.out.println("Doing other tasks...");

            // Get the result of the future task
            Integer result = future.get(); // This will block until the result is available
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}


