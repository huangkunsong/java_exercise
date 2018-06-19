package com.hks.exercise.lock;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在Condition中，用await()替换wait()，
 * 用signal()替换notify()，用signalAll()替换notifyAll()，
 * 传统线程的通信方式，Condition都可以实现，这里注意，
 * Condition是被绑定到Lock上的，要创建一个Lock的Condition必须用newCondition()方法。
 *
 * Condition的强大之处在于它可以为多个线程间建立不同的Condition，
 * 使用synchronized/wait()只有一个阻塞队列，notifyAll会唤起所有阻塞队列下的线程，
 * 而使用lock/condition，可以实现多个阻塞队列，signalAll只会唤起某个阻塞队列下的阻塞线程。
 *
 * 当生产者执行put方法时，调用notEmpty.signalAll()只会唤醒notEmpty.await()下的消费者线程。
 * 当消费者执行take方法时，调用notFull.signalAll()只会唤醒notFull.await()下的消费者线程。
 */
public class LockCondition {
    public static void main(String[] arg) {
        Buffer2 buffer = new Buffer2(10);
        Producer2 producer = new Producer2(buffer);
        Consumer2 consumer = new Consumer2(buffer);
        for (int i = 0; i < 3; i++) {
            new Thread(producer, "producer-" + i).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(consumer, "consumer-" + i).start();
        }
    }
}

class Buffer2 {
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    private int maxSize;
    private List<Date> storage;

    Buffer2(int size) {
        //使用锁lock，并且创建两个condition，相当于两个阻塞队列
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        maxSize = size;
        storage = new LinkedList<>();
    }

    public void put() {
        lock.lock();
        try {
            while (storage.size() == maxSize) {//如果队列满了
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                ;
                notFull.await();//阻塞生产线程
            }
            storage.add(new Date());
            System.out.print(Thread.currentThread().getName() + ": put:" + storage.size() + "\n");
            Thread.sleep(1000);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (storage.size() == 0) {//如果队列满了
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                ;
                notEmpty.await();//阻塞消费线程
            }
            Date d = ((LinkedList<Date>) storage).poll();
            System.out.print(Thread.currentThread().getName() + ": take:" + storage.size() + "\n");
            Thread.sleep(1000);
            notFull.signalAll();//唤醒生产线程

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer2 implements Runnable {
    private Buffer2 buffer;

    Producer2(Buffer2 b) {
        buffer = b;
    }

    @Override
    public void run() {
        while (true) {
            buffer.put();
        }
    }
}

class Consumer2 implements Runnable {
    private Buffer2 buffer;

    Consumer2(Buffer2 b) {
        buffer = b;
    }

    @Override
    public void run() {
        while (true) {
            buffer.take();
        }
    }
}