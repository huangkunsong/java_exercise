package com.hks.exercise.designPattern.decorator;

public class GamePlayer implements IGamePlayer {
    @Override
    public void play() {
        System.out.println("玩游戏.");
    }
}
