package com.hks.exercise.designPattern.simpleFactory;

import com.hks.exercise.designPattern.simpleFactory.entity.Animal;

/**
 * 简单工厂,不属于设计模式
 * 优点：
 *      可以决定在什么时候创建哪一个类的实例，而调用者则可以免除直接创建对象的责任
 *      简单工厂模式通过这种做法实现了对责任的分割.
 * 缺点：
 *      这个工厂类集中了所以的创建逻辑，当有复杂的多层次等级结构时，所有的业务逻辑都在这个工厂类中实现。
 *      扩展新的类都需要修改工厂,不符合开闭原则
 */
public class Main {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.builder("DOG");
        animal.shout();

        animal = AnimalFactory.builder("CAT");
        animal.shout();
    }
}
