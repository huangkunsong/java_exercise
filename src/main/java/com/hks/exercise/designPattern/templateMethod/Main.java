package com.hks.exercise.designPattern.templateMethod;

/**
 * 模板方法模式
 * 准备一个抽象类,将部分逻辑以具体方法以及具体构造函数的形式实现,
 * 然后声明一些抽象方法来迫使子类实现剩余的逻辑。
 * 不同的子类可以以不同的方式实现这些抽象方法,从而对剩余的逻辑有不同的实现。
 * 这就是模板方法模式的用意。
 */
public class Main {
    public static void main(String[] args) {
        AssemblyComputerTemplate template = new AmdAssemblyComputerTemplate();
        template.buildUp();
        
        template = new InterAssemblyComputerTemplate();
        template.buildUp();
    }
}
