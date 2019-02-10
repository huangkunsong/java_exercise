package com.hks.exercise.test;

public class A implements Runnable{

    public void c() {
        System.out.println("aaaa");
    }

    @Override
    public void run() {
        System.out.println("run");
        this.c();
    }
}
