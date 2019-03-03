package com.hks.exercise.designPattern.state;

public class CloseState extends Lift {
    @Override
    public void run() {
        System.out.println("电梯启动运行。");
        this.manager.setLiftState(new RunState());
    }

    @Override
    public void open() {
        System.out.println("电梯打开。");
        this.manager.setLiftState(new OpenState());
    }

    @Override
    public void close() {
        System.out.println("电梯已经关闭。");
    }

    @Override
    public void stop() {
        System.out.println("电梯未在运行中。");
    }
}
