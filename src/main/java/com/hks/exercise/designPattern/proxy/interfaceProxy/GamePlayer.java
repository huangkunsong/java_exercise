package com.hks.exercise.designPattern.proxy.interfaceProxy;

public class GamePlayer implements IGamePlayer {
    @Override
    public void player() {
        System.out.println("玩耍中....");
    }
}
