package com.hks.exercise.atomic;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子性类
 */
public class AtomicAndLongAdder {

    public static final int THREAD_COUNT = 1000;
    static ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
    static CompletionService<Long> completionService = new ExecutorCompletionService<Long>(pool);
    static final AtomicLong atomicLong = new AtomicLong(0L);
    static final LongAdder longAdder = new LongAdder();

    /**
     * longAdder的增强版实现Accumulator操作
     */
    static LongAccumulator longAccumulator = new LongAccumulator(Long::max, 0L);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; i++) {
            completionService.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    for (int j = 0; j < 100000; j++) {
                        atomicLong.incrementAndGet();
                        longAdder.increment();
                        longAdder.sum();
                    }
                    return 1L;
                }
            });
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            Future<Long> future = completionService.take();
            future.get();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println("Value：" + atomicLong.longValue());
        pool.shutdown();

        longAccumulator.accumulate(100);

        System.out.println(longAccumulator.get());
    }
}
