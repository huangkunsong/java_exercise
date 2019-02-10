package com.hks.exercise.designPattern.factoryMethod.entity;

public class TeddyDog extends Dog{
    @Override
    public void shout() {
        System.out.println("泰迪");
    }

    @Override
    public void run() {
        System.out.println("泰迪跑");
    }
}
