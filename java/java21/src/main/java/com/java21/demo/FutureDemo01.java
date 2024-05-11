package com.java21.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author will
 * @since 2024/5/11
 */
public class FutureDemo01 {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        var t1 = new FutureTask<>(new BumThread());
        new Thread(t1).start();
        var t2 = new FutureTask<>(new ColdDishThread());
        new Thread(t2).start();
        System.out.println(t1.get());
        System.out.println(t2.get());
        
        long end = System.currentTimeMillis();
        System.out.println("准备完毕！" + (start - end));
    }
    
    static class BumThread implements Callable<Object> {
        @Override
        public Object call() throws Exception {
            Thread.sleep(3000);
            return null;
        }
    }
    
    static class ColdDishThread implements Callable<Object> {
        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            return null;
        }
    }
}
