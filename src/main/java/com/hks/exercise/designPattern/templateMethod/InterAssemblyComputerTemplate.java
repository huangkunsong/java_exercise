package com.hks.exercise.designPattern.templateMethod;

public class InterAssemblyComputerTemplate extends AssemblyComputerTemplate {
    @Override
    public void getCPU() {
        System.out.println("英特尔CPU");
    }

    @Override
    public void getMotherboard() {
        System.out.println("英特尔主板");
    }

    @Override
    public void getRAM() {
        System.out.println("英特尔内存");
    }
}
