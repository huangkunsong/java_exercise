package com.hks.exercise.designPattern.builder.two;

public class ProductBuilder {
    private String name;
    private String color;

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setName(this.name);
        product.setColor(this.color);
        return product;
    }
}
