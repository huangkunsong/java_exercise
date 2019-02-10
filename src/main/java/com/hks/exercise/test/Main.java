package com.hks.exercise.test;

public class Main {
    public static void main(String[] args) {
        A a = new B();
        new Thread(a).start();
    }
}
