package com.hks.exercise.designPattern.state;

/**
 * 定义实例业务操作
 * 具体操作以状态纬度处理
 */
public abstract class Lift {

    protected LiftManager manager;

    public void setManager(LiftManager manager) {
        this.manager = manager;
    }

    public abstract void run();

    public abstract void open();

    public abstract void close();

    public abstract void stop();
}
