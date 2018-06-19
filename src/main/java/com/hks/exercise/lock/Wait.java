package com.hks.exercise.lock;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Wait {

    public static void main(String[] args) {
        Buffer buffer=new Buffer(10);
        Producer producer=new Producer(buffer);
        Consumer consumer=new Consumer(buffer);
        //创建线程执行生产和消费
        for(int i=0;i<3;i++){
            new Thread(producer,"producer-"+i).start();
        }
        for(int i=0;i<3;i++){
            new Thread(consumer,"consumer-"+i).start();
        }
    }
}

class Buffer {
    private int maxSize;
    private List<Date> storage;

    Buffer(int size) {
        this.maxSize = size;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        try {
            while (storage.size() == maxSize) {
                System.out.println(Thread.currentThread().getName() + ",队列满了");
                wait();
            }
            storage.add(new Date());
            System.out.println(Thread.currentThread().getName() +
                ",put：" + storage.size());
            Thread.sleep(1000);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void take() {
        try {
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "队列空了");
                wait();
            }
            Date d = ((LinkedList<Date>)storage).poll();
            System.out.println(Thread.currentThread().getName() +
                ",task：" + storage.size());
            Thread.sleep(1000);
            notifyAll();
        } catch (InterruptedException e) {

        }
    }
}
//生产者
class Producer implements Runnable{
    private Buffer buffer;
    Producer(Buffer b){
        buffer=b;
    }
    @Override
    public void run() {
        while(true){
            buffer.put();
        }
    }
}
//消费者
class Consumer implements Runnable{
    private Buffer buffer;
    Consumer(Buffer b){
        buffer=b;
    }
    @Override
    public void run() {
        while(true){
            buffer.take();
        }
    }
}