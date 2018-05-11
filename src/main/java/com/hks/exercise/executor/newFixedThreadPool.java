package com.hks.exercise.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool
 * 创建一个固定长度线程池,可控制线程最大并发数,超出的线程会在队列中等待。
 * 缺点：
 *      超过的线程会堆积在队列中,比较耗内存
 */
public class newFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
