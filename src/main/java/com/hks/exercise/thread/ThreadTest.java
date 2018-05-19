package com.hks.exercise.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "123123";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new ThreadTest());
        Thread thread = new Thread(futureTask, "123");
        thread.start();
        thread.start();
        System.out.println("qqqq");
        System.out.println(futureTask.get());
    }

}
