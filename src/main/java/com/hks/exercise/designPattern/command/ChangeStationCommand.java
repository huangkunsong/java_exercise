package com.hks.exercise.designPattern.command;

public class ChangeStationCommand extends Command {

    public ChangeStationCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        this.tv.changeStation();
    }
}
