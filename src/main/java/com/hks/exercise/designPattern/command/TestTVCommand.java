package com.hks.exercise.designPattern.command;

/**
 * 一个命令就是一个操作
 * 完成一个操作可以由很多步骤组成
 */
public class TestTVCommand extends Command {

    public TestTVCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        this.tv.open();
        this.tv.changeStation();
        this.tv.close();
    }
}
