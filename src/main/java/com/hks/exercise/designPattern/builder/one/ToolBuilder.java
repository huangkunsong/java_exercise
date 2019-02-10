package com.hks.exercise.designPattern.builder.one;

public class ToolBuilder extends Builder {

    public ToolBuilder() {
        this.product = new Product();
    }

    @Override
    public void buildName() {
        this.product.setName("工具");
    }

    @Override
    public void buildColor() {
        this.product.setColor("白色");
    }
}
