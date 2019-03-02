package com.hks.exercise.designPattern.adapter;

public class Adapter extends Adaptee implements Target{
    @Override
    public void doSomething() {
        this.operations();
    }
}
