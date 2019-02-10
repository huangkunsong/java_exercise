package com.hks.exercise.designPattern.builder.two;

/**
 * 链式构造器
 */
public class Main {
    public static void main(String[] args) {
        Product product = new ProductBuilder().setColor("黄色").setName("玩具").build();
        System.out.println(product);
    }
}
