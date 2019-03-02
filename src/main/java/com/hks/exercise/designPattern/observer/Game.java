package com.hks.exercise.designPattern.observer;

import java.util.Observable;

public class Game extends Observable {

    public void player(String name) {
        System.out.println(name + "开始玩游戏");

        /**
         * 需要设置改变,才会通知观察者
         */
        this.setChanged();
        this.notifyObservers(name);
    }
}
