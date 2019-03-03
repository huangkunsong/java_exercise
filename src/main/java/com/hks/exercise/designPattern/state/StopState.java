package com.hks.exercise.designPattern.state;

public class StopState extends Lift {
    @Override
    public void run() {
        System.out.println("电梯运行。");
        this.manager.setLiftState(new RunState());
    }

    @Override
    public void open() {
        System.out.println("电梯打开。");
        this.manager.setLiftState(new OpenState());
    }

    @Override
    public void close() {
        System.out.println("电梯关闭。");
        this.manager.setLiftState(new CloseState());
    }

    @Override
    public void stop() {
        System.out.println("电梯已经停止。");
    }
}
