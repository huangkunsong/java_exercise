package com.hks.exercise.designPattern.templateMethod;

public class AmdAssemblyComputerTemplate extends AssemblyComputerTemplate{

    @Override
    public void getCPU() {
        System.out.println("AMD CPU");
    }

    @Override
    public void getMotherboard() {
        System.out.println("AMD 主板");
    }

    @Override
    public void getRAM() {
        System.out.println("AMD 内存");
    }
}
