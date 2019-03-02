package com.hks.exercise.designPattern.observer;

/**
 * 观察者模式（发布订阅模式）：
 *      定义对象间一种一对多的依赖关系,使得每当一个对象状态改变,
 *      则所有依赖于它的对象都会得到通知并自动更新。
 * Subject：被观察者,必须能够动态的添加,取消观察者。
 * Observer：观察者,收到消息后进行操作。
 *
 * 优点：
 *      建立了一套触发机制,添加和删除观察方便。
 *      两者独立改变,互不影响
 * 缺点：
 *      不开多线程时,观察者过多会影响性能
 * Java1.0开始内置被观察者类：Observable 和观察者接口：Observer
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GM gm = new GM();
        game.addObserver(gm);
        game.player("张三");
    }
}
