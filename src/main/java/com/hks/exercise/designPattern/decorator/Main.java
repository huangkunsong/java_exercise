package com.hks.exercise.designPattern.decorator;

/**
 * 装饰器模式：动态的给一个对象添加一些额外责任。就增加功能来说,装饰模式相对子类更为灵活
 * 优点：
 *      1：装饰类和被装饰类可以独立发展,而不会相互耦合。
 *      2：装饰模式是继承关系的一个替代方案。不管装饰多少层返回的还是GamePlayer,实现的是is-a的关系
 *      3：装饰器可以动态的扩展一个实现类的功能。
 * JAVA IO类很多使用装饰器进行功能扩展
 */
public class Main {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new SwimDecorator(new RunDecorator(new GamePlayer()));
        gamePlayer.play();
    }
}
