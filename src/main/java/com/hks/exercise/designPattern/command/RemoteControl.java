package com.hks.exercise.designPattern.command;

/**
 * 请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。
 * 一个行动方法可以调用多个命令
 */
public class RemoteControl {

    private Command openCommand;
    private Command closeCommand;
    private Command changeStationCommand;
    private Command testCommand;

    public RemoteControl(Command openCommand, Command closeCommand,
                         Command changeStationCommand, Command testCommand) {
        this.openCommand = openCommand;
        this.closeCommand = closeCommand;
        this.changeStationCommand = changeStationCommand;
        this.testCommand = testCommand;
    }

    public void openTV() {
        this.openCommand.execute();
    }

    public void closeTV() {
        this.closeCommand.execute();
    }

    public void changeStation() {
        this.changeStationCommand.execute();
    }

    public void testTV() {
        this.testCommand.execute();
    }
}
