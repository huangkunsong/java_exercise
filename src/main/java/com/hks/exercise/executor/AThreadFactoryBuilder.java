package com.hks.exercise.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class AThreadFactoryBuilder {
    public static void main(String[] args) {
        ThreadFactory threadFactory =
            new ThreadFactoryBuilder().setNameFormat("thread-test-%d")
            .build();
        ExecutorService pool = new ThreadPoolExecutor(
            5, 200,
            0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),
            threadFactory,
            new ThreadPoolExecutor.AbortPolicy());

        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();
    }
}
