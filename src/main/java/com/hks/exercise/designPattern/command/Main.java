package com.hks.exercise.designPattern.command;

/**
 * 命令模式属于对象的行为模式。命令模式又称为行动(Action)模式或交易(Transaction)模式。
 * 命令模式把一个请求或者操作封装到一个对象中。
 * 命令模式允许系统使用不同的请求把客户端参数化,对请求排队或者记录请求日志,可以提供命令的撤销和恢复功能。
 *
 * 命令模式是对命令的封装。命令模式把发出命令的责任和执行命令的责任分割开，委派给不同的对象。
 * 每一个命令都是一个操作：请求的一方发出请求要求执行一个操作；接收的一方收到请求，并执行操作。
 * 命令模式允许请求的一方和接收的一方独立开来,使得请求的一方不必知道接收请求的一方的接口,
 * 更不必知道请求是怎么被接收,以及操作是否被执行、何时被执行,以及是怎么被执行的。
 */
public class Main {
    public static void main(String[] args) {
        TV sharpTV = new SharpTV();
        TV skyworthTV = new SkyworthTV();
        Command openCommand = new OpenTVCommand(sharpTV);
        Command closeCommand = new CloseTVCommand(sharpTV);
        Command changeStattionCommand = new ChangeStationCommand(sharpTV);
        Command testCommand = new TestTVCommand(skyworthTV);

        RemoteControl remoteControl = new RemoteControl(openCommand, closeCommand,
                                                        changeStattionCommand, testCommand);
        remoteControl.openTV();
        remoteControl.changeStation();
        remoteControl.closeTV();
        remoteControl.testTV();

    }
}
