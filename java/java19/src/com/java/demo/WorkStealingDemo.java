package com.java.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangxq
 * @since 2023/4/12
 */
public class WorkStealingDemo {
    
    public static void main(String[] args) {
        // 并行线程数
        int parallelism = 5;
        try (ExecutorService executorService = Executors.newWorkStealingPool(parallelism)) {
            Task task = new Task(10L);
            for (int i = 0; i < 10; i++) {
                executorService.submit(task);
            }
        }
        catch (Exception e) {
        }
    }
    
    static class Task implements Runnable {
        
        private Long local;
        
        public Task(Long local) {
            this.local = local;
        }
        
        @Override
        public void run() {
            System.out.println("start " + local + " " + Thread.currentThread());
            
            System.out.println("end " + local + " " + Thread.currentThread());
        }
    }
}
