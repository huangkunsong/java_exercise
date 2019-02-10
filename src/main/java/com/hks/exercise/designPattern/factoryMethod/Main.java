package com.hks.exercise.designPattern.factoryMethod;

import com.hks.exercise.designPattern.factoryMethod.entity.Cat;
import com.hks.exercise.designPattern.factoryMethod.entity.Dog;

/**
 * 工厂方法：定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类中。
 * 将实例化由具体的子类工厂完成,不将所有实例化放在一个工厂内
 * 扩展新类型时,创建新的工厂子类即可完成扩展,不用修改工厂类
 *
 * 当只有一个子类工厂时,可以移除抽象工厂,并将实例化方法静态化,此时为简单工厂。
 *
 * 很多框架中工厂类去读取配置文件,根据配置反射完成具体的实例化,而不需要根据type来实例化
 */
public class Main {
    public static void main(String[] args) {
        DogFactory dogFactory = new DogFactory();
        Dog dog = dogFactory.build("Husky");
        dog.run();

        CatFactory catFactory = new CatFactory();
        Cat cat = catFactory.build("Wild");
        cat.eat();

    }
}
