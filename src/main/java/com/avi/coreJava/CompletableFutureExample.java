package com.avi.coreJava;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 123;
        });

        // Attach a callback to the future
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });

        // Do some other tasks if needed
        System.out.println("Doing other tasks...");

        try {
            // Wait for the future to complete
            future.get(); // This will block until the result is available
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

