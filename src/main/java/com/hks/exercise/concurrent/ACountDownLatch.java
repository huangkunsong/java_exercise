package com.hks.exercise.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CountDownLatch使一个线程等待其他线程完成各自的工作后再执行
 * 通过一个计数器来实现的,计数器的初始值为线程的数量。
 * 每当一个线程完成了自己的任务后,计数器的值就会减1。
 * 当计数器值到达0时,它表示所有的线程已经完成了任务,
 * 然后在闭锁上等待的线程就可以恢复执行任务。
 * 构造器中的计数值（count）实际上就是闭锁需要等待的线程数量,
 * 要等待执行3次count.countDown();
 */
public class ACountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);

        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
            } finally {
                count.countDown();
            }
        });
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            count.countDown();
        });

        executor.execute(() -> {
            System.out.println("AAA" + Thread.currentThread().getName());
            count.countDown();
        });

        count.await();

        System.out.println("主线程执行");
    }
}
