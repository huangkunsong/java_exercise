package com.hks.exercise.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Semaphore：信号量
 * 信号量可以维护整体的准入许可。
 * 这在一些不同场景下，例如你需要限制你程序某个部分的并发访问总数时非常实用。
 */
public class ASemaphore {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        /**
         * 信号量为5
         */
        Semaphore semaphore = new Semaphore(5);

        IntStream.range(1, 10)
            .forEach((i) -> executor.submit(() -> {
                boolean permit = false;
                try {
                    /**
                     * 等待1S获取锁
                     */
                    permit = semaphore.
                        tryAcquire(1, TimeUnit.SECONDS);

                    // 一次获取10个量
                    semaphore.tryAcquire(10, 1, TimeUnit.SECONDS);
                    if (permit) {
                        System.out.println("获得线程执行许可。");
                        Thread.sleep(5000);
                    } else {
                        System.out.println("无法获得线程执行许可。");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (permit) {
                        //释放锁
                        semaphore.release();

                        semaphore.release(10);
                    }
                }
            }));

    }
}
