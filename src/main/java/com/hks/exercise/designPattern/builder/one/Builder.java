package com.hks.exercise.designPattern.builder.one;

public abstract class Builder {
    protected Product product;

    public abstract void buildName();

    public abstract void buildColor();

    public Product getProduct() {
        return this.product;
    }
}
