package com.hks.exercise.designPattern.builder.one;

public class Director {
    Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        this.builder.buildName();
        this.builder.buildColor();
        return this.builder.getProduct();
    }
}
