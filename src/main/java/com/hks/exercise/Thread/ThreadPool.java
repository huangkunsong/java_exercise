package com.hks.exercise.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池优点：
 *     减少线程的创建和销毁。
 *     避免创建过多线程占据内存。
 *     可以对线程进行统一管理
 *     可以进行线程延迟、定期执行。
 * 新建线程池时,不会建线程,提交线程时才会创建。
 * 空闲时,默认：回收>corePoolSize的线程。
 * 参数：
 * corePoolSize：
 *      核心线程数,线程池中默认一致保持运行的线程。
 *      allowCoreThreadTimeOut(true)可以设置核心线程关闭。
 * maximumPoolSize:
 *      最大线程数。
 * keepAliveTime：
 *      非核心线程空闲回收时间,
 *      allowCoreThreadTimeOut=true时也作用于核心线程池
 * TimeUnit：
 *      keepAliveTime单位
 * BlockingQueue：
 *      任务队列,当所有的核心线程都在干活时,
 *      新添加的任务会被添加到这个队列中等待处理,
 *      如果队列满了，则新建非核心线程执行任务。
 *      SynchronousQueue：
 *          这个队列接收到任务的时候，会直接提交给线程处理，
 *          那就新建一个线程来处理这个任务！
 *          为了保证不出现线程数达到了maximumPoolSize而不能新建线程的错误，
 *          使用这个类型队列的时候，maximumPoolSize一般指定成Integer.MAX_VALUE，
 *          即无限大。
 *      LinkedBlockingQueue：
 *          这个队列接收到任务的时候,如果当前线程数小于核心线程数,
 *          则新建线程(核心线程)处理任务；如果当前线程数等于核心线程数,
 *          则进入队列等待。由于这个队列没有最大值限制,
 *          即所有超过核心线程数的任务都将被添加到队列中,
 *          这也就导致了maximumPoolSize的设定失效,
 *          因为总线程数永远不会超过corePoolSize
 *      ArrayBlockingQueue：
 *          可以限定队列的长度,接收到任务的时候,
 *          如果没有达到corePoolSize的值,则新建线程(核心线程)执行任务,
 *          如果达到了,则入队等候,如果队列已满,
 *          则新建线程(非核心线程)执行任务,
 *          又如果总线程数到了maximumPoolSize,并且队列也满了
 *          则发生错误
 *      DelayQueue：
 *          队列内元素必须实现Delayed接口,这就意味着你传进去的任务必须先实现Delayed接口。
 *          这个队列接收到任务时,首先先入队,
 *          只有达到了指定的延时时间,才会执行任务
 *  ThreadFactory:
 *      实现newThread方法,指定创建线程的方式
 *  RejectedExecutionHandler ：
 *      异常处理。有默认,一般不传。
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadFactory threadFactory =
            new ThreadFactoryBuilder().setNameFormat("thread-test-%d")
                .build();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
            5, 200,
            0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),
            threadFactory);

        /**
         * 设置核心线程会过期
         */
        pool.allowCoreThreadTimeOut(true);

        /**
         * 提交一个无返回值的线程。
         */
        pool.execute(() -> System.out.println(Thread.currentThread().getName()));

        /**
         * 提交一个有返回值的线程。
         */
        Future<String> future = pool.submit(() -> "returnValue");

        /**
         * 不允许在添加线程,且线程池中的所有任务结束后,关闭线程池。
         */
        pool.shutdown();

        /**
         * 立即初始化所有核心线程。
         */
        pool.prestartAllCoreThreads();

        /**
         * 打断线程,立即关闭线程池。返回所有未执行线程。
         */
        pool.shutdownNow();
        try {
            //以阻塞的方式等待线程池关闭,之前要先调用shutdown,不然会造成死锁。
            pool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScheduledThreadPoolExecutor scheduledThreadPool =
            new ScheduledThreadPoolExecutor(5,threadFactory);

        /**
         * 只执行一次,延迟5S执行,可以有或者无返回值
         */
        scheduledThreadPool.schedule(
            () -> System.out.println(Thread.currentThread().getName()),
            5,TimeUnit.MILLISECONDS);

        ScheduledFuture future1 =
            scheduledThreadPool.schedule(() -> "aaa",
                5,TimeUnit.MILLISECONDS);

        /**
         * 延迟5s,加上一次执行开始时间+10S固定频率执行任务
         */
        scheduledThreadPool.scheduleAtFixedRate(
            () -> System.out.println(Thread.currentThread().getName()),
            5,10,TimeUnit.MILLISECONDS);

        /**
         * 延迟5s,加上一次执行结束时间+10S固定频率执行任务
         */
        scheduledThreadPool.scheduleWithFixedDelay(
            () -> System.out.println(Thread.currentThread().getName()),
            5,10,TimeUnit.MILLISECONDS);



        //Executor自带几种种创建线程池方式

        /**
         * 创建一个线程数无限制的线程池。
         * maximumPoolSize：{@link Integer.MAX_VALUE}
         * BlockingQueue：SynchronousQueue
         */
        ThreadPoolExecutor cachePool = (ThreadPoolExecutor)
            Executors.newCachedThreadPool();

        /**
         * 创建只有核心线程在跑的无限队列线程池,maximumPoolSize无效
         * BlockingQueue：LinkedBlockingQueue
         * 参数为核心线程数。
         */
        ThreadPoolExecutor fixedThread = (ThreadPoolExecutor)
            Executors.newFixedThreadPool(10);


        /**
         * 创建一个单线程无限队列的线程池
         * corePoolSize：1
         * maximumPoolSize：1
         * BlockingQueue：LinkedBlockingQueue
         */
        Executors.newSingleThreadExecutor();
        /**
         * 和自创建一个定时线程池一致
         */
        ScheduledThreadPoolExecutor scheduledThreadPool1 = (ScheduledThreadPoolExecutor)
            Executors.newScheduledThreadPool(10);

        /**
         * 结合以上2种
         */
        Executors.newSingleThreadScheduledExecutor();
    }
}
