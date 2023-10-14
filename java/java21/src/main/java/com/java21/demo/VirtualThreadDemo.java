package com.java21.demo;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author zhangxq
 * @since 2023/10/14
 */
public class VirtualThreadDemo {
    
    public static void main(String[] args) {
        int n = 10_000;
        runByVirtualThread(n);
    }
    
    public static void linearRun(int n) {
        IntStream.range(0, n).forEach(i -> {
            System.out.println(i);
        });
    }
    
    public static void runByVirtualThread(int n) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, n).forEach(i -> {
                executor.submit(() -> {
                    System.out.println(i);
                    Thread.sleep(Duration.ofSeconds(1));
                    return false;
                });
            });
        }
    }
}
