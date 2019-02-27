package com.hks.exercise.designPattern.command;

/**
 * 抽象命令类
 */
public abstract class Command {

    TV tv;

    public Command(TV tv) {
        this.tv = tv;
    }

    public abstract void execute();
}
