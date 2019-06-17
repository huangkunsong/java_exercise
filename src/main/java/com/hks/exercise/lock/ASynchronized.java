package com.hks.exercise.lock;

/**
 * synchronized关键字
 * 两种作用域：
 * 1：实例作用域
 *  同一个实例,只要一个线程访问了其中的一个synchronized方法,
 *  其它线程不能同时访问这个对象中任何一个synchronized方法,synchronized代码块。
 * 2：类作用域
 *  防止多个线程同时访问这个类中的synchronized static 方法。
 *  它可以对类的所有对象实例起作用。
 * synchronized关键字是不能继承的,
 * 基类的synchronized方法,在继承类中并不自动是synchronized。
 *
 * synchronized
 *  当一个线程处于等待某个锁的状态，是无法被中断的，只有一直等待下去。
 *  非公平锁
 */
public class ASynchronized {
    /**
     * 修饰方法,实例作用域,同一个实例中,
     * 只有一个线程可以访问该类的synchronized方法
     */
    public synchronized void a(){
        try {
            Thread.sleep(1000);
            System.out.println("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b(){
        /**
         * 修饰代码块,实例作用域。
         */
        synchronized (this) {
            System.out.println("b");
        }
    }

    /**
     * 修饰静态方法,类作用域。
     * 所有线程,实例同一时刻只有一个线程可以执行类只有的静态方法
     */
    public synchronized static void c() {
        try {
            System.out.println("c start" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("c end" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void d() {
        /**
         * 修饰类,类作用域
         */
        synchronized (ASynchronized.class){
            System.out.println("d start" + Thread.currentThread().getName());
        }
    }
}
