package com.hks.exercise.designPattern.abstractFactory;

/**
 * 产品族：是指位于不同产品等级结构中，功能相关联的产品组成的家族。
 *      如：电脑（CPU,主板,内存）等组成的一个产品族
 * 等级结构：同一个产品的不同等级
 *      如：内存（DDR3,DDR4）
 * 工厂方法模式针对的是一个产品等级结构,一个工厂只创建一个类型的实例。
 * 抽象工厂模式则需要完成多个相关的产品等级结构组成的产品族。
 * 优点：
 *      使切换产品族变得容易
 * 缺点：
 *      如果需要给整个产品族添加一个新的产品，那么就需要修改抽象工厂，这样就会导致修改所有的工厂实现类。
 */
public class Main {
    public static void main(String[] args) {
        ComputerEngineer engineer = new ComputerEngineer();
        engineer.makeComputer(new AmdFactory());
        engineer.makeComputer(new IntelFactory());
    }
}
