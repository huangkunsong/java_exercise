package com.hks.exercise.executor;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用Commons.lang来构建
 */
public class AScheduledThreadPoolExecutor {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5,
            new BasicThreadFactory.Builder().namingPattern("thread-test-%d").daemon(false).build());
        pool.schedule(
            () -> System.out.println(Thread.currentThread().getName()),
            1000,
            TimeUnit.MILLISECONDS);
    }
}
