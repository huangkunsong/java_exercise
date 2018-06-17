package com.hks.exercise.executor;

import java.util.concurrent.*;

/**
 * 线程状态：
 * 新建：new一个线程
 * 就绪：调用了start方法
 * 运行中：获得CPU执行进入执行run方法
 * 阻塞：
 *  ①线程通过调用sleep方法进入睡眠状态；
 *  ②线程调用一个在I/O上被阻塞的操作，即该操作在输入输出操作完成之前不会返回到它的调用者；
 *  ③线程试图得到一个锁，而该锁正被其他线程持有；
 *  ④线程在等待某个触发条件；
 * 死亡
 *  ①run方法正常退出而自然死亡；
 *  ②一个未捕获的异常终止了run方法而使线程猝死；
 * 启动线程：
 *      调用线程对象的start()方法。
 *      一个对象只可以调用一次,多次调用抛出：java.lang.IllegalThreadStateException
 *      不使用start()方法启动线程,直接使用run方法为当前线程执行方法。
 */
public class ThreadInfo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 几种线程执行的方式。
         */
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        thread1.start();
        new Thread(thread2).start();
        FutureTask task = new FutureTask(thread3);
        new Thread(task).start();
        System.out.println(task.get());


        /**
         * 线程池执行
         */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executor.execute(new Thread1());
        Future<String> future = executor.submit(new Thread3());
        System.out.println(future.get());

        /**
         * 线程类主要方法说明
         */

        /**
         * 线程是否正在执行
         */
        Boolean flag = thread1.isAlive();
        /**
         * 交出CPU执行权,暂停当前线程的执行,
         * 让thread1线程先执行完毕后再到当前线程继续执行
         */
        thread1.join();

        /**
         * 当前线程休眠1S,线程进入阻塞状态,不会释放对象锁。
         */
        Thread.sleep(1000);

        /**
         * Object的方法,thread1线程进入阻塞状态,会释放对象锁
         */
        thread1.wait(1000);

        /**
         * 唤醒在此对象监视器上等待的单个线程。
         * 如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，
         * 并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，
         * 在对象的监视器上等待。
         */
        thread1.notify();

        /**
         * 唤醒在此对象监视器上等待的所有线程。
         * 线程通过调用其中一个 wait 方法，在对象的监视器上等待。
         */
        thread1.notifyAll();

        /**
         * 中断thread1线程,该方法只可以中断阻塞状态的线程
         */
        thread1.interrupt();

        /**
         * java中线程分为两种类型：
         *  用户线程（默认）：主线程结束后用户线程还会继续运行,JVM存活；
         *  守护线程：守护线程就是运行在程序后台的线程,
         *      但所有用户线程执行完后JVM会关闭,但守护线程可以继续执行
         * 设置thread1为守护线程,该方法要在start之前使用才有效
         */
        thread1.setDaemon(true);

        /**
         * 设置线程的优先级,默认5
         */
        thread1.setPriority(Thread.MIN_PRIORITY);

        /**
         * 交出当前CPU执行权,让同一优先级的线程执行
         * 线程回到就绪状态,不存在中断异常
         */
        Thread.yield();
        /**
         * 该方法已废弃
         * 因为它在终止一个线程时会强制中断线程的执行，
         * 不管run方法是否执行完了，并且还会释放这个线程所持有的所有的锁对象。
         * 这一现象会被其它因为请求锁而阻塞的线程看到，
         * 使他们继续向下执行。这就会造成数据的不一致
         */
        thread1.stop();

        /**
         * 该方法已废弃
         * 该方法执行,线程会一直保持对锁的占有，
         * 一直到其他的线程调用resume方法，它才能继续向下执行。
         */
        thread1.suspend();

        /**
         * 该方法已废弃
         * 唤醒suspend的线程
         */
        thread1.resume();
    }
    /********************创建创建的几种方式******************/
    /**
     * 创建无返回值线程
     */
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    /**
     * 创建无返回值线程
     */
    public static class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    /**
     * 创建有返回值线程
     */
    public static class Thread3 implements Callable<String>{

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
}

