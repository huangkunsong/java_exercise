package com.hks.exercise.designPattern.command;

public class CloseTVCommand extends Command {
    public CloseTVCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        this.tv.close();
    }
}
