package com.hks.exercise.executor;

import java.util.concurrent.*;

/**
 * newScheduledThreadPool
 * 创建一个空闲长度(该长度为初始化长度)线程池,支持定时及周期性任务执行。
 * 缺点：
 *      内部使用Integer.MAX_VALUE来指定创建的线程数量,会创建很多线程
 */
public class newScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() -> System.out.println("延迟3秒执行。"), 3, TimeUnit.SECONDS);
        ScheduledFuture<String> future = executor.schedule(()-> {
            return "延迟3S执行,有返回值";
        },3, TimeUnit.SECONDS);
        String result = future.get();
        System.out.println(result);
        executor.scheduleAtFixedRate(() -> System.out.println("延迟1秒后,每5S执行一次。"), 3, 3, TimeUnit.SECONDS);

    }
}
