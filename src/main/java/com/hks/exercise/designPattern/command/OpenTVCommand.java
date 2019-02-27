package com.hks.exercise.designPattern.command;

public class OpenTVCommand extends Command {
    public OpenTVCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        this.tv.open();
    }
}
