package com.hks.exercise.designPattern.factoryMethod.entity;

public class PersianCat extends Cat{

    @Override
    public void eat() {
        System.out.println("波斯猫吃");
    }

    @Override
    public void shout() {
        System.out.println("波斯");
    }
}
