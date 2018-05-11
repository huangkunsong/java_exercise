package com.hks.exercise.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newCachedThreadPool
 *  创建一个可缓存线程池,如果线程池长度超过处理需要,
 *  可灵活回收空闲线程,若无可回收,则新建线程。
 * 缺点：
 *      内部使用Integer.MAX_VALUE来指定创建的线程数量,会创建很多线程
 */
public class newCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10004; i++) {
            System.out.println(i);
            newCachedThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        System.exit(0);
    }
}
