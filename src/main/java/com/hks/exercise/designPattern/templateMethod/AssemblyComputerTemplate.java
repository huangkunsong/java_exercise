package com.hks.exercise.designPattern.templateMethod;

/**
 * 组装电脑模板类
 *
 */
public abstract class AssemblyComputerTemplate {
    protected abstract void getCPU();
    protected abstract void getMotherboard();
    protected abstract void getRAM();

    public final void buildUp() {
        System.out.println("开始组装");
        System.out.print("组装CPU：");
        getCPU();
        System.out.print("组装主板：");
        getMotherboard();
        System.out.print("组装内存：");
        getRAM();
        System.out.println("组装完成");
    }
}
