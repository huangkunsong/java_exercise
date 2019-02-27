package com.hks.exercise.designPattern.command;

public class SkyworthTV implements TV {
    @Override
    public void open() {
        System.out.println("创维电视开启.");
    }

    @Override
    public void close() {
        System.out.println("创维电视关闭.");
    }

    @Override
    public void changeStation() {
        System.out.println("创维电视切换频道.");
    }
}
