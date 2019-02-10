package com.hks.exercise.designPattern.builder.one;

/**
 * 建造者模式
 * 将一个复杂对象的构建与它的表示分离,使得同样的构建过程可以构建不同的表示
 */
public class Main {
    public static void main(String[] args) {
        Builder builder = new ToolBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}
