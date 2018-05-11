package com.hks.exercise.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序
 * 缺点：
 *      超过的线程会堆积在队列中,比较耗内存
 */
public class newSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 4; i++) {
            newSingleThreadExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
    }
}
