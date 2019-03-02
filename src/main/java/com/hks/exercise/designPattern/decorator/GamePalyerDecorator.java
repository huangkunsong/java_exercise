package com.hks.exercise.designPattern.decorator;

public abstract class GamePalyerDecorator implements IGamePlayer{
    private IGamePlayer gamePlayer;

    public GamePalyerDecorator(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void play() {
        this.gamePlayer.play();
    }
}
