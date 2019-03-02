package com.hks.exercise.designPattern.decorator;

public class SwimDecorator extends GamePalyerDecorator {
    public SwimDecorator(IGamePlayer gamePlayer) {
        super(gamePlayer);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("游泳.");
    }
}
