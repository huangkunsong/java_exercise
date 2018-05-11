package com.hks.exercise.rxJava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class RxJava {
    public static void main(String[] args) {
        /**
         * 被观察者,决定什么时候触发事件及触发什么事件。
         */
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("11111");
                subscriber.onCompleted();
            }
        });
        /**
         * 观察者,决定事件触发时有什么行为
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("observer事件触发结束。");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("observer事件触发异常。");
            }

            @Override
            public void onNext(String s) {
                System.out.println("observer触发事件,接收：" + s);
            }
        };
        /**
         * 实现了Observer,多了start和unsubscribe（用于取消订阅）
         */
        Subscriber<String> subscriber = new Subscriber<String>(){
            @Override
            public void onCompleted() {
                System.out.println("subscriber事件触发结束。");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("subscriber事件触发异常。");
            }

            @Override
            public void onNext(String s) {
                System.out.println("subscriber触发事件,接收：" + s);
            }

            @Override
            public void onStart() {
                System.out.println("subscriber事件开始");
            }
        };

        /**
         * 触发事件
         */
        observable.subscribe(observer);
        observable.subscribe(subscriber);

        Schedulers.io();
    }
}
