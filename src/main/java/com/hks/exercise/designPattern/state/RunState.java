package com.hks.exercise.designPattern.state;

public class RunState extends Lift {
    @Override
    public void run() {
        System.out.println("电梯运行中。");
    }

    @Override
    public void open() {
        System.out.println("电梯要先停止。");
    }

    @Override
    public void close() {
        System.out.println("电梯要先停止。");
    }

    @Override
    public void stop() {
        System.out.println("电梯停止。");
        this.manager.setLiftState(new StopState());
    }
}
