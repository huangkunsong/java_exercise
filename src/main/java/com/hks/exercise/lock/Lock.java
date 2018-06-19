package com.hks.exercise.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * 公平锁:
 *  线程按照执行顺序排成一排，依次获取锁，但是这种方式在高并发的场景下极其损耗性能；
 * 非公平锁：
 *  不管执行顺序，每个线程获取锁的几率都是相同的(导致有的线程永远无法获取锁)，
 *  获取失败了，才会采用像公平锁那样的方式。
 *  这样做的好处是，JVM可以花比较少的时间在线程调度上，更多的时间则是用在执行逻辑代码里面。
 * Lock显示锁,用于替换synchronized隐式锁。
 * 锁对细粒度的控制支持多种方法，因此它们比隐式的监视器具有更大的开销。
 * 需要自己控制开锁,解锁。
 *
 * ReentrantLock：互斥可重入锁
 * ReentrantReadWriteLock：读写锁
 * StampedLock：
 *      JDK8,和ReentrantReadWriteLock一样,支持读写锁
 *      StampedLock的锁方法会返回表示为long的标记。
 *      你可以使用这些标记来释放锁，或者检查锁是否有效。
 *      此外，StampedLock支持另一种叫做乐观锁（optimistic locking）的模式。
 *      没有实现重入特性。每次调用加锁都会返回一个新的标记，
 *      并且在没有可用的锁时阻塞，即使相同线程已经拿锁了。
 *      所以你需要额外注意不要出现死锁。
 */
public class Lock {
    /**
     * 互斥可重入锁，与通过synchronized访问的隐式监视器具有相同行为
     * 默认创建为非公平锁,
     * 构造参数传true为创建公平锁
     */
    ReentrantLock lock = new ReentrantLock();

    /**
     * 读写锁
     * 读锁可以同时执行,写锁执行时,读写都要等待获取锁.
     * 要执行写锁要等到所有读写锁都释放后才可以执行
     */
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void reentrantLock() throws InterruptedException {
        /**
         * 获取锁,实例作用域
         */
        lock.lock();

        /**
         * 释放锁,一般放在finally中执行
         */
        lock.unlock();

        /**
         * 查询lock 是否被任意线程所持有
         */
        System.out.println(lock.isLocked());

        /**
         * 查询当前线程是否获得锁
         */
        System.out.println(lock.isHeldByCurrentThread());

        /**
         * 查询等待锁的线程数
         */
        lock.getHoldCount();

        /**
         * 是否公平锁
         */
        System.out.println(lock.isFair());

        /**
         * 是否有线程在等待锁
         */
        lock.hasQueuedThreads();

        /**
         * 获取锁等待1S,获取到返回true
         */
        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
        }

        /**
         * 正在等待获取锁,可以响应中断,即中断线程的等待状态。
         */
        lock.lockInterruptibly();

    }

    public void readLock() throws InterruptedException {
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.lock();
        System.out.println("Read start");
        Thread.sleep(1000);
        System.out.println("Read end");
    }

    public void writeLock() {
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        writeLock.lock();
    }

    public void stampedLock() {
        StampedLock stampedLock = new StampedLock();
        long readStamp = stampedLock.readLock();
        stampedLock.unlockRead(readStamp);
        long writeStamp = stampedLock.writeLock();
        stampedLock.unlockWrite(writeStamp);

        /**
         * 乐观的读锁通过调用tryOptimisticRead()获取，
         * 它总是返回一个标记而不阻塞当前线程，乐观锁不阻止其他线程同时获取写锁。
         * 写锁被执行时，乐观的读锁就不再有效了。甚至当写锁释放时，乐观的读锁还处于无效状态。
         * 如果已经有写锁被拿到，返回的标记等于0。
         * 你需要总是通过lock.validate(stamp)检查标记是否有效。
         *
         */
        long optStamp = stampedLock.tryOptimisticRead();
        stampedLock.validate(optStamp);

        /**
         * 将读锁转换为写锁,不会阻塞执行
         */
        long readId = stampedLock.readLock();
        readId = stampedLock.tryConvertToWriteLock(readId);
        //0L表示当前没有可用的写锁。
        if (readId == 0L) {
            readId = stampedLock.writeLock();
        }

        /**
         * 将写锁转换为读锁
         */
        stampedLock.tryConvertToReadLock(stampedLock.writeLock());
    }

}
