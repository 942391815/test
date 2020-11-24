package com.test.java.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Micheal on 2020/11/21.
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println(" this is a task! ");
                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        voidCompletableFuture.get();

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "test result";
        }).thenApply(result -> {
            return "result " + result;
        });
        System.out.println(completableFuture.get());
    }
}
