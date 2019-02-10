package com.hks.exercise.designPattern.factoryMethod.entity;

public class WildCat extends Cat{

    @Override
    public void eat() {
        System.out.println("野猫吃");
    }

    @Override
    public void shout() {
        System.out.println("野猫");
    }
}
