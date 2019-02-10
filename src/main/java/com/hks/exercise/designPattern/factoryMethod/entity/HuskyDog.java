package com.hks.exercise.designPattern.factoryMethod.entity;

public class HuskyDog extends Dog{
    @Override
    public void shout() {
        System.out.println("哈士奇");
    }

    @Override
    public void run() {
        System.out.println("哈士奇跑");
    }
}
