package com.hks.exercise.designPattern.decorator;

public class RunDecorator extends GamePalyerDecorator {


    public RunDecorator(IGamePlayer gamePlayer) {
        super(gamePlayer);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("奔跑.");
    }
}
