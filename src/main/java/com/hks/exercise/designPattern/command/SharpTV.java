package com.hks.exercise.designPattern.command;

/**
 *
 */
public class SharpTV implements TV {
    @Override
    public void open() {
        System.out.println("夏普电视开启.");
    }

    @Override
    public void close() {
        System.out.println("夏普电视关闭.");
    }

    @Override
    public void changeStation() {
        System.out.println("夏普电视切换频道.");
    }
}
