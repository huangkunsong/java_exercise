package com.hks.exercise.designPattern.builder.one;

public class ToyBuilder extends Builder {

    public ToyBuilder() {
        product = new Product();
    }

    @Override
    public void buildName() {
        product.setName("玩具");
    }

    @Override
    public void buildColor() {
        product.setColor("红色");
    }
}
