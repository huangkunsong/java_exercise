package com.hks.exercise.rxJava;

import rx.Observable;
import rx.schedulers.Schedulers;

public class ThreadRxJava {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4)
            // 指定 subscribe() 发生在 IO 线程
            .subscribeOn(Schedulers.immediate())
            // 指定 Subscriber 的回调发生在主线程
            .observeOn(Schedulers.io())
            .subscribe(number -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println(number);
            })
            ;
        System.out.println("123123");
        /*String[] names = new String[]{"asdasdasd",":asdasd"};
        Observable.from(names)
            .subscribe(name -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println(name);
            });*/
    }
}
