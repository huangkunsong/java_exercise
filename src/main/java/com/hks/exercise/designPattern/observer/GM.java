package com.hks.exercise.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class GM implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察到" + arg + "开始玩游戏");
    }
}
