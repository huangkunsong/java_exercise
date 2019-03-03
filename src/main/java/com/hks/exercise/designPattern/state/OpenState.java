package com.hks.exercise.designPattern.state;

public class OpenState extends Lift {

    @Override
    public void run() {
        System.out.println("要先关闭电梯。");
    }

    @Override
    public void open() {
        System.out.println("电梯已经打开。");
    }

    @Override
    public void close() {
        System.out.println("电梯已经关闭。");
        this.manager.setLiftState(new CloseState());
    }

    @Override
    public void stop() {
        System.out.println("电梯未在运行中。");
    }
}
